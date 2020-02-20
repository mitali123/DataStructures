/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsortmitali;

/**
 *
 * @author manja
 */ 
public class CountingSortMitali 
{ 
	void sort(char arr[]) 
	{ 
		int n = arr.length; 

		// The output character array that will have sorted arr 
		char output[] = new char[n]; 

		
		int count[] = new int[256]; 
		for (int i=0; i<256; ++i) 
			count[i] = 0; 

		// store count of each character 
		for (int i=0; i<n; ++i) 
			++count[arr[i]]; 

		for (int i=1; i<=255; ++i) 
			count[i] += count[i-1]; 
                

		for (int i = n-1; i>=0; i--) 
		{ 
			output[count[arr[i]]-1] = arr[i]; 
			--count[arr[i]]; 
		} 
 

		for (int i = 0; i<n; ++i) 
			arr[i] = output[i]; 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		CountingSortMitali ob = new CountingSortMitali(); 
		char arr[] = {'a', 'b', 'd', 'c', 'c', 'e', 'd', 
					'd', 'f', 'c', 'a', 'b', 'b','e','d','d','c','c','e','f','d','d','a','a','f'
					}; 

		ob.sort(arr); 

		System.out.print("Sorted character array is "); 
		for (int i=0; i<arr.length; ++i) 
			System.out.print(arr[i]); 
	} 
} 


    

