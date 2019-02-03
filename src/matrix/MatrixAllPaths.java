package matrix;

import java.util.Arrays;

/**
 * Created  on 12/29/16.
 *
 * FindLongestPath found on web at http://ideone.com/evujRJ
 */
public class MatrixAllPaths {

    public static void main(String[] args) {

        int[][] matrix = getInputMatrix();
        int row = matrix.length;
        int col = matrix[0].length;

        //printAllPaths(matrix, new int[row+col-1],0, row-1, col-1);
        printAllPaths2(matrix, new int[row+col-1],0, 0, 0);
    }

    private static int[][] getInputMatrix() {

        int rows = 3;
        int cols = 3;

        int [][] matrix = new int [rows][cols];

        System.out.println("matrix.length="+matrix.length);
        System.out.println("matrix[0].length="+matrix[0].length);

        int i=1;
        for(int row = 0; row < rows; row++){
            for (int col=0; col< cols; col++){
                matrix[row][col] = i++;
                System.out.print(matrix[row][col]+"     ");
            }
            System.out.println("");
        }
        System.out.println("    ----------");

        return matrix;
    }

    static void printAllPaths(int[][] matrix, int [] arr,int i, int row, int col)
    {
        //System.out.println("Result:"+getReverseArrayString(arr)+"row:"+row+" col:"+col);
        if (row == -1 || col == -1 )
            return;
        arr[i++] = matrix[row][col];

        if(row==0 && col==0)
            System.out.println("Result:"+getReverseArrayString(arr)+"row:"+row+" col:"+col);

        printAllPaths(matrix,arr,i, row-1, col);
        printAllPaths(matrix,arr,i, row, col-1);

        //System.out.println(" ");
    }

    static void printAllPaths2(int[][] matrix, int [] arr,int i, int row, int col)
    {
        //System.out.println("Result:"+getReverseArrayString(arr)+"row:"+row+" col:"+col);
        //System.out.println("printAllPaths2:"+"row:"+row+" col:"+col);
        if(row==matrix.length-1 && col==matrix[0].length-1)
            System.out.println("Result2:"+Arrays.toString(arr)+"row:"+row+" col:"+col);

        if (row > matrix.length-1 || col > matrix[0].length-1 )
            return;

        arr[i++] = matrix[row][col];



        printAllPaths2(matrix,arr,i, row+1, col);
        printAllPaths2(matrix,arr,i, row, col+1);

        //System.out.println(" ");
    }

    private static String getReverseArrayString(int[] arr) {
        int [] reverse = new int[arr.length];
        int j = arr.length-1;
        for(int i : arr) reverse[j--] = i;
        return Arrays.toString(reverse);
    }
}
