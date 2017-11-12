package Assignment3_ElementGameCards;

import javax.swing.ImageIcon;

public enum Element {
	WATER(new ImageIcon("Water.png")), WIND(new ImageIcon("Air.png")), EARTH(new ImageIcon("Earth.png")), FIRE(
			new ImageIcon("Fire.png"));
	private ImageIcon img;
	Element(ImageIcon img) {
		this.img = img;
	}
	public ImageIcon getImage() {
		return img;
	}
	public int Compare(Element other) {
		if(ordinal()==3&&other.ordinal()==0) {
			System.out.println("1"+ordinal()+other.ordinal());
			return -1;
		}
		else if(ordinal()==0&&other.ordinal()==3) {
			System.out.println("2"+ordinal()+other.ordinal());
			return 1;
		}
		else if(ordinal()>other.ordinal()) {
			System.out.println("3"+ordinal()+other.ordinal());
			return 1;
		}
		else if(ordinal()==other.ordinal()) {
			System.out.println("4"+ordinal()+other.ordinal());
			return 0;
		}
		else 
			return -1;
	}
}
