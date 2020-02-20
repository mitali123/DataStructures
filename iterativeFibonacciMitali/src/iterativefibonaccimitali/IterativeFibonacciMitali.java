/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterativefibonaccimitali;

/**
 *
 * @author manja
 */
public class IterativeFibonacciMitali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 6;
        IterativeFibonacciMitali obj = new IterativeFibonacciMitali();
        int fibo = obj.fibonacci(n);
        System.out.println("Fibonacci of 6: "+fibo);
       
    }
    int fibonacci(int n)
    {
        int prev_num = 0;
        int prev_prev_num = 1;
        int num = 0;
        if(n <= 1)
            return n;
        else
        {
            for(int i = 2;i <= n; i++)
            {
                num = prev_num + prev_prev_num;
                prev_num = prev_prev_num;
                prev_prev_num = num;
            }
            return num;
        }
    }
    
}
