package Assignment4;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ParagraphReaderTest {
	/*public static void main(String[] args) throws ClassNotFoundException, IOException {
		ParagraphReader reader = new ParagraphReader(new File("sample.txt"));
		for (int i=0; i<reader.size(); i++) {
				System.out.println(i+ " " + reader.get(i));
				System.out.print("Most freq char of paragraph "+i +": ");
					try {
						System.out.println(TextFreqHelper.findMostCommonChar(reader.get(i)));
					} catch (RuntimeException e) {
						System.out.println(e.getMessage());
					}
				System.out.println("--------------------------");
			}
		reader.clear();
		reader.readFile(new File("sample.txt"), true);
		for (int i=0; i<reader.size(); i++) {
			System.out.println(i+ " " + reader.get(i));
			}
		}*/
	public static void main(String[] args) {
		//TextFreqHelper t = new TextFreqHelper();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
		String s = "aasjjikkkkjdlksjabcwuiq";
		for(int i = 0; i < s.length(); i++){
		   char c = s.charAt(i);
		   Integer val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c,1);
		   }
		}
		System.out.println(map);
	}
}
