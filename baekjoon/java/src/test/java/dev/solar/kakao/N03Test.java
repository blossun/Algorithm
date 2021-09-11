package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class N03Test {
    N03 n03 = new N03();

    @Test
    void case01() throws ParseException {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] expected = {14600, 34400, 5000};
        assertArrayEquals(expected, n03.solution(fees, records));
    }

    @Test
    void temp02() {
        int[] fees = {180, 5000, 10, 600};
        double ceil = Math.ceil((334 - fees[0]) / (double)fees[2]);
        System.out.println(ceil);
        int price = (int) (fees[1] + ceil * fees[3]);
        System.out.println(price);
    }

    @Test
    void temp03() {
        int[] fees = {180, 5000, 10, 600};
        double ceil = Math.ceil((146 - fees[0]) / (double)fees[2]);
        System.out.println(ceil);
        int price = (int) (fees[1] + ceil * fees[3]);
        System.out.println(price);
    }

    @Test
    void temp() throws ParseException {
        // 시간차
        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
        Date date1 = f.parse("06:00");
        Date date2 = f.parse("07:01");
        long diff = date2.getTime() - date1.getTime();
        long min = diff / (1000 * 60);
        System.out.println(min);
    }
}
