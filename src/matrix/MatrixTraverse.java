package matrix;

/**
 * Created by ritvikmathur on 12/29/16.
 */
public class MatrixTraverse {

    static int[] stack;
    static int top;



    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        String [][] matrix = new String [rows][cols];

        System.out.println("matrix.length="+matrix.length);
        System.out.println("matrix[0].length="+matrix[0].length);

        for(int row = 0; row < rows; row++){
            for (int col=0; col< cols; col++){
                matrix[row][col] = row+"|"+col;
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println("");
        }
        System.out.println("    ----------");
        System.out.println(paths(matrix,0,0));

    }

    static int paths(String[][] matrix, int row, int col){
        System.out.println(matrix[row][col]);

        if(row >= matrix.length-1 || col >=matrix[0].length-1)
            //Cells on end rows and columns
            return 1;

        return paths(matrix,row+1, col) + paths(matrix, row, col+1);
    }

}
