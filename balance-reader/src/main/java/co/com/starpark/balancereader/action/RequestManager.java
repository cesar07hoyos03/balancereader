package co.com.starpark.balancereader.action;

import java.io.OutputStream;
import java.net.Socket;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.starpark.balancereader.main.Launcher;
import co.com.starpark.balancereader.view.BalanceReader;
import co.com.starpark.balancereader.xmlparser.XMLBalanceRequest;
import co.com.starpark.balancereader.xmlparser.XMLBalanceRequest.BalanceInquiry;
import co.com.starpark.balancereader.xmlparser.XMLBalanceRequest.TransactionRequest;
import co.com.starpark.balancereader.xmlparser.XMLBalanceRequest.TransactionRequest.EmployeeName;
import co.com.starpark.balancereader.xmlparser.XMLBalanceResponse;

public class RequestManager implements Runnable {

	private BalanceReader view;

	private int accountNumber;

	private static final Logger logger = LogManager.getLogger(RequestManager.class.getName());

	public RequestManager(BalanceReader view, int accountNumber) {
		this.view = view;
		this.accountNumber = accountNumber;

	}

	@Override
	public void run() {
		try {
			boolean testMode = Boolean.valueOf(Launcher.config.getProperty("balancereader.config.testmode"));

			logger.debug("TestMode: [{}]", testMode);

			XMLBalanceRequest request = new XMLBalanceRequest();
			TransactionRequest txReq = new TransactionRequest();
			txReq.setEmployeeID(Launcher.config.getProperty("balancereader.config.employee.id"));
			EmployeeName name = new EmployeeName();
			name.setFirstName(Launcher.config.getProperty("balancereader.config.employee.firstname"));
			name.setLastName(Launcher.config.getProperty("balancereader.config.employee.lastname"));
			txReq.setEmployeeName(name);
			txReq.setLTDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			txReq.setMacAddress(Launcher.config.getProperty("balancereader.config.macaddress"));
			txReq.setRequestType("BalanceInquiry");
			txReq.setSessionID(UUID.randomUUID().toString());
			txReq.setTransactionID(UUID.randomUUID().toString());
			txReq.setUTCDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
			request.setTransactionRequest(txReq);

			BalanceInquiry balanceInquiry = new BalanceInquiry();
			balanceInquiry.setAccountNumber(testMode ? 99 : accountNumber);
			request.setBalanceInquiry(balanceInquiry);
			logger.info("Request object: {}", ReflectionToStringBuilder.toString(request));

			JAXBContext jaxbContextRequest = JAXBContext.newInstance(XMLBalanceRequest.class);
			Marshaller jaxbMarshaller = jaxbContextRequest.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Socket socket = new Socket(Launcher.config.getProperty("balancereader.config.transaction.server"),
					Integer.parseInt(Launcher.config.getProperty("balancereader.config.transaction.port")));

			OutputStream os = socket.getOutputStream();
			jaxbMarshaller.marshal(request, os);
			os.flush();

			JAXBContext jaxbContextResponse = JAXBContext.newInstance(XMLBalanceResponse.class);

			Unmarshaller jaxbUnmarshaller = jaxbContextResponse.createUnmarshaller();
			XMLBalanceResponse response = (XMLBalanceResponse) jaxbUnmarshaller.unmarshal(socket.getInputStream());

			logger.info("Response object: {}", ReflectionToStringBuilder.toString(response.getAccountBalance()));
			os.close();
			socket.close();

			view.getLblPoints().setText(Integer.toString(response.getAccountBalance().getPointBalance()));
			view.getLblCash().setText(Float.toString(response.getAccountBalance().getCashBalance()));
			view.getLblBonus().setText(Float.toString(response.getAccountBalance().getCashBonusBalance()));

			Thread cleanManager = new Thread(new CleanManager(view));
			cleanManager.start();

		} catch (Exception ex) {
			logger.error("Error", ex);
		}
	}

}
