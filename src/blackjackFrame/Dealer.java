package blackjackFrame;

public class Dealer extends Player{
	CardDeck cardDeck = new CardDeck();
	DealerPanel dealerPanel;
	
	public Dealer() {
		// TODO Auto-generated constructor stub
		cardDeck.shuffle();
	}
	
	
	@Override
	public void playFirstTurn() {
		addCard();
		addCard();
		
		while(17>checkSum()) {
			addCard();
		}
		
		handPanel.firstSet();
		
	}
	
	public Card callCard() {
		return cardDeck.popCard(); 
	}
	
	public void setDealerPanel(DealerPanel dealerPanel) {
		this.dealerPanel = dealerPanel;
	}
}
