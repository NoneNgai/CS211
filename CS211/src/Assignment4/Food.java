package Assignment4;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Food implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name,details;
	private double price;
	private ImageIcon icon;
	public Food(String name,double price,String details,ImageIcon icon) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.details = details;
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public String toString() {
		return "eiei";
	}

}
