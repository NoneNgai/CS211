package Assignment4;

import java.util.ArrayList;
import java.util.HashMap;

public class TextFreqHelper {
	public static char findMostCommonChar(String paragraph) {
		/*ArrayList<Character> c = new ArrayList<>();
		ArrayList<Integer> cnt = new ArrayList<>();
		int index;
		char[] ca = paragraph.toCharArray();
		for(int i=0;i<ca.length;i++) {
			if(c.contains(ca[i])) {
				cnt.add(1);
			}
		}*/
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
		String s = "aasjjikkk";
		for(int i = 0; i < s.length(); i++){
		   char c = s.charAt(i);
		   Integer val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c,1);
		   }
		}
		return c.get(0);
	}
	public boolean isAtoZ(char c) {
		if(c >= 'a' && c<= 'z')
		return true;
		else if(c >= 'A' && c <= 'Z')
			return true;
		else
			return false;
	}
}
