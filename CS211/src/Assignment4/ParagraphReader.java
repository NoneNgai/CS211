package Assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ParagraphReader {
	private ArrayList<String> List = new ArrayList<>();
	public static final String NL = " ";
	TextFreqHelper t = new TextFreqHelper();
	private String paragraph = null;
	private int linecnt = 0;

	public ParagraphReader() {
		// TODO Auto-generated constructor stub
	}

	public ParagraphReader(File file) throws IOException, ClassNotFoundException {
		readFile(file);
	}

	public void readFile(File file) throws IOException, ClassNotFoundException {

		FileInputStream f = new FileInputStream(file);
		InputStreamReader In = new InputStreamReader(f);
		BufferedReader br = new BufferedReader(In);
		linecnt = 0;
		paragraph = null;
		while (true) {
			String s = br.readLine();
			if (s != null) {
				if (s.isEmpty()) {
					if (linecnt == 0) {

						List.add(paragraph);
					}
					paragraph = "";
					linecnt++;
					if (linecnt == 3) {
						List.add(paragraph);
					}
				} else {
					if (paragraph == null)
						paragraph = s;
					else
						paragraph = paragraph + s;
					if (linecnt > 0) {
						linecnt = 0;
					}
				}
			}
			if (s == null) {
				List.add(paragraph);
				break;
			}
		}
		br.close();

	}

	public void readFile(File file, boolean keptLineBreak) throws IOException {
		FileInputStream f = new FileInputStream(file);
		InputStreamReader In = new InputStreamReader(f);
		BufferedReader br = new BufferedReader(In);
		linecnt = 0;
		paragraph = null;
		while (true) {
			String s = br.readLine();
			if (s != null) {
				if (s.isEmpty()) {
					if (linecnt == 0) {
						List.add(paragraph);
					}
					paragraph = " ";
					linecnt++;
					if (linecnt == 3) {
						List.add(paragraph);
					}
				} else {
					if (keptLineBreak) {
						if (paragraph == null)
							paragraph = s;
						else if(paragraph==" "&&paragraph!=null)
							paragraph = s;
						else {
							paragraph = paragraph + "\n" + s;
						}
					} else {
						if (paragraph == null)
							paragraph = s;
						else 
							paragraph = paragraph + s;
					}
					if (linecnt > 0) {
						linecnt = 0;
					}
				}
			}
			if (s == null) {
				List.add(paragraph);
				break;
			}
		}
		br.close();
	}

	public void clear() {
		List.clear();
	}

	public int size() {
		return List.size();

	}

	public String get(int index) {
		return List.get(index);
	}

	protected ArrayList<String> getStringList() {
		return List;
	}
}
