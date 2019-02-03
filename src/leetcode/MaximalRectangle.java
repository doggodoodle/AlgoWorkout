package leetcode;

/**
 * Created  on 4/11/17.
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle app = new MaximalRectangle();
        char [][] arr = {
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'1','0','1','1','1','0','0','0'}};

        int max = 0;

        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                //max = Math.max(max, app.getMaxArea(arr, i, j));
                //System.out.print(arr[i][j]+" ");
            }

        }

        System.out.println(app.getMaxArea(arr, 0, 0));

        //System.out.println("getMax:"+getColMax(arr, 2, 3));
        //System.out.println("getAreaB:"+getAreaB(arr, 0, 1));
    }

     int getMaxArea(char[][] arr, int iIn, int jIn){
        int colArea = getColMax(arr, iIn, jIn);
        int rowArea = getRowMax(arr,iIn,jIn);
         System.out.println("colArea:"+colArea);
         System.out.println("rowArea:"+rowArea);
        return Math.max(colArea,rowArea );
    }



     int getRowMax(char[][] arr, int iIn, int jIn) {
        if (arr[iIn][jIn] == '0')
            return 0;

        int h = arr.length; int w = arr[0].length;

        //System.out.println("h:"+h+" w:"+w);

        for(int row = iIn; row < h; row++){

            if(arr[row][jIn]=='0') {
                h = row;
                break;
            }
            for(int col = jIn; col < w; col++){
                //System.out.println("*** Checking:"+"arr["+row+"]["+col+"]"+arr[row][col]+"h"+h+"w"+w);
                if(arr[row][col]=='0'){
                    //System.out.println("row:"+row+" col:"+col);
                    if(w>col)
                        w = col;
                    break;
                }
            }

        }

        //System.out.println("hLimit:"+(h));
        //System.out.println("wLimit:"+(w));

        return (h-iIn)*(w-jIn);
    }

     int getColMax(char[][] arr, int iIn, int jIn) {
        if (arr[iIn][jIn] == '0')
            return 0;
        int area = 0;
        int h = arr.length; int w = arr[0].length;

        //System.out.println("h:"+h+" w:"+w);

        for(int col = jIn; col < w; col++){

            if(arr[iIn][col]=='0') {
                w = col;
                break;
            }
            for(int row = iIn; row < h; row++){
                //System.out.println("*** Checking:"+"arr["+row+"]["+col+"]"+arr[row][col]+"h"+h+"w"+w);
                if(arr[row][col]=='0'){

                    //System.out.println("row:"+row+" col:"+col);
                    if(h>row) {

                        h = row;
                    }
                    break;
                }
            }

        }

        //System.out.println("hLimit:"+(h));
        //System.out.println("wLimit:"+(w));

        return Math.max(((h-iIn)*(w-jIn)), area);
    }

}
