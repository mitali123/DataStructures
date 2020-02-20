/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoistackmitali;

/**
 *
 * @author manja
 */
public class TowersOfHanoiStackMitali {

    Stacks[] towers;

    
    void towersOfHanoi(int n)
    {
        towers = new Stacks[4];
        //create 3 stacks for the 3 towers - source, dest, intermediate
        for(int i = 0; i < 4; i++ )
        {
            this.towers[i] = new Stacks();
        }
        //add all the disks to tower 1
        for(int d = n; d > 0; d--)
        {
            towers[1].push(d);
        }
        //move n disks from tower 1 to 2 using 3 as intermediate
        solveTowersOfHanoi(n,1,2,3);
        //push top 5 disks(n-1) to aux tower i.e. tower 2
        
    }
    void solveTowersOfHanoi(int n, int source, int dest, int intermediate)
    {
        if(n>0)
        {
            try
            {
                //move n-1 disks to intermediate tower
                solveTowersOfHanoi(n-1, source, intermediate, dest);
                //move nth disk i.e. disk on top of tower 1 to destination tower
                int popped_disk = towers[source].pop();
                System.out.println("Move disk "+popped_disk+"from top of tower"+source+" to tower"+dest);
                towers[dest].push(popped_disk);
                //move n-1 disks from intermediate tower to destination tower
                solveTowersOfHanoi(n-1, intermediate, dest, source);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }
    public class Stacks{
        int[] myStack;
        int top;

        public Stacks() {
            this.myStack = new int[8];
            this.top = -1;
        }
        
        void push(int disk)
        {
            if(this.top >= 8)
            {
                System.out.println("stack overflow");
            }
            else
            {
                this.top = this.top + 1;
                this.myStack[top] = disk;
            }
        }
        int pop()
        {
            int disk = 0;
            if(this.top == -1)
            {
                System.out.println("Stack underflow");
            }
            else
            {
                disk = this.myStack[this.top]; 
                this.top = this.top - 1;
            }
            return disk;
        }
    }
    public static void main(String[] args) {
        int number_of_disks = 6;
        TowersOfHanoiStackMitali obj = new TowersOfHanoiStackMitali();
        obj.towersOfHanoi(number_of_disks);
    }
    
}
