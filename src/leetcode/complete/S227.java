package leetcode.complete;

/**
 * @ClassName S227
 * @Description: TODO
 * @Author shanz
 * @Date 2019/8/18
 * @Version V1.0
 **/
public class S227 {

    // 2的幂
    // 2进制中若n能被2整除 n则为1000000形式  n-1 为111111110形式
    public boolean isTwo(int n){

        if(n<=0)
        return false;
        return ((n&(n-1)) == 0);
    }

}
