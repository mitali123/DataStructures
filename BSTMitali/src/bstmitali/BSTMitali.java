/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstmitali;

/**
 *
 * @author manja
 */
public class BSTMitali {

	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

    // Constructor 
    public BSTMitali() {
        
    }
	 { 
		root = null; 
	} 

	void insert(int key) { 
	root = insertRec(root, key); 
	} 

	Node insertRec(Node root, int key) { 

		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 


	void inorder() { 
	inorderRec(root); 
	} 

	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 

	public static void main(String[] args) { 
		BSTMitali tree = new BSTMitali(); 

	
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		// print inorder traversal of the BST 
		tree.inorder(); 
	} 
} 

