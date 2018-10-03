package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Array2D {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int arrSize=arr.length;
        int[][] sumArray = new int[arrSize-2][arrSize-2];
        int upperRowSum=0;  
        int middleRowElement=0;
        int lowerRowSum=0;
        int sumBox=0;
        int totalSum=0;
        for(int i=0; i < arr.length-2; i++){
            for(int j=0; j < arr[j].length-2; j++){
                //Grap the three elements in upper row
               
                upperRowSum = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                middleRowElement= arr[i+1][j+1];
                lowerRowSum = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                sumBox = upperRowSum + middleRowElement + lowerRowSum;
                sumArray[i][j] = sumBox;
                
            }
        }
        
         int tempElement=0;
        for(int row=0; row< sumArray.length; row++){
            for(int col=0; col< sumArray[row].length; col++){
                System.out.print(sumArray[row][col]+" ");
                if(row==0 && col ==0) {
                    tempElement = sumArray[row][col];
                }else {
                    if(tempElement< sumArray[row][col])
                        tempElement = sumArray[row][col];
                }
                
            }
        }
        
        return tempElement;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("input00.txt")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
