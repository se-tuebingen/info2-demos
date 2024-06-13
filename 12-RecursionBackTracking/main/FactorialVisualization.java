package main;

public class FactorialVisualization {
    int iFact = 0;
    int[] factArr = new int[4];

    public void main(String[] args) {
        int result = factorialRecursive(5);
        System.out.println(result);
    }
    int factorialRecursive(int n){
        int f =1;
        if (n == 1)
            return n;
        else {
            f = n * factorialRecursive(n - 1);
            // This operation is executed during un-stacking, going up the pile
            // Ask students what is the value of n when the debugger stops here (n==4 or n==1 n==2?)
            factArr[iFact++] = f;
        }
        return f;
    }
}
