package hackerrank;

import java.util.Stack;

/**
 * Created by ritvikmathur on 1/16/17.
 */
public class RobotCircleExists {

    public static void main(String[] args) {

        System.out.println(exists("LR"));

    }

    static boolean  exists(String s1) {

        int x = 0 , y = 0 , i = 0 , dir = 0 ;

        int N = 0 ;

        int E = 1 ;

        int W = 3 ;

        dir = N;

        char postionArray [] = s1.toCharArray();

        while (i < postionArray.length) {

            if(postionArray[i] == 'G') {

                if(dir == N) {

                    y++;

                }else if(dir == W) {

                    x--;

                }else if(dir == E){

                    x++;

                }else{

                    y--;

                }

            }else if(postionArray[i] == 'L') {

                dir = (4+dir -1 ) %4;

            }else if(postionArray[i] == 'R'){

                dir = (dir+1)%4;

            }

            i++;

        }

        if( x == y) {

            return true;

        }else {

            return false;

        }

    }


}
