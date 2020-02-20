/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trial;

import java.io.*; 
  
class Trial { 
      
// Function to count the number within a range  
// whose prime factors are only 2 and 3  
static String find(String a)  
{  
    char[] arr = a.toCharArray();
    int wen=1;
    int bob=0;
    String Wendy=new String("Wendy");
    String Bob=new String("Bob");
            
    for(int i=0;i<arr.length;i++)
    {
        char t = arr[i];
        if(i!= 0 && i!=arr.length-1)
        {
            if(t=='w' && arr[i-1]=='w' && arr[i+1]=='w')
            {
                wen++;
            }
            if(t=='b' && arr[i-1]=='b' && arr[i+1]=='b')
            {
                bob++;
            }
        }
    }
    if(wen>bob)
    {
        return Wendy;
    }
    else 
        return Bob;
}  
  
// Driver code  
    public static void main (String[] args) { 
   
        Trial obj = new Trial();
        String winner=obj.find("wwbbwbbb");
        System.out.println(winner);
        
    } 
//This code is contributed by ajit     
} 
