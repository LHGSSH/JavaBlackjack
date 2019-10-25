import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
				popup.setVisible(true);
			}
		});
		btnLetsPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame popup = new JFrame();
				popup.setBounds(50, 50, 50, 50);
				popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				popup.getContentPane().setLayout(new BorderLayout(0, 0));
				
				JTextArea txtrCommence = new JTextArea();
				txtrCommence.setText("Chips are counted...\n Cards are shuffled... \n GOOD LUCK!");
				popup.getContentPane().add(txtrCommence, BorderLayout.CENTER);
			}
		});
		mainFrame.getContentPane().add(btnLetsPlay, BorderLayout.SOUTH);
		
		
	}

}
