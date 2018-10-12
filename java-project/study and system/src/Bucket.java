import java.util.Arrays;
import java.util.Collections;

public class Bucket {
    public static void main(String[] args) {
		int []arr = {23,44,511,1,6234};
		int max = findmax(arr);
		System.out.println(max);
		
		for(int i=0;max/10>0;i++) {
			int [][] bucket = new int[arr.length][10];
			
		}
    	
	}
    public static int findmax(int arr[]) {
    	Arrays.sort(arr);
    	return arr[arr.length-1];
    	
    }
}
