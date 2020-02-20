/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletebstmitali;

/**
 *
 * @author manja
 */
public class DeletebstMitali {

	class Node 
	{ 
		int key; 
		Node left, right; 

		public Node(int item) 
		{ 
			key = item; 
			left = right = null; 
		} 
	} 

	Node root; 

    public DeletebstMitali()  
	{ 
		root = null; 
	} 


	void deleteKey(int key) 
	{ 
		root = deleteRec(root, key); 
	} 

	Node deleteRec(Node root, int key) 
	{ 
		/* Base Case: If the tree is empty */
		if (root == null) return root; 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = deleteRec(root.left, key); 
		else if (key > root.key) 
			root.right = deleteRec(root.right, key); 

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else
		{ 
			// node with only one child or no child 
			if (root.left == null) 
				return root.right; 
			else if (root.right == null) 
				return root.left; 

			// node with two children: Get the inorder successor (smallest 
			// in the right subtree) 
			root.key = minValue(root.right); 

			// Delete the inorder successor 
			root.right = deleteRec(root.right, root.key); 
		} 

		return root; 
	} 

	int minValue(Node root) 
	{ 
		int minv = root.key; 
		while (root.left != null) 
		{ 
			minv = root.left.key; 
			root = root.left; 
		} 
		return minv; 
	} 

	// This method mainly calls insertRec() 
	void insert(int key) 
	{ 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) 
	{ 

		/* If the tree is empty, return a new node */
		if (root == null) 
		{ 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder() 
	{ 
		inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.print(root.key + " "); 
			inorderRec(root.right); 
		} 
	} 

	// Driver Program to test above functions 
	public static void main(String[] args) 
	{ 
		DeletebstMitali t = new DeletebstMitali(); 

		t.insert(50); 
		t.insert(30); 
		t.insert(20); 
		t.insert(40); 
		t.insert(70); 
		t.insert(60); 
		t.insert(80); 

		System.out.println("Inorder traversal"); 
		t.inorder(); 

		System.out.println("\nDelete 20"); 
		t.deleteKey(20); 
		System.out.println("Inorder traversal"); 
		t.inorder(); 

		System.out.println("\nDelete 30"); 
		t.deleteKey(30); 
		System.out.println("Inorder traversal of the modified tree"); 
		t.inorder(); 

		System.out.println("\nDelete 50"); 
		t.deleteKey(50); 
		System.out.println("Inorder traversal of the modified tree"); 
		t.inorder(); 
	} 
} 
