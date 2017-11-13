package Assignment4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ParagraphReaderWriter extends ParagraphReader {
	public ParagraphReaderWriter() {
		super();
	}

	public void insert(int index, String string) {
		if (string.equals("")) {
			super.getStringList().add(index, NL + NL + NL);
		} else {
			String str = string.trim();
			String s[] = str.split(NL + NL + NL + NL);
			str = "";
			for (int i = 0; i < s.length; i++) {
				str += s[i] + "\n";
			}
			super.getStringList().add(index, str);
		}
	}
	public void writerFile(File file) {
		try (BufferedWriter write = new BufferedWriter(new FileWriter(file));) {
			String text = "";
			for (int i = 0; i < super.size(); i++) {
				text += super.getStringList().get(i);
			}
			write.write(text);
		} catch (IOException io) {

		}
	}
}
