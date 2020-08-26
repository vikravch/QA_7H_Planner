package business_logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
	
	public static void printToFile(String fileName,
			boolean isAppend, String content) {
		File fileToWrite = new File(fileName);
		try {
			FileWriter fw = 
					new FileWriter(fileToWrite,isAppend);
			/*fw.append("aaa");
			fw.append("+++");
			fw.flush();*/
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readFromFile(String fileName) {
		String res = "";
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			
			do {
				res = res+line+"\n";
				line = br.readLine();
			} while(line!=null); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
}








