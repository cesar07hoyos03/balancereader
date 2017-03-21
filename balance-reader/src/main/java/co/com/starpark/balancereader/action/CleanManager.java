package co.com.starpark.balancereader.action;

import co.com.starpark.balancereader.main.Launcher;
import co.com.starpark.balancereader.view.BalanceReader;

public class CleanManager implements Runnable {

	private BalanceReader view;

	public CleanManager(BalanceReader view) {
		this.view = view;
	}

	@Override
	public void run() {
		int seconds = Integer.parseInt(Launcher.config.getProperty("balancereader.config.cleantime"));
		try {
			Thread.sleep(seconds * 1000);
			view.getLblPoints().setText("");
			view.getLblCash().setText("");
			view.getLblBonus().setText("");
		} catch (InterruptedException e) {
		}
	}

}
