import java.util.Scanner;

public class shenxinfu {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	String [] str = s.split(",");
    	//是否有非法的
    	boolean flag=false;
    	for(int i=0;i<str.length;i++) {
    		//是都含有-
    		if(isHasSingal(str[i])) {
    			//如果是非法的
    			if(!judge(str[i])) {
    				System.out.println(judge(str[i]));
    				flag=true;
    			}
    			
    		}else {
    			//单个不满足
    			if(!singleNumber(Integer.parseInt(str[i]))) {
    				System.out.println(singleNumber(Integer.parseInt(str[i])));
    				flag=true;
    			}
    		}
    	}
    	if(!flag) {
    	   System.out.println("true");
    	}
	}
    //判断是否含有_
    public static boolean isHasSingal(String s) {
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='-') {
    			return true;
    		}
    	}
    	return false;
    }
    //判断是否-的两端是否成立
    public static boolean judge(String s) {
    	String[] str = s.split("-");
    	int pre = Integer.parseInt(str[0]);
    	int next = Integer.parseInt(str[1]);
    	singleNumber(pre);
    	singleNumber(next);
    	if(pre<next&&(next-pre)<1025) {
    		return true;
    	}
    	return false;
    }
    public static boolean singleNumber(int port) {
    	if(port<=65535&&port>=1) {
    		return true;
    	}
    	return false;
    }
}
