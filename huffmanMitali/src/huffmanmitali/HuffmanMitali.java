/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanmitali;
import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.util.Comparator; 
/**
 *
 * @author manja repair count occurences
 */
public class HuffmanMitali {
    // main function
    static final int MAX_CHAR = 256; 
    public static int count[] = new int[MAX_CHAR];
  
    public static void main(String[] args) 
    { 
        String str = "This was hard quiz for students";
        //str = str.replaceAll("\\s","");
        //str = str.toLowerCase();
        int n = 16;

        char[] charArray = {'x','a','d','e','f','h','i','n','o','q','r','s','t','u','w','z'};
        int[] charfreq = {5,2,2,1,1,2,2,1,1,1,2,4,3,2,1,1};
        HuffmanMitali obj = new HuffmanMitali();
       
        //create priority queue
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(charArray.length,new MyComparator());
        
        //create huffman nodes and assign char and values to them and add them to pq
        for(int i = 0; i < charArray.length; i++ )
        {                
            HuffmanNode newnode = new HuffmanNode(charfreq[i], charArray[i]);
            queue.add(newnode);
        }
        //create root node
        HuffmanNode root = null;
        
        while(queue.size() > 1)
        {
            
            //find the 2 nodes with least freq
            HuffmanNode a = queue.peek();
            queue.poll();
            
            HuffmanNode b = queue.peek();
            queue.poll();
            
            //add the freq of these 2 nodes
            int x = a.data + b.data;
            
            //create a new parent node for these 2 nodes
            HuffmanNode pnode = new HuffmanNode(x, '-');
            //point the parent node to both the child nodes
            pnode.left = a;
            pnode.right = b;
            
            //make parent node as the root node
            root= pnode;
            
            //insert the parentnode to the queue
            queue.add(pnode);
        }
        //traverse the tree and print the codes
        obj.traverseTree(root,"");
    }
    void traverseTree(HuffmanNode root, String code)
    {
        //base case - this is a leaf node, print the code generated 
        if(root.left == null && root.right == null && Character.isLetter(root.c))
        {
            System.out.println(root.c+" : "+code);
            return;
        }
     
            //recursive call for left and right subtree
            //add 0 for left and 1 for right
            traverseTree(root.left, code + "0");
            traverseTree(root.right, code + "1");
        
    }
    
    
}
    
class HuffmanNode{
        int data;
        char c;
        
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(int value, char letter) {
            this.data = value;
            this.c = letter;
            this.left = null;
            this.right = null;
        }
    }
    
class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y)
        {
            return x.data - y.data;
        }
    }

    
 
