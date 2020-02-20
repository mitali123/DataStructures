/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularqueuemitali;

/**
 *
 * @author manja
 */
public class CircularQueueMitali {

    /**
     * @param args the command line arguments
     */
    int Queue[] = new int[50];
    int n, front, rear;
    public static void main(String[] args) {
        CircularQueueMitali obj = new CircularQueueMitali(10);
        System.out.println("Enqueue all input data:");
        //enqueue all input data
        obj.enqueue(12);
        obj.enqueue(17);
        obj.enqueue(38);
        obj.enqueue(3);
        obj.enqueue(9);
        obj.enqueue(82);
        obj.enqueue(10);
        obj.enqueue(31);
        obj.enqueue(24);
        obj.enqueue(31);
        
        //display the queue
        obj.display();
        
        //dequeue 3 elements
        int delement1 = obj.dequeue();
        int delement2 = obj.dequeue();
        int delement3 = obj.dequeue();
        
        System.out.println("dequeued 3 elements");
        System.out.println("dequeued elements: "+delement1+","+delement2+","+delement3);
        
        //enqueue 2 elements
        System.out.println("enqueued 2 elements");
        obj.enqueue(55);
        obj.enqueue(99);
        
        //dequeue all elements
        System.out.println("Elements in the queue before dequeuing");
        obj.display();
        System.out.println("Dequeuing all elements from the queue:");
        while(obj.rear != obj.front)
        {
            int i = obj.dequeue();
            System.out.println(i);
        }
        obj.display();
        
        
        
        
    }
    public CircularQueueMitali(int size)
    {
        n=size;
        front = 0;
        rear=0;
  }
    void enqueue(int item)
    {
        if(!isFull())
        {
            rear = (rear+1)%n;
            Queue[rear] = item;
        }
        else 
        {
            System.out.println("Queue is full !");
        }
    }
    Boolean isFull()
    {
        if((rear+1) % n == front)
        {
            return true;
        }
        else
            return false;
    }
    Boolean isEmpty()
    {
        if(front == rear)
        {
            return true;
        }
        else
            return false;
    }
    int dequeue()
    {
        int item;
        if(!isEmpty())
        {
            front = (front+1)%n;
            item = Queue[front];
            return item;
        }
        else
        {
            System.out.println("Can't remove element from queue - queue empty");
        }
        return 0;
    }
    void display()
    {
        int i;
        if(!isEmpty())
        {
            for(i=(front+1)%n ; i<rear ; i=(i+1)%n)
            {
                System.out.println(Queue[i]);
            }
        }
        else
         System.out.println("Queue is empty !");
    }
}

  
   
  
   
  
    
  
   

