package Assignment3_DayColorFortune;
import java.awt.Color;
public enum WeekOfDay{
	SUNDAY(Color.RED,Color.BLUE),
	MONDAY(Color.YELLOW,Color.RED),
	TUESDAY(Color.PINK,Color.YELLOW),
	WEDNESDAY(Color.GREEN,Color.PINK),
	THURSDAY(Color.ORANGE,new Color(128,0,128)),
	FRIDAY(new Color(135,206,250),new Color(0,0,139)),
	SATURDAY(new Color(128,0,128),Color.GREEN);
	private Color lucky,unlucky;
	private WeekOfDay(Color luck,Color unluck) {
		lucky = luck;
		unlucky = unluck;
	}
	public Color getLucky() {
		return lucky;
	}
	public Color getUnlucky() {
		return unlucky;
	}
}
