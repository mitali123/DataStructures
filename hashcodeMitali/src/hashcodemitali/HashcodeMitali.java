/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcodemitali;
import java.lang.Math;

/**
 *
 * @author manja
 */
public class HashcodeMitali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "Welcome Students to Class";
        //System.out.println(str.hashCode());
        double k = 0.0;
        double h = 0.0;
        int n = str.length();
            //char val[] = value;
            for (int i = 0; i < str.length(); i++) 
            {
                k = str.charAt(i);
                h = h + (k * Math.pow(31.0,n-1-i));
            }
            System.out.println("hashcode:"+h);   
    }
}
