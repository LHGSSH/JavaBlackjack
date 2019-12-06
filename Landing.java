import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Landing {

	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing window = new Landing();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Landing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 450, 150);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcomeToBlackjack = new JLabel("Welcome to Blackjack!");
		lblWelcomeToBlackjack.setHorizontalAlignment(SwingConstants.CENTER);
		mainFrame.getContentPane().add(lblWelcomeToBlackjack, BorderLayout.NORTH);

		User currentUser = new User();

		//creating textfields to get username and password
		String defaultUsernameText = "Username";
		String defaultPasswordText = "Password";
		//TODO: for simplicity's sake, these will have a known bug that you can't use "Username"
		// as a username or "Password" as a password
		JTextField usernameText = new JTextField(defaultUsernameText, 20);
		JTextField passwordText = new JTextField(defaultPasswordText, 20);
		usernameText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (usernameText.getText().equalsIgnoreCase(defaultUsernameText))
					usernameText.setText("");
			}
			public void focusLost(FocusEvent e) {
				if (usernameText.getText().equalsIgnoreCase(""))
					usernameText.setText(defaultUsernameText);
			}
		});
		passwordText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (passwordText.getText().equalsIgnoreCase(defaultPasswordText))
					passwordText.setText("");
			}
			public void focusLost(FocusEvent e) {
				if (passwordText.getText().equalsIgnoreCase(""))
					passwordText.setText(defaultPasswordText);
			}
		});
		//Adding textfields to a panel to be in one section of the BorderLayout
		JPanel logIn = new JPanel();
		logIn.add(usernameText);
		logIn.add(passwordText);


		JLabel loginInfo = new JLabel("<html>Enter login info or<br>new login info<br>for a new user</html>");
		JButton btnLetsPlay = new JButton("Let's Play!");

		btnLetsPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String username = usernameText.getText();
				String password = passwordText.getText();
				//Add them to data file if they are not already in it
				if(!currentUser.loginCheck(username, password)){
					User currentUser = new User(username,password);
			}
				GameManager newGame = new GameManager();

				JFrame popup = new JFrame();
                JPanel northPanel = new JPanel();
                JPanel northRightPanel = new JPanel();
                JPanel centerSouthPanel = new JPanel();
                JPanel centerNorthPanel = new JPanel();
                JPanel centerPanel = new JPanel();
                JPanel eastPanel = new JPanel();
                JPanel westPanel = new JPanel();
                JPanel backgroundPanel = new JPanel();
                JLabel backgroundImage = new JLabel();
                JTextArea userScore = new JTextArea();
                JButton hitButton = new JButton();
                JButton stayButton = new JButton();

                Font scoreFont = new Font("Times New Roman", Font.BOLD, 16);

                BufferedImage user1CardBackBufferedImage = null;
                BufferedImage dealerCardBackBufferedImage = null;

				hitButton.setText("HIT");

				hitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {

						newGame.hit();

						Image user1Card2Image = newGame.userHand.deckOfCards.get(2).getCardImage().getScaledInstance(100,150,100);
						//TODO: Add a scaling .get(n) to get next cards.
						ImageIcon user1Card2Icon = new ImageIcon(user1Card2Image);
						JLabel user1Card2Delt = new JLabel(user1Card2Icon);

						centerSouthPanel.add(user1Card2Delt);

						popup.revalidate();
					}
				});
				stayButton.setText("STAY");
				//TODO: Call Stay.main() inside this listener
				stayButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						
						Stay.main(null);

						BufferedImage dealerCardBackBufferedImageStay = null;

						try {
							dealerCardBackBufferedImageStay = ImageIO.read(new File("CardImages/red_back.png"));
						} catch (IOException ex) {
							ex.printStackTrace();
						}

						Image dealerCardBackImage = dealerCardBackBufferedImageStay.getScaledInstance(100,150,100);
						ImageIcon dealerCardBackIcon = new ImageIcon(dealerCardBackImage);
						JLabel dealerCardBackDelt = new JLabel(dealerCardBackIcon);

						Image dealerCard1Image = newGame.dealerHand.deckOfCards.get(0).getCardImage().getScaledInstance(100,150,100);
						ImageIcon dealerCard1Icon = new ImageIcon(dealerCard1Image);
						JLabel dealerCard1Delt = new JLabel(dealerCard1Icon);

						Image dealerCard2Image = newGame.dealerHand.deckOfCards.get(1).getCardImage().getScaledInstance(100,150,100);
						ImageIcon dealerCard2Icon = new ImageIcon(dealerCard2Image);
						JLabel dealerCard2Delt = new JLabel(dealerCard2Icon);

						if (newGame.dealerHand.deckOfCards.size() > 2){
							Image dealerCard3Image = newGame.dealerHand.deckOfCards.get(2).getCardImage().getScaledInstance(100,150,100);
							ImageIcon dealerCard3Icon = new ImageIcon(dealerCard3Image);
							JLabel dealerCard3Delt = new JLabel(dealerCard3Icon);

							centerNorthPanel.removeAll();
							centerNorthPanel.setOpaque(false);
							centerSouthPanel.setLayout(new FlowLayout());
							centerNorthPanel.add(dealerCardBackDelt);
							centerNorthPanel.add(dealerCard1Delt);
							centerNorthPanel.add(dealerCard2Delt);
							centerNorthPanel.add(dealerCard3Delt);

							popup.revalidate();
						}
						else {
							centerNorthPanel.removeAll();
							centerNorthPanel.setOpaque(false);
							centerSouthPanel.setLayout(new FlowLayout());
							centerNorthPanel.add(dealerCardBackDelt);
							centerNorthPanel.add(dealerCard1Delt);
							centerNorthPanel.add(dealerCard2Delt);

							popup.revalidate();
						}
					}
				});

				try {
					user1CardBackBufferedImage = ImageIO.read(new File("CardImages/blue_back.png"));
					dealerCardBackBufferedImage = ImageIO.read(new File("CardImages/red_back.png"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}

                Image dealerCardBackImage = dealerCardBackBufferedImage.getScaledInstance(100,150,100);
                ImageIcon dealerCardBackIcon = new ImageIcon(dealerCardBackImage);
                JLabel dealerCardBackDelt = new JLabel(dealerCardBackIcon);

                Image dealerCard1Image = newGame.dealerHand.deckOfCards.get(0).getCardImage().getScaledInstance(100,150,100);
                ImageIcon dealerCard1Icon = new ImageIcon(dealerCard1Image);
                JLabel dealerCard1Delt = new JLabel(dealerCard1Icon);

                Image dealerCard2Image = dealerCardBackBufferedImage.getScaledInstance(100,150,100);
                ImageIcon dealerCard2Icon = new ImageIcon(dealerCard2Image);
                JLabel dealerCard2Delt = new JLabel(dealerCard2Icon);

				Image user1CardBackImage = user1CardBackBufferedImage.getScaledInstance(100,150,100);
				ImageIcon user1CardBackIcon = new ImageIcon(user1CardBackImage);
				JLabel user1CardBackDelt = new JLabel(user1CardBackIcon);

				Image user1Card1Image = newGame.userHand.deckOfCards.get(0).getCardImage().getScaledInstance(100,150,100);
				ImageIcon user1Card1Icon = new ImageIcon(user1Card1Image);
				JLabel user1Card1Delt = new JLabel(user1Card1Icon);

				Image user1Card2Image = newGame.userHand.deckOfCards.get(1).getCardImage().getScaledInstance(100,150,100);
				ImageIcon user1Card2Icon = new ImageIcon(user1Card2Image);
				JLabel user1Card2Delt = new JLabel(user1Card2Icon);

				userScore.setText("Current Score: " + newGame.startingChips);
				userScore.setFont(scoreFont);
				userScore.setBackground(Color.CYAN);
				userScore.setEditable(false);

				northRightPanel.setOpaque(false);
				northRightPanel.setLayout(new BorderLayout());
				northRightPanel.add(userScore);

				northPanel.setOpaque(false);
				northPanel.setLayout(new BorderLayout());
				northPanel.add(northRightPanel, BorderLayout.EAST);

				centerSouthPanel.setOpaque(false);
				centerSouthPanel.setLayout(new FlowLayout());
				centerSouthPanel.add(user1CardBackDelt);
				centerSouthPanel.add(user1Card1Delt);
				centerSouthPanel.add(user1Card2Delt);

				centerNorthPanel.setOpaque(false);
				centerSouthPanel.setLayout(new FlowLayout());
				centerNorthPanel.add(dealerCardBackDelt);
				centerNorthPanel.add(dealerCard1Delt);
				centerNorthPanel.add(dealerCard2Delt);

				centerPanel.setOpaque(false);
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
				centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);

				eastPanel.setOpaque(false);
				eastPanel.setLayout(new BorderLayout());

				westPanel.setOpaque(false);
				westPanel.setLayout(new GridLayout(5,0));
				westPanel.add(hitButton);
				westPanel.add(stayButton);

                backgroundPanel.setOpaque(false);
                backgroundPanel.setLayout(new BorderLayout());
				backgroundPanel.add(centerPanel, BorderLayout.CENTER);
				backgroundPanel.add(northPanel, BorderLayout.NORTH);
				backgroundPanel.add(eastPanel, BorderLayout.EAST);
				backgroundPanel.add(westPanel, BorderLayout.WEST);

                backgroundImage.setIcon(new ImageIcon("CardImages/Green_Background.png"));
                backgroundImage.setLayout(new BorderLayout());
				backgroundImage.add(backgroundPanel);

                popup.setBounds(100, 100, 950, 750);
                popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                popup.getContentPane().setLayout(new BorderLayout(0, 0));
				popup.add(backgroundImage);
				popup.setVisible(true);

			}
		});
		mainFrame.getContentPane().add(btnLetsPlay, BorderLayout.SOUTH);
		mainFrame.getContentPane().add(loginInfo, BorderLayout.WEST);
		mainFrame.getContentPane().add(logIn, BorderLayout.CENTER);


	}

}
