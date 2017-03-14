package co.com.starpark.balancereader.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window.Type;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.starpark.balancereader.action.RequestManager;
import co.com.starpark.balancereader.main.Launcher;

public class View {

	private JFrame frmBalancereader;
	private JTextField txtAccountId;
	private JLabel lblAccountId = new JLabel("");
	private JLabel lblPointsValue = new JLabel("");
	private JLabel lblCashValue = new JLabel("");
	private JLabel lblCashBonusValue = new JLabel("");
	private JLabel lblTokenValue = new JLabel("");
	private JLabel lblTokenBonusValue = new JLabel("");

	private static final Logger logger = LogManager.getLogger(View.class.getName());
	private static ClassLoader classLoader = View.class.getClassLoader();

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public View() throws IOException {
		initialize();
	}

	public JFrame getFrmBalancereader() {
		return frmBalancereader;
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());

		frmBalancereader = new JFrame();
		frmBalancereader.setType(Type.NORMAL);
		frmBalancereader.setTitle("BalanceReader");
		frmBalancereader.setResizable(false);
		frmBalancereader.setBounds(0, 0, 800, 600);
		frmBalancereader.setSize(xSize, ySize);
		frmBalancereader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBalancereader.getContentPane().setLayout(new BorderLayout(0, 0));
		frmBalancereader.setExtendedState(frmBalancereader.getExtendedState() | JFrame.MAXIMIZED_BOTH);

		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 102, 51));
		frmBalancereader.getContentPane().add(northPanel, BorderLayout.NORTH);

		ImageIcon iconLogo = new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("logo.png")));

		JLabel lblTitle = new JLabel(Launcher.config.getProperty("balancereader.config.title.text"));
		lblTitle.setIcon(iconLogo);
		lblTitle.setIconTextGap(50);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		northPanel.add(lblTitle);

		JPanel southPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		southPanel.setBackground(new Color(255, 102, 51));
		frmBalancereader.getContentPane().add(southPanel, BorderLayout.SOUTH);

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
		lblAccountId.setForeground(new Color(255, 255, 255));

		southPanel.add(lblAccountId);
		southPanel.add(txtAccountId);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(new Color(255, 102, 51));
		frmBalancereader.getContentPane().add(westPanel, BorderLayout.WEST);

		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(new Color(255, 102, 51));
		frmBalancereader.getContentPane().add(eastPanel, BorderLayout.EAST);

		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		centerPanel.setBackground(new Color(255, 222, 173));
		frmBalancereader.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(2, 1, 0, 0));

		final JPanel panel1 = new JPanel();
		final JLabel lblCard = new JLabel("");
		panel1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(classLoader.getResourceAsStream("swipecard.jpg"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				ImageIcon cardLogo = new ImageIcon(
						img.getScaledInstance(panel1.getWidth(), panel1.getHeight(), Image.SCALE_SMOOTH));
				lblCard.setIcon(cardLogo);
			}
		});

		panel1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel1.setBackground(new Color(255, 255, 204));
		centerPanel.add(panel1);
		panel1.setLayout(new GridLayout(1, 1, 0, 0));

		lblCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblCard.setVerticalAlignment(JLabel.CENTER);
		panel1.add(lblCard);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel2.setBackground(new Color(255, 255, 204));
		centerPanel.add(panel2);
		panel2.setLayout(new GridLayout(0, 5, 0, 0));

		JPanel pointsPanel = new JPanel();
		pointsPanel.setBackground(new Color(255, 255, 240));
		pointsPanel.setForeground(new Color(0, 0, 0));
		pointsPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel2.add(pointsPanel);
		pointsPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel pointsLabelPanel = new JPanel();
		pointsLabelPanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		pointsLabelPanel.setBackground(new Color(255, 255, 240));
		pointsPanel.add(pointsLabelPanel);
		pointsLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblPoints = new JLabel(Launcher.config.getProperty("balancereader.config.pointbalance.text"));
		pointsLabelPanel.add(lblPoints);
		lblPoints.setForeground(new Color(128, 0, 0));
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel pointsValuePanel = new JPanel();
		pointsValuePanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		pointsValuePanel.setBackground(new Color(255, 255, 240));
		pointsPanel.add(pointsValuePanel);
		pointsValuePanel.setLayout(new GridLayout(0, 1, 0, 0));
		lblPointsValue.setBackground(new Color(255, 255, 240));
		pointsValuePanel.add(lblPointsValue);

		lblPointsValue.setForeground(new Color(0, 128, 0));
		lblPointsValue.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPointsValue.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel cashPanel = new JPanel();
		cashPanel.setBackground(new Color(255, 255, 240));
		cashPanel.setForeground(new Color(0, 0, 0));
		cashPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel2.add(cashPanel);
		cashPanel.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel cashLabelPanel = new JPanel();
		cashLabelPanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		cashLabelPanel.setBackground(new Color(255, 255, 240));
		cashPanel.add(cashLabelPanel);
		cashLabelPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblCash = new JLabel(Launcher.config.getProperty("balancereader.config.cashBalance.text"));
		lblCash.setForeground(new Color(128, 0, 0));
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblCash.setBackground(new Color(255, 255, 240));
		cashLabelPanel.add(lblCash);

		JPanel cashValuePanel = new JPanel();
		cashValuePanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		cashValuePanel.setBackground(new Color(255, 255, 240));
		cashPanel.add(cashValuePanel);
		cashValuePanel.setLayout(new GridLayout(1, 0, 0, 0));
		lblCashValue.setForeground(new Color(0, 128, 0));
		lblCashValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashValue.setFont(new Font("Tahoma", Font.PLAIN, 40));

		lblCashValue.setBackground(new Color(255, 255, 240));
		cashValuePanel.add(lblCashValue);

		JPanel cashBonusPanel = new JPanel();
		cashBonusPanel.setBackground(new Color(255, 255, 240));
		cashBonusPanel.setForeground(new Color(0, 0, 0));
		cashBonusPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel2.add(cashBonusPanel);
		cashBonusPanel.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel cashBonusLabelPanel = new JPanel();
		cashBonusLabelPanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		cashBonusLabelPanel.setBackground(new Color(255, 255, 240));
		cashBonusPanel.add(cashBonusLabelPanel);
		cashBonusLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblCashBonus = new JLabel(Launcher.config.getProperty("balancereader.config.cashBonusBalance.text"));
		lblCashBonus.setForeground(new Color(128, 0, 0));
		lblCashBonus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashBonus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblCashBonus.setBackground(new Color(255, 255, 240));
		cashBonusLabelPanel.add(lblCashBonus);

		JPanel cashBonusValuePanel = new JPanel();
		cashBonusValuePanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		cashBonusValuePanel.setBackground(new Color(255, 255, 240));
		cashBonusPanel.add(cashBonusValuePanel);
		cashBonusValuePanel.setLayout(new GridLayout(0, 1, 0, 0));

		lblCashBonusValue.setForeground(new Color(0, 128, 0));
		lblCashBonusValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashBonusValue.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblCashBonusValue.setBackground(new Color(255, 255, 240));
		cashBonusValuePanel.add(lblCashBonusValue);

		JPanel tokenPanel = new JPanel();
		tokenPanel.setBackground(new Color(255, 255, 240));
		tokenPanel.setForeground(new Color(0, 0, 0));
		tokenPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel2.add(tokenPanel);
		tokenPanel.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel tokenLabelPanel = new JPanel();
		tokenLabelPanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		tokenLabelPanel.setBackground(new Color(255, 255, 240));
		tokenPanel.add(tokenLabelPanel);
		tokenLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblToken = new JLabel(Launcher.config.getProperty("balancereader.config.tokenBalance.text"));
		lblToken.setForeground(new Color(128, 0, 0));
		lblToken.setHorizontalAlignment(SwingConstants.CENTER);
		lblToken.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblToken.setBackground(new Color(255, 255, 240));
		tokenLabelPanel.add(lblToken);

		JPanel tokenValuePanel = new JPanel();
		tokenValuePanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		tokenValuePanel.setBackground(new Color(255, 255, 240));
		tokenPanel.add(tokenValuePanel);
		tokenValuePanel.setLayout(new GridLayout(0, 1, 0, 0));

		lblTokenValue.setForeground(new Color(0, 128, 0));
		lblTokenValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTokenValue.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTokenValue.setBackground(new Color(255, 255, 240));
		tokenValuePanel.add(lblTokenValue);

		JPanel tokenBonusPanel = new JPanel();
		tokenBonusPanel.setBackground(new Color(255, 255, 240));
		tokenBonusPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		tokenBonusPanel.setForeground(new Color(0, 0, 0));
		panel2.add(tokenBonusPanel);
		tokenBonusPanel.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel tokenBonusLabelPanel = new JPanel();
		tokenBonusLabelPanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		tokenBonusLabelPanel.setBackground(new Color(255, 255, 240));
		tokenBonusPanel.add(tokenBonusLabelPanel);
		tokenBonusLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblTokenBonus = new JLabel(Launcher.config.getProperty("balancereader.config.tokenBonusBalance.text"));
		lblTokenBonus.setForeground(new Color(128, 0, 0));
		lblTokenBonus.setHorizontalAlignment(SwingConstants.CENTER);
		lblTokenBonus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTokenBonus.setBackground(new Color(255, 255, 240));
		tokenBonusLabelPanel.add(lblTokenBonus);

		JPanel tokenBonusValuePanel = new JPanel();
		tokenBonusValuePanel.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		tokenBonusValuePanel.setBackground(new Color(255, 255, 240));
		tokenBonusPanel.add(tokenBonusValuePanel);
		tokenBonusValuePanel.setLayout(new GridLayout(0, 1, 0, 0));

		lblTokenBonusValue.setForeground(new Color(0, 128, 0));
		lblTokenBonusValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTokenBonusValue.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTokenBonusValue.setBackground(new Color(255, 255, 240));
		tokenBonusValuePanel.add(lblTokenBonusValue);
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
				lblAccountId.setText(Integer.toString(id));
				logger.info("Account readed {}", id);

				Thread requestManager = new Thread(new RequestManager(this, id));
				requestManager.start();

			}
		} catch (Exception e) {
			// Display Error Message
			logger.error("", e);
		}
	}

	/**
	 * @return lblPointsValue
	 */
	public JLabel getLblPointsValue() {
		return lblPointsValue;
	}

	/**
	 * @return lblCashValue
	 */
	public JLabel getLblCashValue() {
		return lblCashValue;
	}
	
	/**
	 * @return lblTokenBonusValue
	 */
	public JLabel getLblTokenBonusValue() {
		return lblTokenBonusValue;
	}
	
	/**
	 * @return lblTokenValue
	 */
	public JLabel getLblTokenValue() {
		return lblTokenValue;
	}
	
	/**
	 * @return lblCashBonusValue
	 */
	public JLabel getLblCashBonusValue() {
		return lblCashBonusValue;
	}

}
