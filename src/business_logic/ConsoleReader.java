package business_logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	private BufferedReader br;

	public ConsoleReader() {
		InputStreamReader is = new InputStreamReader(System.in);
		br = new BufferedReader(is);
	}

	public String getString() throws IOException {
		return br.readLine();
	}
	
	public String getSafetyString(String message) {
		System.out.println(message);
		try {
			return br.readLine();
		} catch (IOException e) {
			return "";
		}
	}
	
	public int getInt(String message) {
		System.out.println(message);
		int intValue = 0;
		while (true) {
			try {
				String strInt = br.readLine();
				intValue = Integer.parseInt(strInt);
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("Wrong input - " + 
						e.getMessage()+". Try again:");
			}
		}
		return intValue;
	}
}
