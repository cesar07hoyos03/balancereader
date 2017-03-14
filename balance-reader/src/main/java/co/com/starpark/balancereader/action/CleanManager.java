package co.com.starpark.balancereader.action;

import co.com.starpark.balancereader.main.Launcher;
import co.com.starpark.balancereader.view.View;

public class CleanManager implements Runnable {

	private View view;

	public CleanManager(View view) {
		this.view = view;
	}

	@Override
	public void run() {
		int seconds = Integer.parseInt(Launcher.config.getProperty("balancereader.Launcher.config.cleantime", "5"));
		try {
			Thread.sleep(seconds * 1000);
			view.getLblCashBonusValue().setText("");
			view.getLblCashValue().setText("");
			view.getLblPointsValue().setText("");
			view.getLblTokenBonusValue().setText("");
			view.getLblTokenValue().setText("");
		} catch (InterruptedException e) {
		}
	}

}
