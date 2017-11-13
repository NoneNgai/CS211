package Assignment4;

import java.io.File;
import java.io.IOException;


public class ParagraphReaderTest {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ParagraphReader reader = new ParagraphReader(new File("sample.txt"));
		for (int i=0; i<reader.size(); i++) {
				System.out.println(i+ " " + reader.get(i));
				System.out.print("Most freq char of paragraph "+i +": ");
					try {
						if(TextFreqHelper.isAtoZ(TextFreqHelper.findMostCommonChar(reader.get(i)))) {
						System.out.println(TextFreqHelper.findMostCommonChar(reader.get(i)));
						}
						else
							System.out.println("No Character (a-z)");
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
		ParagraphReaderWriter wr = new ParagraphReaderWriter();
		}
}
