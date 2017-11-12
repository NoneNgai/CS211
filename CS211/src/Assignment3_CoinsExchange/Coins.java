package Assignment3_CoinsExchange;

public enum Coins {
	ONE(1),TWO(2),FIVE(5),TEN(10);
	private int value;
	Coins(int value){
		this.value = value;
 	}
	public int getValue() {
		return value;
	}
}
