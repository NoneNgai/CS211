package Assignment3_ElementGameCards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Card {
	ArrayList<ImageIcon> Card;
	Element ele;
	public Card() {
		Card = new ArrayList<>();
		
		for(int i=0;i<6;i++) {
			Card.add(ele.FIRE.getImage());
		}
		for(int i=0;i<6;i++) {
			Card.add(ele.WATER.getImage());
		}
		for(int i=0;i<6;i++) {
			Card.add(ele.WIND.getImage());
		}
		for(int i=0;i<6;i++) {
			Card.add(ele.EARTH.getImage());
		}
		Shuffle();
	}
	public ImageIcon List(int index) {
		return Card.get(index);
	}
	public void Shuffle(){
		Collections.shuffle(Card);
	}
}
