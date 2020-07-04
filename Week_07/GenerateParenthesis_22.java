package Week_07;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * Created by xutao on 2020/7/5.
 */
public class GenerateParenthesis_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int left = 0,right = 0;
        generate(left,right,n,res,"");
        return res;
    }

    private void generate(int left, int right,int n, List<String> res,String s) {
        //terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        //process current logic
        if(left < n){
            generate(left + 1,right,n,res,s + "(");
        }

        if(right < left && right < n) {
            generate(left,right + 1,n,res,s + ")");
        }
    }

}
