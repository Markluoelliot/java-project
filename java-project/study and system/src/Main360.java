
import java.util.*;

public class Main360{
	public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         String s = sc.nextLine();
		 //String s = "wow! Is wonderful!";
		 s= s.replace(".", " ");
		 s= s.replace(",", " ");
		 s= s.replace(":", " ");
		 s= s.replace("!", " ");
		 String[] str = s.split("\\s+");
		 
		 Map<String,Integer> map = new TreeMap<String,Integer>();
		 //定义非法字符串
		 int count =0;
		 for(int i=0;i<str.length;i++) {
			 if(isContainsNumber(str[i])) {
				count++;
				continue;
			 }
			 Integer value = map.get(str[i]);
			 if(value==null) {
				 map.put(str[i], 1);
			 }else {
				 value++;
				 map.put(str[i], value);
			 }
		 }
		 for(Map.Entry<String, Integer> m:map.entrySet()) {
			 System.out.print(m.getKey()+" "+m.getValue());
		     System.out.println();
		 }
		 
		 System.out.println(count);
	    }
	public static boolean isContainsNumber(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				return true;
			}
				
			
		}
		return false;
	}
	}


	
	


	
