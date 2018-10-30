package blackjackFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BlackJackFrame extends JFrame {

	public BlackJackFrame() {
		// TODO Auto-generated constructor stub
		setTitle("BlackJack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		Dealer dealer = new Dealer();
		Player player = new Player();
		
		
		dealer.setDealer(dealer);
		player.setDealer(dealer);
		
		DealerPanel dealerPanel = new DealerPanel(dealer);
		PlayerPanel playerPanel = new PlayerPanel(player);
		JPanel buttonTabPanel = new JPanel();
		
		JLabel score = new JLabel("Dealer : ???, Player : "+player.getSum());
		JButton hit = new JButton("Hit");
		JButton stand = new JButton("Stand");
		
		buttonTabPanel.add(score);
		buttonTabPanel.add(hit);
		buttonTabPanel.add(stand);
		
		add(dealerPanel);
		add(playerPanel);
		add(buttonTabPanel);
		
		ScoreDetector scoreDetector = new ScoreDetector(score, player, dealer);
		player.setScoreDetector(scoreDetector);
		dealer.setScoreDetector(scoreDetector);
		
		dealer.setHandPanel(dealerPanel);
		player.setHandPanel(playerPanel);
		
		dealer.playFirstTurn();
		
		scoreDetector.startPlayerTurn();
		player.playFirstTurn();
		
		
		hit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.playMoreTurn();
			}
		});
		
		stand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				scoreDetector.detectAllScore();
				dealerPanel.refresh();
			}
		});
		
		setSize(700, 500);
		setVisible(true);
	}
	
	
}
