/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesortingmitali;
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import java.util.Scanner;
import javax.imageio.ImageIO; 

/**
 *
 * @author manja
 */
public class ImageSortingMitali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedImage img = null;
        File f = null;
        int choice=0;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter your choice: 1.Heapsort 2.Quicksort 3.Mergesort 4.Selectionsort");
        choice = myObj.nextInt();
        
        try
        {
            f = new File("C:\\Users\\manja\\Desktop\\Boston.jpeg");
            img = ImageIO.read(f);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        int width = img.getWidth(); 
        int height = img.getHeight(); 
        int i = 0;
        
        double intensityArray[] = new double[width*height];
        
        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++)
            {
                int pixel = img.getRGB(x, y);
                
                int red = (pixel>>16) & 0xff;
                int blue = pixel & 0xff;
                int green = (pixel>>8) & 0xff;
                
                double intensity = 0.2989 * red + 0.5870 * green + 0.1140 * blue;  
                intensityArray[i++] = intensity;
            }
        }
        System.out.println("Intensity Array:(Before Sorting)");
        for(int j = 0;j<intensityArray.length;j++)
        {
            System.out.println(intensityArray[j]);
        }
        ImageSortingMitali obj = new ImageSortingMitali();
        if(choice == 1)
        {
            //callHeapsort();
            obj.heapSort(intensityArray);
            System.out.println("Intensity Array:(After Heap Sorting)");
             for(int j = 0;j<intensityArray.length;j++)
             {
                  System.out.println(intensityArray[j]);
             }
        }
        else if(choice == 2)
        {
            //callquicksort
            obj.quickSort(intensityArray, 0, intensityArray.length-1);
            System.out.println("Intensity Array:(After Quick Sorting)");
             for(int j = 0;j<intensityArray.length;j++)
             {
                  System.out.println(intensityArray[j]);
             }
        }
        else if(choice == 3)
        {
            //call mergesort
             obj.mergeSort(intensityArray, 0, intensityArray.length-1); 
             System.out.println("Intensity Array:(After Merge Sorting)");
             for(int j = 0;j<intensityArray.length;j++)
             {
                  System.out.println(intensityArray[j]);
             }
        }
        else
        {
            //call selectionsort
            obj.selectionSort(intensityArray); 
             System.out.println("Intensity Array:(After Selection Sorting)");
             for(int j = 0;j<intensityArray.length;j++)
             {
                  System.out.println(intensityArray[j]);
             }
        }
        
    }
    //merge sort functiona----------------------------------------------------------------------------
    void merge(double arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        double L[] = new double [n1]; 
        double R[] = new double [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] >= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void mergeSort(double arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    // quick sort functions ---------------------------------------------------------------------------------
    int partition(double arr[], int low, int high) 
    { 
        double pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is greater than or 
            // equal to pivot 
            if (arr[j] >= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        double temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    void quickSort(double arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    } 
    //heap sort functions---------------------------------------------------------------------------
     public void heapSort(double arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            double temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
     void heapify(double arr[], int n, int i) 
    { 
        int smallest = i; // Initialize smallest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] < arr[smallest]) 
            smallest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] < arr[smallest]) 
            smallest = r; 
  
        // If largest is not root 
        if (smallest != i) 
        { 
            double swap = arr[i]; /////////////////////todo
            
            arr[i] = arr[smallest]; 
            arr[smallest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, smallest); 
        } 
    } 
     
     //selection sort functions--------------------------------------------------------------------------------
      void selectionSort(double arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the Max element in unsorted array 
            int max_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] > arr[max_idx]) 
                    max_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            double temp = arr[max_idx]; 
            arr[max_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
}
