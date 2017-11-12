package Assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ParagraphReader {
	private ArrayList<String> List;
	public static final String NL = null;
	public ParagraphReader() {
		List = new ArrayList<>();
	}
	public ParagraphReader(File file) throws IOException {
		readFile(file);
	}
	public void readFile(File file) throws IOException {
		FileReader f = new FileReader(file);
		BufferedReader br = new BufferedReader(f);
		String s = br.readLine();
		while(s!=null) {
			//List.add((String)br.readLine());
			//br.readLine();
			System.out.println(br.readLine());
		}
		br.close();
	}
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
	public static void main(String[] args) throws IOException {
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
		}
		
		
	}


