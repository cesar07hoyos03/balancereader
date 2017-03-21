package co.com.starpark.balancereader.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ErrorDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6055933858531507108L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ErrorDialog() {
		setModalityType(ModalityType.MODELESS);
		setResizable(false);
		setBounds(0, 0, 700, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 128, 114));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			JLabel lblServidorNoDisponible = new JLabel("SERVIDOR NO DISPONIBLE");
			lblServidorNoDisponible.setHorizontalAlignment(SwingConstants.CENTER);
			lblServidorNoDisponible.setFont(new Font("Tahoma", Font.PLAIN, 50));
			lblServidorNoDisponible.setBackground(new Color(250, 128, 114));
			lblServidorNoDisponible.setForeground(new Color(255, 255, 255));
			contentPanel.add(lblServidorNoDisponible);
		}
	}

}
