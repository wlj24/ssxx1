package recursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Dg2 {
    public static void main(String[] args) {
        System.out.println(f(4));
    }

    public static int f(int n){
        if (n<=2){
            return n;
        }
        return f(n-1)+f(n-2);
    }
}
