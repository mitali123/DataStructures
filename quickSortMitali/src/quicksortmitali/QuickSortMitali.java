/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortmitali;

/**
 *
 * @author manja
 */
public class QuickSortMitali {

    private int[] aList;

    public QuickSortMitali(int[] aList) {
        this.aList = aList;
    }

    public int[] quickSort(int[] aList) {
        quickSortHelper(aList, 0, aList.length - 1);
        return aList;
    }

    public int[] quickSortHelper(int[] aList, int first, int last) {
        if (first < last) {
            int splitpoint = partition(aList, first, last);
            System.out.println("");
            System.out.println("Splitpoint is:" + splitpoint);
            for (int i : aList) {
                System.out.print(i + " ");
            }
            System.out.println("");
            quickSortHelper(aList, first, splitpoint - 1);
            quickSortHelper(aList, splitpoint + 1, last);
        }
        return aList;
    }

    public int partition(int[] aList, int first, int last) {
        int pivotValue = aList[first];

        int leftmark = first + 1;
        int rightmark = last;

        boolean flag = false;
        while (!flag) {
            while ((leftmark <= rightmark) && (aList[leftmark] <= pivotValue)) {
                leftmark = leftmark + 1;
            }

            while (aList[rightmark] >= pivotValue && rightmark >= leftmark) {
                rightmark = rightmark - 1;
            }

            if (rightmark < leftmark) {
                flag = true;
            } else {
                int temp = aList[leftmark];
                aList[leftmark] = aList[rightmark];
                aList[rightmark] = temp;
            }

            int temp = aList[first];
            aList[first] = aList[rightmark];
            aList[rightmark] = temp;

        }
        System.out.println("Inside partition");
        for (int i : aList) {
            System.out.print(i + " ");
        }
        return rightmark;
    }

    public static void main(String[] args) {
        int[] aList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        QuickSortMitali qs = new QuickSortMitali(aList);
        int[] sortedArray = qs.quickSort(aList);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
    
}
