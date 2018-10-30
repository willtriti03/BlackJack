package blackjackFrame;

import javax.swing.JLabel;

public class ScoreDetector {
	private JLabel score;
	private Player player;
	private Dealer dealer;
	private boolean finished = false;

	public ScoreDetector(JLabel score, Player player, Dealer dealer) {
		this.score = score;
		this.player = player;
		this.dealer = dealer;
	}
	public void startPlayerTurn() {
		finished=false;
		detectPlayerScore();
	}

	public void detectPlayerScore() {
		if(!finished)
			score.setText("Dealer : ???, Player : "+player.getSum());
	}

	public void detectAllScore() {
		if(!finished) {
			finished = true;
			String ment="";
			if(dealer.getSum() == 21 ) {
				ment = "  µô·¯ ½Â¸®";
			}
			else if(player.getSum() == 21 ) {
				ment = "  ÇÃ·¹ÀÌ¾î ½Â¸®";
			}
			else if(!dealer.isBlackjack() && !player.isBlackjack() ){
				if(Math.abs(21 - dealer.getSum()) < Math.abs(21 - player.getSum())) {
					ment = "  µô·¯ ½Â¸®";
				}
				else if(Math.abs(21 - dealer.getSum()) > Math.abs(21 - player.getSum())) {
					ment = "  ÇÃ·¹ÀÌ¾î ½Â¸®";
				}
				else if(Math.abs(21 - dealer.getSum()) == Math.abs(21 - player.getSum())) {
					ment = "  µô·¯ ½Â¸®";
				}
			}
			else if(player.isBlackjack()) {
				ment = "  µô·¯ ½Â¸®";
			}
	
			score.setText("Dealer : "+dealer.getSum()+", Player : "+player.getSum()+ment);
		}
	}
	
	public boolean isFinished() {
		return finished;
	}

}
