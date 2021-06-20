package Algos.Recursion;

// https://practice.geeksforgeeks.org/problems/special-keyboard3018
public class SpecialKeyboard {
    public void rum(){
        System.out.println("SpecialKeyboard Time limit exceeded!");
    }

    private int optimalKeys(int N){
        return keys(N, 0, 0);
    }

    private int keys(int n, int sum, int sc) {
        // base condition
        if (n == 0)
            return sum;

        // key 1: enter A only if copied is less than 1
        int key1Sum = sc < 1 ? keys(n -1, sum+1, sc) : 0;

        // Key 2: SelectAll only when A's count > already copied and we can copy and paste
        // There is no point of selecting if not coping and pasting. So we copy and paste
        int key2Sum = sum > 1 && sum > sc && n >= 3 ? keys(n-3, sum + sum, sum) : 0;

        // Key 3: Copy selected. Copy only if prev operation is select all i.e. SA == sum and we can paste
        // Already handled in key 2
        //int key3Sum = sa == sum  && sa > 1 && n > 1? keys(n-1, sum, sa, sa) : 0;

        // Key 3: paste copied
        int key4Sum = sc > 1 ? keys(n-1, sum + sc, sc) : 0;

        int max1 = Math.max(key1Sum, key2Sum);

        return Math.max(max1, key4Sum);
    }
}
