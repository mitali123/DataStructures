/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivefibonaccimitali;

/**
 *
 * @author manja
 */
public class RecursiveFibonacciMitali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 6;
        RecursiveFibonacciMitali obj = new RecursiveFibonacciMitali();
        int fibonacci = obj.fibonacci(6);
        System.out.println("fibonacci of 6: "+fibonacci);
    }
    int fibonacci(int n)
    {
        if(n <= 1)
        {
            return n; 
        }
        else
        {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
}
