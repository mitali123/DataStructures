/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistqueue;

/**
 *
 * @author manja
 */
public class TestLinkedListQueue_mitali {
    
    qNode front, rear;

       public TestLinkedListQueue_mitali() {
        this.front = this.rear = null;
    }
    public static void main(String[] args) {
        TestLinkedListQueue_mitali test = new TestLinkedListQueue_mitali();
        
        System.out.println("adding element 1 to queue");
        test.enqueue(1);
        System.out.println("adding element 2 to queue");
        test.enqueue(2);
        System.out.println("adding element 3 to queue");
        test.enqueue(3);
        System.out.println("adding element 4 to queue");
        test.enqueue(4);
        
        int dequeued_element = test.dequeue();
        System.out.println("element dequeued:"+ dequeued_element);
        
        boolean queue_empty = test.isEmpty();
        System.out.println("is queue empty?-"+queue_empty);
        
        int top = test.peek();
        System.out.println("element at top:"+top);
        
    }
    
    
    private class qNode {
        int key;
        qNode next;
        
        qNode(int key)
        {
            this.key = key;
            this.next = null;
        }
    }
    
    
    public void enqueue(int key)
    {
        //create a new node and add it to the queue
        qNode newnode = new qNode(key);
        
        //if queue is empty
        if(this.rear == null)
        {
            this.rear = newnode;
            this.front = newnode;
        }
        else
        {
            this.rear.next = newnode;
            this.rear = newnode;
            newnode.next = null;
        }
    }
    
    public int dequeue()
    {
        //if queue is empty
        if(!isEmpty())
        {
            qNode deletedNode = this.front;
            this.front = this.front.next;
            
            //if only 1 node left i.i if front becomes null then make rear also null
            if(this.front == null)
                this.rear = null;
            
            return(deletedNode.key);
        }
        return -1;
    }
    
    public boolean isEmpty()
    {
        if(this.rear == null)
            return true;
        else
            return false;
    }
    
    public int peek()
    {
        //if queue is empty
        if(!isEmpty())
        {
            qNode topNode = this.front;
            
            return(topNode.key);
        }
        return -1;
    }
    
    
    
}
