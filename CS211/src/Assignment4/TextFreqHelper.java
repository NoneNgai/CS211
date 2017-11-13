package Assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class TextFreqHelper {
	public static char findMostCommonChar(String paragraph) {
		char mostfre = ' ';int valtmp = 0;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();    
		for(int i = 0; i < paragraph.length(); i++){
		   char c = paragraph.charAt(i);
		   if(isAtoZ(c)) {
		   Integer val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c,1);
		   }
		   }
		}
		for(Map.Entry<Character,Integer> maps : map.entrySet()) {
			if(isAtoZ(maps.getKey())) {
			char c = maps.getKey();
			int val = maps.getValue();
			
			if(valtmp < val) {
				mostfre = c;
				valtmp = val;
			}
		}
		}
		return mostfre;
	}
	public static boolean isAtoZ(char c) {
		if(c >= 'a' && c<= 'z')
		return true;
		else if(c >= 'A' && c <= 'Z')
			return true;
		else
			return false;
	}
}
