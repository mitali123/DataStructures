/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivefactorialmitali;

import com.sun.javafx.scene.web.Debugger;

/**
 *
 * @author manja
 */
public class RecursiveFactorialMitali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = 7;
        RecursiveFactorialMitali obj = new RecursiveFactorialMitali();
        int factorial = obj.findFactorial(7);
        System.out.println("Factorial of 7:"+factorial);
    }
    int findFactorial(int num)
    {
        if(num == 0 || num == 1)
        {
            return 1;
        }
        else
        {
            return num * findFactorial(num-1);
        }
        
    }
    
}
