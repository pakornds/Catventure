import java.text.DecimalFormat;

public class PascalRuleMethods {

    private static final DecimalFormat format = new DecimalFormat("0");

    public void input(int m) {
        calc(m);
    }

    public void calc(int degree) {

        System.out.print("(a+b)^" + degree + " = ");
        for (int i = 0; i <= degree; i++) {
            double coefficient = binomialCoeff(degree, i);
            if (i == degree)
                System.out.print(format.format(coefficient) + "a^" + (degree - i) + " " + "b^" + i + " ");
            else
                System.out.print(format.format(coefficient) + "a^" + (degree - i) + " " + "b^" + i + " + ");
        }
    }

    public static double binomialCoeff(int n, int k) {
        if (k == 0 || k == n) {
            return 1.0;
        }

        double[][] dp = new double[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1.0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}
