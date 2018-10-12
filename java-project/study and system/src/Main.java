
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
   /**
    * @author MarkElliot
    * @param args
 * @return 
    */
	public static void main(String[] args) {
	
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
	    String s;
		try {
			s = in.readLine();
			while(s!=null) {
				System.err.println(s);
				s=in.readLine();
			}
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
       
}


