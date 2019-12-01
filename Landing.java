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
                JPanel northPanel = new JPanel();
                JPanel centerSouthPanel = new JPanel();
                JPanel centerNorthPanel = new JPanel();
                JPanel centerPanel = new JPanel();
                JPanel eastPanel = new JPanel();
                JPanel westPanel = new JPanel();
                JPanel backgroundPanel = new JPanel();
                JLabel backgroundImage = new JLabel();
                JTextArea txtrCommence = new JTextArea();
                JButton betButton = new JButton();
                JButton hitButton = new JButton();
                JButton stayButton = new JButton();

                BufferedImage user1CardBackBufferedImage = null;
                BufferedImage dealerCardBackBufferedImage = null;

                Card user1Card1 = new Card(Suit.HEARTS, 8);
                Card user1Card2 = new Card(Suit.CLUBS, 5);
                Card dealerCard1 = new Card(Suit.DIAMONDS, 11);
                Card dealerCard2 = new Card(Suit.SPADES, 1);

				txtrCommence.setText("Chips are counted...\n Cards are shuffled... \n GOOD LUCK!");

				betButton.setText("BET");
				//TODO: Call Bet.main() inside this listener
				betButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						JFrame betFrame = new JFrame();
						betFrame.setBounds(500, 475, 200, 100);
						betFrame.setDefaultCloseOperation(betFrame.HIDE_ON_CLOSE);
						JTextArea betButtonText = new JTextArea();
						betButtonText.setText("Bet Button Pressed!");
						betFrame.add(betButtonText);
						betFrame.setVisible(true);
					}
				});
				hitButton.setText("HIT");
				//TODO: Call Hit.main() inside this listener
				hitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						JFrame hitFrame = new JFrame();
						hitFrame.setBounds(500, 475, 200, 100);
						hitFrame.setDefaultCloseOperation(hitFrame.HIDE_ON_CLOSE);
						JTextArea hitButtonText = new JTextArea();
						hitButtonText.setText("Hit Button Pressed!");
						hitFrame.add(hitButtonText);
						hitFrame.setVisible(true);
					}
				});
				stayButton.setText("STAY");
				//TODO: Call Stay.main() inside this listener
				stayButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						JFrame stayFrame = new JFrame();
						stayFrame.setBounds(500, 475, 200, 100);
						stayFrame.setDefaultCloseOperation(stayFrame.HIDE_ON_CLOSE);
						JTextArea stayButtonText = new JTextArea();
						stayButtonText.setText("Stay Button Pressed!");
						stayFrame.add(stayButtonText);
						stayFrame.setVisible(true);
					}
				});

				/*TODO:: Call the Game_Manager class here.
				   Get card images from a Deck that gets made in Game_Manager.
				   Add 'Bet' and 'Hit' and 'Stand' button functionality
				 */

				try {
					user1CardBackBufferedImage = ImageIO.read(new File("CardImages/blue_back.png"));
					dealerCardBackBufferedImage = ImageIO.read(new File("CardImages/red_back.png"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}

                Image dealerCardBackImage = dealerCardBackBufferedImage.getScaledInstance(100,150,100);
                ImageIcon dealerCardBackIcon = new ImageIcon(dealerCardBackImage);
                JLabel dealerCardBackDelt = new JLabel(dealerCardBackIcon);

                Image dealerCard1Image = dealerCard1.getCardImage().getScaledInstance(100,150,100);
                ImageIcon dealerCard1Icon = new ImageIcon(dealerCard1Image);
                JLabel dealerCard1Delt = new JLabel(dealerCard1Icon);

                Image dealerCard2Image = dealerCard2.getCardImage().getScaledInstance(100,150,100);
                ImageIcon dealerCard2Icon = new ImageIcon(dealerCard2Image);
                JLabel dealerCard2Delt = new JLabel(dealerCard2Icon);

				Image user1CardBackImage = user1CardBackBufferedImage.getScaledInstance(100,150,100);
				ImageIcon user1CardBackIcon = new ImageIcon(user1CardBackImage);
				JLabel user1CardBackDelt = new JLabel(user1CardBackIcon);

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
				westPanel.add(betButton);
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
		
	}

}
