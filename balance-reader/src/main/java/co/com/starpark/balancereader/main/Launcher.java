package co.com.starpark.balancereader.main;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.starpark.balancereader.view.BalanceReader;

public class Launcher {

	private static final Logger logger = LogManager.getLogger(Launcher.class.getName());
	private static ClassLoader classLoader = Launcher.class.getClassLoader();
	public static Properties config = new Properties();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			config.load(classLoader.getResourceAsStream("balancereader.properties"));
		} catch (Exception e) {
			logger.error("", e);
		}

		String title = "\n\n\n";
		try (Scanner sc = new Scanner(classLoader.getResourceAsStream("log-template.txt"))) {

			while (sc.hasNextLine()) {
				title += sc.nextLine() + "\n";
			}
		}

		logger.info(title);
		logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							logger.info("Setting Nimbus look and feel");
							break;
						}
					}
					// View window = new View();
					BalanceReader window = new BalanceReader();
					window.setVisible(true);
				} catch (Exception e) {
					logger.error("Error loading window ", e);
				}
			}
		});
	}

}
