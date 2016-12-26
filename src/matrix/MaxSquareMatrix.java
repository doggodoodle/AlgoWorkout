package matrix;

/**
 * Created by ritvikmathur on 12/24/16.
 */
public class MaxSquareMatrix {

    public static void main(String[] args) {
        String[][] matrix = new String[4][3];
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = i+"-"+j;
            }
        }
        /*for (int i = 1; i< matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = i+"-"+j+".bad";
            }
        }*/

        matrix[2][2] = ".bad";
        System.out.println(findMaxSquare(matrix));

    }

    static int findMaxSquare(String[][] matrix){
        int max = 0;
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int maxR = matrix.length -i;
                int maxC = matrix[0].length  - j;
                int maxSearch = Math.min(maxC, maxR);
                if(max >= maxSearch)
                    continue;
                boolean breakFlag = false;
                for(int x = 0; x < maxSearch+1 && !breakFlag; x++){
                    System.out.println("---");
                    System.out.println("Checking at i="+i+" j ="+j+" maxX="+x);
                    if(checkSize(matrix,i,j,x)){
                        if (max < x)
                            max = x;
                    }
                    else
                        breakFlag = true;
                }
            }
        }

        return max;
    }



    static boolean checkSize(String[][] matrix, int iM, int jM, int max){

        for(int k=0, i = iM;  i < matrix.length && k < max; i++, k++){
            for( int l = 0, j = jM; j < matrix[i].length && l < max; j++, l++){
                System.out.println("matix : "+i+":"+j+" = "+matrix[i][j]);
                if(!matrix[i][j].equals(i+"-"+j))
                    return false;
            }
        }

        return true;

    }
}
