//Kai Rahm
//CS3240

import java.io.*;
import java.util.*;

/**
 * Tests the Binary Search Tree class by inserting the first word from a text file as a root node, 
 * then sorting all words alphabetically into the rest of the rest of the tree
 * @author Atan
 *
 */
public class WordsBST {	
	public static void print(Object line) {
	    System.out.println(line);
	}
	public static void exit(){
		System.exit(0);
	}
	
	
	public static void main(String[] args) throws IOException {
		BST<String> wordsTree = new BST<String>(); //The binary search tree all the words will be added to.
		ArrayList<String> wordList = new ArrayList<String>(); //An array list to make printing the words from the file easier
		
		//This is where the words are uploaded from text and added into a binary search tree (wordsTree)
		File file = new File("words.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		System.out.println("The words from the file are being inserted to the BST: ");
    	while( (line = br.readLine())!= null ){ //makes sure there is still more input in file
    		String words[] = line.split(" ");
		    for(int i=0;i<words.length;i++) {
		    	words[i] = words[i].replaceAll("[^a-zA-Z\\s]", ""); //removes any punctuation characters
				wordsTree.insertNode(words[i]);
				wordList.add(words[i]);
			} 
		}
		br.close();
    	
		//The menu options an interaction happen next
		Scanner input = new Scanner(System.in);
	    String choice = null;
	    while (!"7".equals(choice)) {
	    	print("*******************************************************");
	    	print("Welcome to a Binary Search Tree of Words!");
	    	print("*******************************************************");
	    	print("Press 1 to print the words contained in the file (order written in)");
            print("Press 2 to check how many times a word was in the file");
            print("Press 3 to see an example of integers inserted in a BST");
			print("Press 4 to print the words from the file using InOrder Traversal");
			print("Press 5 to print the words from the file using PreOrder Traversal");
			print("Press 6 to print the words from the file using PostOrder Traversal");
			print("Press 7 to see what the root node is");
			print("Press 8 to quit");
	    
	        choice = input.nextLine();
	        
	        if ("1".equals(choice)) {
	        	print("The words contained in the file that were uploaded are: ");
	        	System.out.printf("[");
	        	for(int i=0; i<wordList.size(); i++){
	        		System.out.printf(" "+wordList.get(i)+" ");
	        	}
	        	System.out.printf("]\n");
	        	choice = null;
	          }
	        if ("2".equals(choice)) {
	        	print("Please enter which word you would like to check the file for: ");
	        	String word = input.nextLine();
	        	wordsTree.getDuplicates(word);
	        	choice = null;
	          }
	        if ("3".equals(choice)) {
	        	print("Here is an example of Integers in a BST: ");
	        	BST<Integer> intTree = new BST<Integer>();
	        	print("------------------------------------------------");
	    		print("The first value entered becomes the Root Node:");
	    		intTree.insertRootNode(5);
	    		print("------------------------------------------------");
	    		print("When entering values they are placed by their size compared to the current parent node.");
	    		print("If a value is smaller than the parent, it goes down the left path, if larger then it goes down the right path.");
	    		print("When it finds a null location it stays there:\n");
	    		intTree.insertNode(3);
	    		intTree.insertNode(6);
	    		intTree.insertNode(1);
	    		intTree.insertNode(4);
	    		intTree.insertNode(1);
	    		intTree.insertNode(2);
	    		intTree.insertNode(0);
	    		intTree.insertNode(5);
	    		intTree.insertNode(9);
	    		intTree.insertNode(1);
	    		intTree.insertNode(7);
	    		intTree.insertNode(8);
	    		print("------------------------------------------------");
	    		print("Finding how many times '1' has been entered:");
	    		intTree.getDuplicates(1);
	    		print("------------------------------------------------");
	    		print("Finding how many times the parent node has been entered:");
	    		intTree.getDuplicates(5);
	    		print("------------------------------------------------");
	    		print("Thank you for viewing this example!");
	    		
	    		choice = null;
	          }
	        if ("4".equals(choice)) {
	        	print("InOrder (alphabetical) Traversal (Left->Parent->Right):");
	        	wordsTree.printInOrder(wordsTree.getRootNode());
	        	choice = null;
	          }
	        if ("5".equals(choice)) {
	        	System.out.println("PreOrder Traversal (Parent->Left->Right):");
	        	wordsTree.printPreOrder(wordsTree.getRootNode());
	        	choice = null;
	          }
	        if ("6".equals(choice)) {
	        	System.out.println("PostOrder Traversal (Left->Right->Parent):");
	        	wordsTree.printPostOrder(wordsTree.getRootNode());
	        	choice = null;
	          }
	        if ("7".equals(choice)) {
	        	System.out.println("The root node is: "+wordsTree.getRootNodeData());
	        	choice = null;
	          }
	        if ("8".equals(choice)) {
	        	print("Thank you for trying this program. Goodbye! ");
	        	exit();
	          }
	    }
	    input.close();
	}
}
