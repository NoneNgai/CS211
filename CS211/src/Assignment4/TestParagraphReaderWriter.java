package Assignment4;

import java.io.File;
import java.io.IOException;

public class TestParagraphReaderWriter {
	public static void main(String[] args) throws IOException {
		ParagraphReaderWriter rw = new ParagraphReaderWriter();
		File file = new File("data.txt");
		rw.readFile(file, true);
		rw.insert(0, "This is a new line.\nInsert at pos 0.\n\n\n\n\n");
		rw.insert(1, "");
		rw.insert(rw.size(), "\n\n\n\n Insert \n\n\n\ninto last line.\n\n\n\n\n");
		rw.writerFile(file);
		rw.clear();
		rw.readFile(file, true);
		for (int i=0; i<rw.size(); i++) {
		System.out.println("->" + i + " " + rw.get(i));
		}
		}
	

}
