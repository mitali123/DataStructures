/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countstringbinarymitali;

/**
 *
 * @author manja
 */
public class CountStringBinaryMitali {

	public int countStrings(int n)
	{
		if(n==1){
			return 2;
		}
		if(n==0){
			return 1;
		}
		return countStrings(n-2)+countStrings(n-1);

	}

	public static void main(String[] args)
	{
		int n = 4;
		CountStringBinaryMitali obj=new CountStringBinaryMitali();
		int result=obj.countStrings(n);
		System.out.println(result);
	}
}
    
