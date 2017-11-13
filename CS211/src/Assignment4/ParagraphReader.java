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
	public static final String NL = "";
	private int linecnt = 0;
	private String paragraph;
	public ParagraphReader() {
		
	}
	public ParagraphReader(File file) throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream(file);
		InputStreamReader In = new InputStreamReader(f);
		BufferedReader br = new BufferedReader(In);
		while(linecnt<=3) {
			String s = br.readLine();
			if(s!=null) {
				paragraph = paragraph + s;
				if(linecnt>2) {
					List.add(paragraph);
				}
			}

			if(s==null) {
				if(linecnt==0) {
					List.add(paragraph);
					paragraph = "";
				}
				linecnt++;
			}
			else
				linecnt=0;
		}
		br.close();
	}
	public void readFile(File file) throws IOException, ClassNotFoundException {}
	public void readFile(File file,boolean keptLineBreak) {
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
	protected ArrayList<String> getStringList(){
		return List;
	}
	/*public static void main(String[] args) throws ClassNotFoundException, IOException {
		ParagraphReader r = new ParagraphReader(new File("sample.txt"));
		System.out.println(r.size());
		for (String list : r.List) {
			System.out.println(list);
			
		}
	}*/
}


