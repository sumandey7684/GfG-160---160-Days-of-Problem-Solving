class Solution {
    double solve(double b, int e) {
        if (e == 0) return 1;
        double res = solve(b, e / 2);
        res = res * res;
        if (e % 2 == 1) return b * res;
        else return res;
    }

    double power(double b, int e) {
        if (e < 0) b = 1 / b;
        return solve(b, Math.abs(e));
    }
}
