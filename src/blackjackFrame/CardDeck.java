package blackjackFrame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CardDeck {
	private ArrayList<Card>deck = new ArrayList<>();
	private char simbol[] = {'s','c','d','h'};// 스페이드 클로버 다이아몬드 하트
	private String image[][]= {
			{"./image/Spade_A.png","./image/Spade_2.png","./image/Spade_3.png","./image/Spade_4.png","./image/Spade_5.png","./image/Spade_6.png","./image/Spade_7.png","./image/Spade_8.png","./image/Spade_9.png","./image/Spade_10.png","./image/Spade_J.png","./image/Spade_Q.png","./image/Spade_K.png"},
			{"./image/Club_A.png","./image/Club_2.png","./image/Club_3.png","./image/Club_4.png","./image/Club_5.png","./image/Club_6.png","./image/Club_7.png","./image/Club_8.png","./image/Club_9.png","./image/Club_10.png","./image/Club_J.png","./image/Club_Q.png","./image/Club_K.png"},
			{"./image/Diamond_A.png","./image/Diamond_2.png","./image/Diamond_3.png","./image/Diamond_4.png","./image/Diamond_5.png","./image/Diamond_6.png","./image/Diamond_7.png","./image/Diamond_8.png","./image/Diamond_9.png","./image/Diamond_10.png","./image/Diamond_J.png","./image/Diamond_Q.png","./image/Diamond_K.png"},
			{"./image/Heart_A.png","./image/Heart_2.png","./image/Heart_3.png","./image/Heart_4.png","./image/Heart_5.png","./image/Heart_6.png","./image/Heart_7.png","./image/Heart_8.png","./image/Heart_9.png","./image/Heart_10.png","./image/Heart_J.png","./image/Heart_Q.png","./image/Heart_K.png"}
	};
	
	public CardDeck() {
		// TODO Auto-generated constructor stub
		
		for(int i = 1; i < 14; ++i) {
			for(int j = 0; j < 4; ++j) {
				Card card = new Card(i, simbol[j], image[j][i-1]);
				deck.add(card);
			}
		}
	}
	
	public void shuffle() {
		// TODO Auto-generated method stub
		Collections.shuffle(deck);
	}
	
	public Card popCard() {
		return deck.remove(0);
	}
}
