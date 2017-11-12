package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class FoodList {
	private ArrayList<Food> list;
	private ArrayList<Food> tmplist;
	JFileChooser chooser;
	public FoodList() {
		list = new ArrayList<>();
	}
	public void add(Food food) {
		list.add(food);
	}
	public void add(String name,double price,String details,ImageIcon icon) {
		list.add(new Food(name, price, details, icon)); 
	}
	public void set(int index,Food food) {
		list.set(index, food);
	}
	public ArrayList<Food> getFoodList(){
		return list;
	}
	public Food get(int index) {
		return list.get(index);
	}
	public int size() {
		return list.size();
	}
	public boolean loadList() {
		list.clear();
		chooser = new JFileChooser();
		FileInputStream f;
		tmplist = new ArrayList<>();
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			try {
				f = new FileInputStream(chooser.getSelectedFile());
				ObjectInputStream In = new ObjectInputStream(f);
				tmplist = (ArrayList<Food>) In.readObject();
				for (Food food : tmplist) {
					list.add(food);
					
				}
				In.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return true;
	}
	public void saveList() {
		chooser = new JFileChooser(".");
		FileOutputStream f;
		if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
			try {
				f = new FileOutputStream(chooser.getSelectedFile());
				ObjectOutputStream Out = new ObjectOutputStream(f);
				Out.writeObject(list);			
				Out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
