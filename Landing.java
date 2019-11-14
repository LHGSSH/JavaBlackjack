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
				txtrCommence.setPreferredSize(new Dimension(10,50));

				JPanel backgroundPanel = new JPanel();
				backgroundPanel.setOpaque(false);
				backgroundPanel.setLayout(new BorderLayout());

				JLabel backgroundImage = new JLabel();
				backgroundImage.setIcon(new ImageIcon("CardImages/Green_Background.png"));
				backgroundImage.setLayout(new BorderLayout());

				JButton betButton = new JButton();
				JButton hitButton = new JButton();
				JButton standButton = new JButton();

				/*TODO:: Call the Game_Manager class here.
				   Get card images from a Deck that gets made in Game_Manager.
				   Add a 'Bet' and 'Hit' and 'Stand' buttons
				 */

				BufferedImage userCardImage = null;
				try {
					userCardImage = ImageIO.read(new File("CardImages/2C.png"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				Image testCard = userCardImage.getScaledInstance(100,150,100);
				ImageIcon userCardIcon = new ImageIcon(testCard);
				JLabel testLabel = new JLabel(userCardIcon);

				backgroundPanel.add(txtrCommence, BorderLayout.NORTH);
				backgroundPanel.add(testLabel, BorderLayout.SOUTH);

				backgroundImage.add(backgroundPanel);
				popup.add(backgroundImage);
				
				popup.setVisible(true);
				
			}
		});
		mainFrame.getContentPane().add(btnLetsPlay, BorderLayout.SOUTH);
		
	}

}
