package Assignment4;

import javax.swing.ImageIcon;

public class FoodListTest {
	public static void main(String[] args) {
		FoodList foodList = new FoodList();
		foodList.add("Mos Burgur", 89, "Energy\t343.6kcal\nTotal Fat\t15.8g\nCholesterol\t33.8mg\n"
				+ "Carbohydrate\t37.5g\nSodium\t778.8mg\nPotassium\t584.9mg", new ImageIcon("mosBurgur.jpg"));
		foodList.add("Mos Cheese Burgur", 99,
				"Energy\t405.6kcal\nTotal Fat\t20.7g\nCholesterol\t33.8mg\n"
						+ "Carbohydrate\t38.4g\nSodium\t1016.8mg\nPotassium\t584.9mg",
				new ImageIcon("mosCheeseBurgur.jpg"));
		foodList.add("Premium Yakitori", 109, "Rice Burger", new ImageIcon("riceBurgur.jpg"));
		foodList.add("Spicy Chilli Dog", 99,
				"Energy\t285kcal\nTotal Fat\t9.6g\nCholesterol\t25.6mg\n"
						+ "Carbohydrate\t31g\nSodium\t1021.7mg\nPotassium\t371.3mg",
				new ImageIcon("spicyChilliDog.jpg"));
		foodList.saveList();
		boolean success = foodList.loadList();
		System.out.println(foodList.size());
		if (success) {
			for (Food f : foodList.getFoodList()) {
				System.out.println(f.getName());
				System.out.println(f.getDetails());
				System.out.println(f.getPrice());
				System.out.println("--------------------");
			}
		}
	}

}
