package recursion;
/*
斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34....，即第一项 f(1) = 1,第二项 f(2) = 1.....,第 n 项目为 f(n) = f(n-1) + f(n-2)。求第 n 项的值是多少。
 */
public class Fq {

    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(f1(4));
    }

    public static int f(int n) {
        if (n <= 2) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static int f1(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f1(n - 1);
    }


    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
