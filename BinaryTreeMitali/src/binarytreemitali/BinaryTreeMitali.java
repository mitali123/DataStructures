/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreemitali;

/**
 *
 * @author manja
 */
public class BinaryTreeMitali {

    int count = 0;
  

    public Node constructTree(Node node, int key) {
        Node newNode = new Node(key);
        if (node == null) {
            count++;
            return newNode;
        } else {
            if (key < node.key) {
                node.left = constructTree(node.left, key);

            } else {
                node.right = constructTree(node.right, key);
            }
        }
        return node;
    }

    //display traversal
    public void display(Node node) {

        if (node != null) {
            display(node.left);
            System.out.print(node.key + " ");
            display(node.right);
        }
    }

    //search a key
    public Node search(Node node, int key) {

        if (node == null || node.key == key) {
            return node;
        }
        if (key < node.key) {
            return search(node.left, key);
        }
        return search(node.right, key);

    }

    //search min key
    public Node searchMin(Node node) {

        if (node.left == null) {
            return node;
        }
        return searchMin(node.left);

    }

    //search max key
    public Node searchMax(Node node) {

        if (node.right == null) {
            return node;
        }
        return searchMax(node.right);

    }

    public Node delete(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);

        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {

            //if node has one child or no child
            if (root.left == null) {
                Node temp = root.right;
                count--;
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                count--;
                return temp;
            } //if not a leaf node, find the next display successor
            //replace the current node with its next display successor
            //delete the display successor
            else {
                Node temp = searchMin(root.right);
                root.key = temp.key;
                delete(root.right, temp.key);
                count--;
            }
        }

        return root;
    }

    //delete minimum element in the tree
    public Node deleteMin(Node root) {

        if (root == null) {
            return root;
        }
        count--;
        return delete(root, searchMin(root).key);
    }

    public Node deleteMax(Node root) {

        if (root == null) {
            return root;
        }
        count--;
        return delete(root, searchMax(root).key);
    }

    //number of elements in tree  
    public int size() {
        return count;
    }

    public int height(Node node) {

        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeMitali bst = new BinaryTreeMitali();
        Node root = null;
        root = bst.constructTree(root, 3);
        bst.constructTree(root, 7);
        bst.constructTree(root, 9);
        bst.constructTree(root, 23);
        bst.constructTree(root, 45);
        bst.constructTree(root, 1);
        bst.constructTree(root, 5);
        bst.constructTree(root, 12);
        bst.constructTree(root, 55);
        bst.constructTree(root, 24);
        bst.constructTree(root, 13);
        bst.constructTree(root, 11);
        bst.constructTree(root, 8);
        bst.constructTree(root, 19);
        bst.constructTree(root, 4);
        bst.constructTree(root, 31);
        bst.constructTree(root, 35);
        bst.constructTree(root, 56);
        bst.display(root);
//		System.out.println(bst.height(root));
        System.out.println(" ");
        System.out.println("Min Value is:" + bst.searchMin(root).key);
        System.out.println("Delete min value: ");
        bst.deleteMin(root);
        bst.display(root);
        System.out.println(" ");
        System.out.println("Max Value is:" + bst.searchMax(root).key);
        System.out.println("Delete max value: ");
        bst.deleteMax(root);
        bst.display(root);

    }

    class Node {

        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
//		this.left = null;
//		this.right = null;
        }
    }

}

