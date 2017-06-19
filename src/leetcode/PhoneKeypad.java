package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ritvikmathur on 4/25/17.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 */
public class PhoneKeypad {

    class CNode{
        Character n;
        List<String> alphas = new ArrayList<>();
        public CNode(Character n){
            this.n = n;
        }
        public String toString(){
            return n+":"+alphas.toString();
        }
    }

    Map<Character, CNode> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        for(int i = 0; i < digits.length(); i++){
            Character c = digits.charAt(i);
            if(map.containsKey(c))
                continue;
            CNode node = new CNode(c);
            switch(c){
                case '2':
                    node.alphas.add("a");
                    node.alphas.add("b");
                    node.alphas.add("c");
                    break;
                case '3':
                    node.alphas.add("d");
                    node.alphas.add("e");
                    node.alphas.add("f");
                    break;
                case '4':
                    node.alphas.add("g");
                    node.alphas.add("h");
                    node.alphas.add("i");
                    break;
                case '5':
                    node.alphas.add("j");
                    node.alphas.add("k");
                    node.alphas.add("l");
                    break;
                case '6':
                    node.alphas.add("m");
                    node.alphas.add("n");
                    node.alphas.add("o");
                    break;
                case '7':
                    node.alphas.add("p");
                    node.alphas.add("q");
                    node.alphas.add("r");
                    node.alphas.add("s");
                    break;
                case '8':
                    node.alphas.add("t");
                    node.alphas.add("u");
                    node.alphas.add("v");
                    //node.alphas.add("s");
                    break;
                case '9':
                    node.alphas.add("w");
                    node.alphas.add("x");
                    node.alphas.add("y");
                    node.alphas.add("z");
                    break;
                default:
                    return new ArrayList<>();

            }
            map.put(c, node);
            //System.out.println(map);
        }

        if(map.size()==0)
            return new ArrayList<>();


        List<String> res = new ArrayList<>();

        visit("",digits, 0, res);

        return res;

    }

    void visit (String str, String digits, int i, List<String> res){
        Character c = digits.charAt(i);
        CNode node = map.get(c);
        for(String s : node.alphas){
            StringBuilder sb = new StringBuilder(str);
            sb.append(s);
            if(i == digits.length()-1)
                res.add(sb.toString());
            else
                visit(sb.toString(), digits, i+1, res);
        }
    }


}
