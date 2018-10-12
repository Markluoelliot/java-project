

public class Sort {
    public static void main(String[] args) {
		int []arr = {2,5,1,3,4};
		//bubble(arr);
		//selectSort(arr);
		//insertSort(arr);
		quickSort(arr, 0, arr.length-1);
		for(int s:arr) {
			System.out.print(s+" ");
		}
		System.out.println(findMax(arr, 0, arr.length));
	}
    public static void bubble(int[]arr) {
    	for(int i=0;i<arr.length;i++) {
    	   int isSort =0;
    		for(int j=0;j<arr.length-1-i;j++) {
    	    	
    	    	if(arr[j]>arr[j+1]) {
    	    		int tmp = arr[j];
    	    		arr[j] = arr[j+1];
    	    		arr[j+1] = tmp;
    	    		isSort = 1;
    	    	}
    	    }
    		if(isSort==0) {
    			break;
    		}
    	}
    }
    public static void selectSort(int []arr) {
    	for(int i=0;i<arr.length;i++) {
    		int k=0;
    		
    		for(int j=0;j<arr.length-i;j++) {
    		
    			
    			if(arr[j]>arr[k]) {
    				k=j;
    			}
    		}
    	int temp=arr[arr.length-1-i];
    	arr[arr.length-1-i] =arr[k];
    	arr[k] = temp;
    	}
    }
    public static void insertSort(int []arr) {
    	
    		
    	int temp;
    	for(int i=1;i<arr.length;i++) {
    		temp = arr[i];
    		while(i>=1&&arr[i-1]>temp) {
    			arr[i] = arr[i-1];
    			i--;
    		}
    		arr[i] = temp;
    	}
    	
    }
    
    public static int findMax(int[] arr,int left,int right) {
    	if(left==right) {
    		return 0;
    	}else {
    		int max =arr[left];
    		int max2 = findMax(arr,left+1,right);
    	    if(max >max2) {
    	    	return max;
    	    }else {
    	    	return max2;
    	    }
    	}
    	
    	
    }
    
    public static void quickSort(int []arr,int left,int right) {
    	int i = left;
    	int j = right;
    	int privot = arr[(left+right)/2];
    	while(i<=j) {
    		while(privot > arr[i]) {
    			i++;
    		}
    		while(privot<arr[j]){
    			j--;
    		}
    		if(i<=j) {
    			int temp = arr[i];
    			arr[i] = arr[j];
    			arr[j] = temp;
    			i++;
    			j--;
    		}
    	}
    	if(left<j) {
    		quickSort(arr, left, j);
    	}
    	if(i < right) {
    		quickSort(arr,i,right);
    	}
    }
    
    public static void mergeSort(int arr[],int L,int R) {
    	if(L==R) {
    		return;
    	}else {
    		int M = (L+R)/2;
    		mergeSort(arr, L, M);
    		mergeSort(arr, M+1, R);
    		merge(arr,L,M+1,R);
    	}
    }
	private static void merge(int[] arr, int L, int M, int R) {
		// TODO Auto-generated method stub
		int []leftArray = new int[M-L];
		
		int[] rightArray = new int[R-M+1];
		
		for(int i=L;i<M;i++) {
			leftArray[i-L] =arr[i];
			
		}
		for(int i=M;i<=R;i++) {
			leftArray[i-M] =arr[i];
		}
		int i=0,j=0;
	}
    
}
  
