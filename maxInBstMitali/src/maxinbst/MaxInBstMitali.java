/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxinbst;

/**
 *
 * @author manja
*/
class MaxInBstMitali { 
	Node root; 

	static char findMax(Node node) 
	{ 
		if (node == null) 
			return (char)Integer.MIN_VALUE; 

		int res = node.data; 
		int lres = findMax(node.left); 
		int rres = findMax(node.right); 

		if (lres > res) 
			res = lres; 
		if (rres > res) 
			res = rres; 
		return (char) res; 
	} 

	public static void main(String args[]) 
	{ 
		MaxInBstMitali tree = new MaxInBstMitali(); 
		tree.root = new Node('A'); 
		tree.root.left = new Node('B'); 
		tree.root.right = new Node('C'); 
		tree.root.left.right = new Node('D'); 
		tree.root.left.right.left = new Node('G'); 
                tree.root.left.right.left.left = new Node('I'); 
		tree.root.right.left = new Node('E'); 
		tree.root.right.right= new Node('F');
                tree.root.right.left.right = new Node('H'); 
                tree.root.right.left.right.right = new Node('K');
                tree.root.right.left.right.left = new Node('J');

		System.out.println("Maximum element is " + 
						tree.findMax(tree.root)); 
	} 
} 

class Node { 
	char data; 
	Node left, right; 

public Node(char data) 
	{ 
		this.data = data; 
		left = right = null; 
        }
}


