import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcomeToBlackjack = new JLabel("Welcome to Blackjack!");
		lblWelcomeToBlackjack.setHorizontalAlignment(SwingConstants.CENTER);
		mainFrame.getContentPane().add(lblWelcomeToBlackjack, BorderLayout.NORTH);
		
		JButton btnLetsPlay = new JButton("Let's Play!");
		btnLetsPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JFrame popup = new JFrame();
				popup.setBounds(50, 50, 100, 100);
				popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				popup.getContentPane().setLayout(new BorderLayout(0, 0));

				JTextArea txtrCommence = new JTextArea();
				txtrCommence.setText("Chips are counted...\n Cards are shuffled... \n GOOD LUCK!");
				popup.getContentPane().add(txtrCommence, BorderLayout.CENTER);

			}
		});

		btnLetsPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame popup = new JFrame();
				popup.setBounds(100, 100, 950, 750);
				popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				popup.getContentPane().setLayout(new BorderLayout(0, 0));

				JTextArea txtrCommence = new JTextArea();
				txtrCommence.setText("Chips are counted...\n Cards are shuffled... \n GOOD LUCK!");

				JPanel backgroundPanel = new JPanel();
				backgroundPanel.setOpaque(false);
				backgroundPanel.setLayout(new BorderLayout());

				JLabel backgroundImage = new JLabel();
				backgroundImage.setIcon(new ImageIcon("CardImages/Green_Background.png"));
				backgroundImage.setLayout(new BorderLayout());

				JButton betButton = new JButton();
				betButton.setText("BET");
				JButton hitButton = new JButton();
				hitButton.setText("HIT");
				JButton stayButton = new JButton();
				stayButton.setText("STAY");

				/*TODO:: Call the Game_Manager class here.
				   Get card images from a Deck that gets made in Game_Manager.
				   Add 'Bet' and 'Hit' and 'Stand' buttons
				 */

				BufferedImage user1CardBackBufferedImage = null;
				BufferedImage dealerCardBufferedImage = null;
				Card user1Card1 = new Card(Suit.HEARTS, 8);
				Card user1Card2 = new Card(Suit.CLUBS, 5);

				JPanel northPanel = new JPanel();
				JPanel centerSouthPanel = new JPanel();
				JPanel centerPanel = new JPanel();
				JPanel eastPanel = new JPanel();
				JPanel westPanel = new JPanel();

				try {
					user1CardBackBufferedImage = ImageIO.read(new File("CardImages/blue_back.png"));
					dealerCardBufferedImage = ImageIO.read(new File("CardImages/red_back.png"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				Image user1CardBackImage = user1CardBackBufferedImage.getScaledInstance(100,150,100);
				ImageIcon user1CardBackIcon = new ImageIcon(user1CardBackImage);
				JLabel user1CardBackDelt = new JLabel(user1CardBackIcon);

				Image dealerCardBackImage = dealerCardBufferedImage.getScaledInstance(100,150,100);
				ImageIcon dealerCardBackIcon = new ImageIcon(dealerCardBackImage);
				JLabel dealerCardBackDelt = new JLabel(dealerCardBackIcon);

				Image user1Card1Image = user1Card1.getCardImage().getScaledInstance(100,150,100);
				ImageIcon user1Card1Icon = new ImageIcon(user1Card1Image);
				JLabel user1Card1Delt = new JLabel(user1Card1Icon);

				Image user1Card2Image = user1Card2.getCardImage().getScaledInstance(100,150,100);
				ImageIcon user1Card2Icon = new ImageIcon(user1Card2Image);
				JLabel user1Card2Delt = new JLabel(user1Card2Icon);

				northPanel.setOpaque(false);
				northPanel.setLayout(new FlowLayout());
				northPanel.add(txtrCommence);

				centerSouthPanel.setOpaque(false);
				centerSouthPanel.setLayout(new FlowLayout());
				centerSouthPanel.add(user1CardBackDelt);
				centerSouthPanel.add(user1Card1Delt);
				centerSouthPanel.add(user1Card2Delt);

				centerPanel.setOpaque(false);
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(dealerCardBackDelt, BorderLayout.NORTH);
				centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);

				eastPanel.setOpaque(false);
				eastPanel.setLayout(new BorderLayout());

				westPanel.setOpaque(false);
				westPanel.setLayout(new GridLayout(5,0));
				westPanel.add(hitButton);
				westPanel.add(betButton);
				westPanel.add(stayButton);

				backgroundPanel.add(centerPanel, BorderLayout.CENTER);
				backgroundPanel.add(northPanel, BorderLayout.NORTH);
				backgroundPanel.add(eastPanel, BorderLayout.EAST);
				backgroundPanel.add(westPanel, BorderLayout.WEST);

				backgroundImage.add(backgroundPanel);

				popup.add(backgroundImage);
				popup.setVisible(true);

			}
		});
		mainFrame.getContentPane().add(btnLetsPlay, BorderLayout.SOUTH);
		
	}

}
