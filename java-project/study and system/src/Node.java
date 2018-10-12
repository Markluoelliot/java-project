
public class Node {
   static Node header ;
	/**
	 * @author MarkElliot
	 */
	public int data;
    
    public Node next;
    
    public Node() {
    	
    }
    public Node(int data) {
    	this.data = data;
    }
    
    

    public Node(int data,Node next) {
    	this.data = data;
    	this.next = next;
    }
    
    public static int addHead(int data) {
    	Node newHead = new Node(data);
    	newHead.next = header;
    	header = newHead;
    		
    	
    	return data;
    }
    public static void addData(int data) {
    	
    	Node newNode = new Node(data);
    	if(header==null) {
    		header = newNode;
    		return;
    	}
    	Node temp = header;
    	while(temp.next!=null) {
    		temp = temp.next;
    	   
    	    }
    	temp.next = newNode;
    	
    }
    public static int getLength(Node header) {
    	int size = 0;
    	if(header==null) {
    		return 0;
    	}
    	Node temp = header;
    	while(temp!=null) {
    		size++;
    		temp = temp.next;
    	}
    	return size;
    }
    public static void traverse(Node header) {
    	Node temp = header;
    	
    	while(temp!=null) {
    	System.out.println(temp.data);
    	
    	temp = temp.next;
    	}
    }
    public static void insertNode(Node node,int index,int data) {
    	if(index<1||index>getLength(header)) {
    		System.out.println("error");
    	}
    	Node temp = header;
    	int currentPos = 0 ;
    	node = new Node(data);
    	if(index==0) {
			node.next = temp;
			//temp.next = node;	
			header = node;
    		
			return;
		} 
    	while(temp!=null) {
    		if(index ==currentPos) {
    			
    			node.next = temp.next;
    			temp.next = node;
    			
    			
    		}
    		currentPos++;
    		temp = temp.next;
    	}
    }
    public static void delete(Node node,int index) {
    	int currentPos = 0;
    	Node temp = header;
    	if(index==0) {
    		node.next = temp.next;
    		header = node;
    		return;
    	}
    	while(temp!=null) {
    		if((index-1)==currentPos) {
    			temp.next = temp.next.next;
    		}
    		currentPos++;
    		temp = temp.next;
    	}
    }
    public static void sort(Node node) {
    	Node currentNode;
    	Node nextNode;
    	for(currentNode = header.next;currentNode.next!=null;currentNode =currentNode.next) {
    		for(nextNode = header.next;nextNode.next!=null;nextNode = nextNode.next) {
    			if(nextNode.data>nextNode.next.data) {
    				int tmp = nextNode.next.data;
    				nextNode.next.data = nextNode.data;
    				nextNode.data = tmp;
    			}
    		}
    	}
    }
    public static void main(String[] args) {
		
		addData(1);
		addData(6);
		
		
		addData(3);
		
		
		sort(header);
		traverse(header);
		
	}
}
