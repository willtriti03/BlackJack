package blackjackFrame;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private int sum;
	private ArrayList<Card> hand = new ArrayList<>();
	private int aCnt= 0;
	private Dealer dealer;
	private boolean blackjack = false;
	protected HandPanel handPanel;
	protected ScoreDetector scoreDetector;

	public int getSum() {
		this.sum = checkSum();
		return sum;
	}

	public void addCard() {
		hand.add(dealer.callCard());
		if(21 <= checkSum()) {
			blackjack = true;
			dealer.handPanel.refresh();
			scoreDetector.detectAllScore();
			
		}
		else {
			handPanel.refresh();
		}
	}

	protected int checkSum() {	
		int sum=0;
		Iterator iter = hand.iterator();

		while(iter.hasNext()) {
			int rank =((Card)iter.next()).getRank();
			if(rank == 1)
				aCnt++;
			else
				sum += rank;
		}

		for(int i =0; i< aCnt; ++i) {
			if(sum+11 <= 21)
				sum += 11;
			else
				sum += 1;
		}
		aCnt=0;

		return sum;
	}

	public void playFirstTurn() {
		addCard();
		addCard();
		handPanel.refresh();
		scoreDetector.detectPlayerScore();
	}

	public void playMoreTurn() {
		if(!blackjack) {
			addCard();
			handPanel.refresh();
			scoreDetector.detectPlayerScore();
		}
	}
	
	public boolean isBlackjack() {
		return blackjack;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setHandPanel(HandPanel handPanel) {
		this.handPanel = handPanel;
	}

	public void setScoreDetector(ScoreDetector scoreDetector) {
		this.scoreDetector = scoreDetector;
	}




}
