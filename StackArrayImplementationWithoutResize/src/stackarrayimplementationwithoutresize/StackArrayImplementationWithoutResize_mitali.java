/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackarrayimplementationwithoutresize;

/**
 *
 * @author manja
 */
public class StackArrayImplementationWithoutResize_mitali {

        public static void main(String[] args) {
        StackImpl stack1 = new StackImpl();
        Data obj1 = new Data();
        
        obj1.setNumber(31);
        obj1.setName("Name1");
        stack1.push(obj1);
        System.out.println("pushed element 1");
        
        Data obj2 = new Data();
        
        obj2.setNumber(24);
        obj2.setName("Name2");
        stack1.push(obj2);
        System.out.println("pushed element 2");
        
        Data obj3 = new Data();
        
        obj3.setNumber(21);
        obj3.setName("Name3");
        stack1.push(obj3);
        System.out.println("pushed element 3");
        
        Data obj4 = new Data();
        
        obj4.setNumber(14);
        obj4.setName("Name4");
        stack1.push(obj4);
        System.out.println("pushed element 4");
        
        Data obj5 = new Data();
        
        obj5.setNumber(44);
        obj5.setName("Name5");
        stack1.push(obj5);
        System.out.println("pushed element 5");
        
        Data obj6 = new Data();
        
        obj6.setNumber(85);
        obj6.setName("Name6");
        stack1.push(obj6);
        System.out.println("pushed element 6");
        
        System.out.println("Element at top:");
        Data obj = stack1.peek();
        System.out.println(obj.getName());
        System.out.println(obj.getNumber());    
        
        System.out.println("pop element at top");
        Data poppedobj = stack1.pop();
        System.out.println(poppedobj.getName());
        System.out.println(poppedobj.getNumber()); 
        
        System.out.println("Element at top:");
        Data obj22 = stack1.peek();
        System.out.println(obj22.getName());
        System.out.println(obj22.getNumber()); 
        
  }
    
}

class Data {
        int number;
        String name;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }
    
    
class StackImpl {
    
    int capacity = 5;
    Data stack[] = new Data[capacity];
    Data copy[];
    int top;
    
    public StackImpl() {
        this.top = -1;
    }
    
    boolean isEmpty()
    {
        if(top < 0)
            return true;
        else
            return false;
    }
    
    void push(Data data)
    {
        //if full
        if(top == (capacity-1))
        {
            System.out.println("Stack full");
            
        }
        else
        {
            top = top + 1;
            stack[top] = data;
        }       
    }
    
    Data pop()
    {
        
        if(top < 0)
        {
            System.out.println("Stack Underflow");
            return null;
        }
        else
        {
            Data poppedData = stack[top];
            top = top - 1;
            return poppedData;
        }
    }
    
    Data peek()
    {
        if(!isEmpty())
        {
            Data peekData = stack[top];
            return peekData;
        }
        return null;
    }
    
   
    
}
