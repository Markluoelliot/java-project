//import jdk.nashorn.internal.objects.annotations.Getter;
//import jdk.nashorn.internal.objects.annotations.Setter;

public class TreeNode {
    public TreeNode leftNode;
    public static TreeNode rootNode;
    public TreeNode rightNode;
    
    public int data;
	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	
	
	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
    public TreeNode() {
    	
    }
	
    
    public TreeNode(int data) {
    	this.data = data;
    }
    public static void middlePrintTree(TreeNode rootTreeNode) {
    	if(rootTreeNode!=null) {
    		middlePrintTree(rootTreeNode.getLeftNode());
    		System.out.println(rootTreeNode.data);
    		middlePrintTree(rootTreeNode.getRightNode());
    	}
    }
    public static void printTree(TreeNode rootTreeNode) {
    	if(rootTreeNode!=null) {
    		System.out.println(rootTreeNode.data);
    		printTree(rootTreeNode.leftNode);
    		printTree(rootTreeNode.rightNode);
    	}
    }
    public static void createTree(TreeNode treeNode,int value) {
    	if(rootNode==null) {
    		treeNode = new TreeNode(value);
    		rootNode = treeNode;
    	}else {
    		TreeNode tempNode = rootNode;
    		while(tempNode!=null) {
    			if(value>tempNode.data) {
    				if(tempNode.getRightNode()==null) {
    					tempNode.rightNode = new TreeNode(value);
    					return;
    				}else {
    					tempNode = tempNode.rightNode;
    				}
    			}else {
    				if(tempNode.getLeftNode()==null) {
    					tempNode.leftNode = new TreeNode(value);
    					return;
    				}else {
    					tempNode = tempNode.leftNode;
    				}
    			}
    		}
    	}
    }
    
    public static int getHeight(TreeNode treeNode) {
    	
    	if(treeNode==null) {
    		return 0;
    	}else {
    		int left = getHeight(treeNode.leftNode);
    		
    		int right = getHeight(treeNode.rightNode);
    		int max = left;
    		if(max < right) {
    			max = right;
    		}
    		return max+1;
    	}
    
    	
    	
    	
    }
    
    public static int getMax(TreeNode treeNode) {
    	if(treeNode==null) {
    		
    		return -1;
    		
    	}else {
    		int left = getMax(treeNode.leftNode);
    		
    		int right = getMax(treeNode.rightNode);
    		
    		int max = Math.max(treeNode.data, Math.max(left, right));

            return max ;
    		
    	}
    	
    }
    public static void main(String[] args) {
		
		
		int arr[] = {5,1,6};
		
		//System.out.println(data);
		for(int s:arr) {
			createTree(rootNode, s);
		}
		printTree(rootNode);
		
		System.out.println(getMax(rootNode));
		//middlePrintTree(rootNode);
	}
}
