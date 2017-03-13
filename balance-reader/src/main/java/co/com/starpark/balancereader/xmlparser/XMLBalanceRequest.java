/**
 * XML Balance Request Parser
 */
package co.com.starpark.balancereader.xmlparser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author cesar07hoyos03@gmail.com
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "transactionRequest", "balanceInquiry" })
@XmlRootElement(name = "iEnhancedInterfaceRequest")
public class XMLBalanceRequest {

	@XmlElement(name = "TransactionRequest", required = true)
	protected XMLBalanceRequest.TransactionRequest transactionRequest;

	@XmlElement(name = "BalanceInquiry", required = true)
	protected XMLBalanceRequest.BalanceInquiry balanceInquiry;

	public XMLBalanceRequest.TransactionRequest getTransactionRequest() {
		return transactionRequest;
	}

	public void setTransactionRequest(XMLBalanceRequest.TransactionRequest value) {
		this.transactionRequest = value;
	}

	public XMLBalanceRequest.BalanceInquiry getBalanceInquiry() {
		return balanceInquiry;
	}

	public void setBalanceInquiry(XMLBalanceRequest.BalanceInquiry value) {
		this.balanceInquiry = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "accountNumber" })
	public static class BalanceInquiry {

		@XmlElement(name = "AccountNumber")
		protected int accountNumber;

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int value) {
			this.accountNumber = value;
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "requestType", "macAddress", "transactionID", "sessionID", "employeeID",
			"employeeName", "ltDateTime", "utcDateTime" })
	public static class TransactionRequest {

		@XmlElement(name = "RequestType", required = true)
		protected String requestType;
		@XmlElement(name = "MacAddress", required = true)
		protected String macAddress;
		@XmlElement(name = "TransactionID")
		protected String transactionID;
		@XmlElement(name = "SessionID", required = true)
		protected String sessionID;
		@XmlElement(name = "EmployeeID", required = true)
		protected String employeeID;
		@XmlElement(name = "EmployeeName", required = true)
		protected XMLBalanceRequest.TransactionRequest.EmployeeName employeeName;
		@XmlElement(name = "LT_DateTime", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar ltDateTime;
		@XmlElement(name = "UTC_DateTime", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar utcDateTime;

		public String getRequestType() {
			return requestType;
		}

		public void setRequestType(String value) {
			this.requestType = value;
		}

		public String getMacAddress() {
			return macAddress;
		}

		public void setMacAddress(String value) {
			this.macAddress = value;
		}

		public String getTransactionID() {
			return transactionID;
		}

		public void setTransactionID(String value) {
			this.transactionID = value;
		}

		public String getSessionID() {
			return sessionID;
		}

		public void setSessionID(String value) {
			this.sessionID = value;
		}

		public String getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(String value) {
			this.employeeID = value;
		}

		public XMLBalanceRequest.TransactionRequest.EmployeeName getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(XMLBalanceRequest.TransactionRequest.EmployeeName value) {
			this.employeeName = value;
		}

		public XMLGregorianCalendar getLTDateTime() {
			return ltDateTime;
		}

		public void setLTDateTime(XMLGregorianCalendar value) {
			this.ltDateTime = value;
		}

		public XMLGregorianCalendar getUTCDateTime() {
			return utcDateTime;
		}

		public void setUTCDateTime(XMLGregorianCalendar value) {
			this.utcDateTime = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "firstName", "lastName" })
		public static class EmployeeName {

			@XmlElement(name = "FirstName", required = true)
			protected String firstName;
			@XmlElement(name = "LastName", required = true)
			protected String lastName;

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String value) {
				this.firstName = value;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String value) {
				this.lastName = value;
			}

		}

	}

}
