//Kai Rahm
//CS3240

/**
 * A class that makes a Binary Search Tree that can be implemented with different objects.
 * @author Kai
 *
 * @param <E> Specifies what object type you want the Binary Search Tree to be
 */
public class BST<E> {
	private E data;
	private BST<E> rootNode;
	private BST<E> leftNode;
	private BST<E> rightNode;
	private int height=0;
	private int duplicateCounter=0;
	
	
	public BST(){
		super();
	}
	public BST(E data){
		super();
		this.data = data;
		leftNode=null;
		rightNode=null;
	}
	public static void print(Object line) {
	    System.out.println(line);
	}
	
	public void insertRootNode(E data1){
		BST<E> newLink = new BST<E>(data1);
		newLink.leftNode = null;
		newLink.rightNode = null;
		if(rootNode==null){
			rootNode = newLink;
		}else{
			print("There already exists a root node.");
		}
		System.out.println("The root node '"+newLink.data+"' was inserted.\n");
	}
	public void insertNode(E data1){
		BST<E> newNode = new BST<E>(data1);
		BST<E> tempNode = rootNode;
		BST<E> setNode = tempNode;
		int heightCounter=0;
		
		if(rootNode == null){
			rootNode = newNode;
			System.out.println("The root node '"+newNode.data+"' was inserted.\n");
			return;
		}		
		while (tempNode != null){
			if (newNode.data.toString().compareToIgnoreCase(tempNode.data.toString()) > 0){
				System.out.println("Moving on from parent node: "+tempNode.data);
				tempNode = tempNode.rightNode;
				System.out.println("To the right child node."); 
				if(tempNode == null){
					setNode.rightNode = newNode; // b/c next child will be null, this says the new node will now come next (changes it from null)
					//if this is not set, setNode has only leaves, and the tree will always stop at a null node					
				}
			}
			else if (newNode.data.toString().compareToIgnoreCase(tempNode.data.toString()) < 0){
				System.out.println("Moving on from parent node: "+tempNode.data);
				tempNode = tempNode.leftNode;
				System.out.println("To the left child node.");
				if(tempNode == null){
					setNode.leftNode = newNode;
				}	
			}else{
				print ("The node '"+newNode.data+"' has already been inserted.");
				tempNode.duplicateCounter++;
				System.out.println("This node now has "+tempNode.duplicateCounter+" duplicate(s) entered (in addition to original).\n");
				return;
			}
			setNode=tempNode; //setNode becomes the childNode that tempNode pointed to (that was null) so it can take in the new value
			heightCounter++; //any time we pass or stop traversing on a node, 1 will be added to height
		}			
		setNode = newNode; //now that setNode is the null Node, newNode can be put in it's place
		setNode.height = heightCounter;
		System.out.println("The node '"+setNode.data+"' was inserted at tree height: "+setNode.height+"\n");	
	}
	public int getDuplicates(E item){
		int counter=0;
		BST<E> tempNode = rootNode;
			
		while (tempNode != null){
			if (item.toString().compareToIgnoreCase(tempNode.data.toString()) > 0){
				//System.out.println("Item not found. Moving on from parent node: "+tempNode.data);
				tempNode = tempNode.rightNode;
				//System.out.println("To the right child node."); 
				if(tempNode == null){
					print("The item "+item.toString()+" was not found in the tree. (0 entries)");					
				}
			}
			else if (item.toString().compareToIgnoreCase(tempNode.data.toString()) < 0){
				//System.out.println("Item not found. Moving on from parent node: "+tempNode.data);
				tempNode = tempNode.leftNode;
				//System.out.println("To the left child node.");
				if(tempNode == null){
					print("The item "+item.toString()+" was not found in the tree. (0 entries)");	
				}	
			}else{
				print ("The node "+tempNode.data+" has been found at tree height "+tempNode.height);
				System.out.println("The node "+tempNode.data+" has been entered "+(tempNode.duplicateCounter+1)+" times.\n");
				counter = tempNode.duplicateCounter;
				return counter;
			}
		}
		return counter;
	}
	public BST<E> getRootNode(){
		return rootNode;
	}
	public E getRootNodeData(){
		return rootNode.data;
	}
	public void printPreOrder(BST<E> tempNode) {
		if (tempNode != null) {
			print(tempNode.data);
			printPreOrder(tempNode.leftNode);
			printPreOrder(tempNode.rightNode);
		}
	}
	public void printPostOrder(BST<E> tempNode) {
		if (tempNode != null) {
			printPostOrder(tempNode.leftNode);
			printPostOrder(tempNode.rightNode);
			print(tempNode.data);
		}
	}

	public void printInOrder(BST<E> tempNode) {
		if (tempNode != null) {
			printInOrder(tempNode.leftNode);
			print(tempNode.data);
			printInOrder(tempNode.rightNode);
		}
	}
}//end BST
