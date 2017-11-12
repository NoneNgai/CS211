package Assignment3;

import java.awt.Image;
import javax.swing.ImageIcon;

public enum Element {
	WATER(new ImageIcon("water.jpg")),WIND(new ImageIcon("wind.jpg")),EARTH(new ImageIcon("earth.jpg")),FIRE(new ImageIcon("fire.jpg"));
	
	private final ImageIcon IMAGE;
	private Element(ImageIcon image) {
		IMAGE = image;
	}
	
	public ImageIcon getImage(){
		return IMAGE;
	}
	
	public int compare(Element other){
			if(IMAGE.toString().equals("water.jpg")&&other.toString().equals("WIND")){
				return -1;
			}else if(IMAGE.toString().equals("water.jpg")&&other.toString().equals("EARTH")){
				return -1;
			}else if(IMAGE.toString().equals("water.jpg")&&other.toString().equals("FIRE")){
				return 1;
			}else if(IMAGE.toString().equals("water.jpg")&&other.toString().equals("WATER")){
				return 0;
			}else if(IMAGE.toString().equals("wind.jpg")&&other.toString().equals("WIND")){
				return 0;
			}else if(IMAGE.toString().equals("wind.jpg")&&other.toString().equals("WATER")){
				return 1;
			}else if(IMAGE.toString().equals("wind.jpg")&&other.toString().equals("EARTH")){
				return -1;
			}else if(IMAGE.toString().equals("wind.jpg")&&other.toString().equals("FIRE")){
				return -1;
			}else if(IMAGE.toString().equals("earth.jpg")&&other.toString().equals("WATER")){
				return 1;
			}else if(IMAGE.toString().equals("earth.jpg")&&other.toString().equals("WIND")){
				return 1;
			}else if(IMAGE.toString().equals("earth.jpg")&&other.toString().equals("EARTH")){
				return 0;
			}else if(IMAGE.toString().equals("earth.jpg")&&other.toString().equals("FIRE")){
				return -1;
			}else if(IMAGE.toString().equals("fire.jpg")&&other.toString().equals("WATER")){
				return -1;
			}else if(IMAGE.toString().equals("fire.jpg")&&other.toString().equals("WIND")){
				return 1;
			}else if(IMAGE.toString().equals("fire.jpg")&&other.toString().equals("EARTH")){
				return 1;
			}else{
				return 0;
			}
		}
}
