package co.com.starpark.balancereader.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.starpark.balancereader.action.RequestManager;
import co.com.starpark.balancereader.main.Launcher;

public class BalanceReader extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7528871045016633996L;

	private static final Logger logger = LogManager.getLogger(BalanceReader.class.getName());

	private static ClassLoader classLoader = BalanceReader.class.getClassLoader();

	private JTextField txtAccountId;

	private JLabel lblPoints = new JLabel();
	private JLabel lblCash = new JLabel();
	private JLabel lblBonus = new JLabel();

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public BalanceReader() throws IOException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setLocationRelativeTo(null);
		setBounds(0, -5, 1024, 768);

		JPanel mainPanel = new JPanel();
		JLabel lblBackground = new JLabel("");
		lblBackground.setLayout(null);
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);

		mainPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(classLoader.getResourceAsStream("background.PNG"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				ImageIcon imgBackground = new ImageIcon(
						img.getScaledInstance(mainPanel.getWidth(), mainPanel.getHeight(), Image.SCALE_SMOOTH));
				lblBackground.setIcon(imgBackground);
			}
		});

		txtAccountId = new JTextField();
		txtAccountId.setBackground(new Color(255, 102, 51));
		txtAccountId.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccountId.setForeground(new Color(255, 102, 51));
		txtAccountId.setFont(new Font("Tahoma", Font.PLAIN, 5));
		txtAccountId.setMargin(new java.awt.Insets(0, 0, 0, 0));
		txtAccountId.setMaximumSize(new java.awt.Dimension(0, 0));
		txtAccountId.setMinimumSize(new java.awt.Dimension(0, 0));
		txtAccountId.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField1KeyPressed(evt);
			}
		});

		setTitle("BalanceReader");
		setIconImage(ImageIO.read(classLoader.getResourceAsStream("logo.png")));
		setContentPane(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 1, 0, 0));

		// Points
		String[] foreground1 = Launcher.config.getProperty("balancereader.config.points.foreground").split(",");
		String[] bounds1 = Launcher.config.getProperty("balancereader.config.points.bounds").split(",");

		lblPoints.setForeground(new Color(Integer.parseInt(foreground1[0]), Integer.parseInt(foreground1[1]),
				Integer.parseInt(foreground1[2])));
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN,
				Integer.parseInt(Launcher.config.getProperty("balancereader.config.points.fontsize"))));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setBounds(new Rectangle(Integer.parseInt(bounds1[0]), Integer.parseInt(bounds1[1]),
				Integer.parseInt(bounds1[2]), Integer.parseInt(bounds1[3])));

		// Cash
		String[] foreground2 = Launcher.config.getProperty("balancereader.config.cash.foreground").split(",");
		String[] bounds2 = Launcher.config.getProperty("balancereader.config.cash.bounds").split(",");

		lblCash.setForeground(new Color(Integer.parseInt(foreground2[0]), Integer.parseInt(foreground2[1]),
				Integer.parseInt(foreground2[2])));
		lblCash.setFont(new Font("Tahoma", Font.PLAIN,
				Integer.parseInt(Launcher.config.getProperty("balancereader.config.cash.fontsize"))));
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setBounds(new Rectangle(Integer.parseInt(bounds2[0]), Integer.parseInt(bounds2[1]),
				Integer.parseInt(bounds2[2]), Integer.parseInt(bounds2[3])));

		// Bonus
		String[] foreground3 = Launcher.config.getProperty("balancereader.config.bonus.foreground").split(",");
		String[] bounds3 = Launcher.config.getProperty("balancereader.config.bonus.bounds").split(",");

		lblBonus.setForeground(new Color(Integer.parseInt(foreground3[0]), Integer.parseInt(foreground3[1]),
				Integer.parseInt(foreground3[2])));
		lblBonus.setFont(new Font("Tahoma", Font.PLAIN,
				Integer.parseInt(Launcher.config.getProperty("balancereader.config.bonus.fontsize"))));
		lblBonus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonus.setBounds(new Rectangle(Integer.parseInt(bounds3[0]), Integer.parseInt(bounds3[1]),
				Integer.parseInt(bounds3[2]), Integer.parseInt(bounds3[3])));

		lblBackground.add(lblPoints);
		lblBackground.add(lblCash);
		lblBackground.add(lblBonus);

		lblBackground.add(txtAccountId);

		mainPanel.add(lblBackground);
	}

	private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
		try {
			if (evt.getKeyCode() == 10) {
				String line = txtAccountId.getText();
				txtAccountId.setText("");
				txtAccountId.requestFocus();
				line = line.substring(line.indexOf(";") + 1);
				line = line.substring(0, line.indexOf("?"));
				StringTokenizer st = new StringTokenizer(line, "=");
				st.nextToken();
				int id = Integer.parseInt(st.nextToken());
				logger.info("Account readed {}", id);

				Thread requestManager = new Thread(new RequestManager(this, id));
				requestManager.start();

			}
		} catch (Exception e) {
			// Display Error Message
			logger.error("", e);
		}
	}

	public JLabel getLblPoints() {
		return lblPoints;
	}

	public JLabel getLblBonus() {
		return lblBonus;
	}

	public JLabel getLblCash() {
		return lblCash;
	}
}
