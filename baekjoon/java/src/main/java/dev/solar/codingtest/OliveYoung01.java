package dev.solar.codingtest;

public class OliveYoung01 {
    public int solution(int[] x, int[] y, int[] r, int[] v) {
        int lp = x[0] - r[0];
        int rp = x[0] + r[0];
        int bp = y[0] - r[0];
        int tp = y[0] + r[0];
        for (int i = 1; i < x.length; i++) {
            lp = Math.min(lp, x[i] - r[i]);
            rp = Math.max(rp, x[i] + r[i]);
            bp = Math.min(bp, y[i] - r[i]);
            tp = Math.max(tp, y[i] + r[i]);
        }
        int count = 0;
        for (int i = 0; i < v.length; i++) {
            int xp = transX(v[i], lp, rp);
            int yp = transY(v[++i], bp, tp);
            if (xp >= lp && xp <= rp && yp >= bp && yp <= tp) { //직사각형이 아니라 원의 내부에 있는지 확인해야 한다.
                count++;
            }
        }
        return ( count / (v.length/2) ) * (rp - lp) * (tp - bp);
    }

    public int transX(int x, int lp, int rp) {
        return (lp + x % (rp - lp));
    }

    public int transY(int y, int bp, int tp) {
        return (bp + y % (tp - bp));
    }
}
