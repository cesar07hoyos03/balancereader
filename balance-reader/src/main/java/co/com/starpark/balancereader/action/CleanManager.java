package co.com.starpark.balancereader.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.starpark.balancereader.main.Launcher;
import co.com.starpark.balancereader.view.BalanceReader;

public class CleanManager implements Runnable {

	private BalanceReader view;

	private static final Logger logger = LogManager.getLogger(CleanManager.class.getName());

	public CleanManager(BalanceReader view) {
		this.view = view;
	}

	@Override
	public void run() {
		int seconds = Integer.parseInt(Launcher.config.getProperty("balancereader.config.cleantime"));
		try {

			logger.debug("Cleaning screen in [{}] seconds ", seconds);
			Thread.sleep(seconds * 1000);
			view.getLblPoints().setText("");
			view.getLblCash().setText("");
			view.getLblBonus().setText("");
			view.getDialog().dispose();
			view.getTxtAccountId().setEnabled(true);
			view.getTxtAccountId().requestFocus();
			logger.debug("Done cleaning!");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
