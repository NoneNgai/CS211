package Assignment3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Card {
	private ArrayList<Element> elecard;
	private Element card;
	
	public Card() {
		elecard = new ArrayList<>();
		for(int i=0;i<4;i++){
			elecard.add(card.WATER);
			elecard.add(card.WIND);
			elecard.add(card.EARTH);
			elecard.add(card.FIRE);
		}
	}
	
	public Element getCardonTop(){
		Element element = elecard.get(0);
		elecard.remove(0);
		return element;
	}
	
	public void shuffleCard(){
		Collections.shuffle(elecard);
	}
	public void newDeck(){
		elecard.clear();
		for(int i=0;i<4;i++){
			elecard.add(card.WATER);
			elecard.add(card.WIND);
			elecard.add(card.EARTH);
			elecard.add(card.FIRE);
		}
	}
}
