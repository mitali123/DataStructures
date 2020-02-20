/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackarrayimplementation;

import java.util.ArrayList;

/**
 *
 * @author manja
 */
public class StackArrayImplementationWithResizing_mitali {

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
            //resize -- increase the size * 2
            System.out.println("Increasing the stack size by 2");
            resize(capacity * 2);
            top = top + 1;
            stack[top] = data;
        }
        else
        {
            top = top + 1;
            stack[top] = data;
        }       
    }
    
    Data pop()
    {
        if(capacity > 0 && capacity == stack.length/4) {
            resize(stack.length/2);
        }
        if(top < 0)
        {
            System.out.println("Stack Underflow");
            return null;
        }
        else if(top < (capacity - 1)/2)
        {
            System.out.println("Stack too large, resizing.Original Length:"+stack.length);
            stack = resize((stack.length/2));
            top =top - 1;
            Data poppedData = stack[top];
            System.out.println("new length:"+stack.length);
            return poppedData;
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
    
    private Data[] resize(int newcapacity)
	{
                System.out.println("resizing the stack capacity, new capacity:"+newcapacity);
		Data[] copy = new Data[newcapacity];
		for (int i = 0; i <= top; i++)
		   copy[i] = stack[i];
		stack = copy;
                return stack;
	} 
    
}
