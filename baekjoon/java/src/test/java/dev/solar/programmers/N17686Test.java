package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N17686Test {

    N17686 n17686 = new N17686();

    @Test
    void temp() {
        String num = "0010";
        System.out.println(Integer.parseInt(num));

        String file = "foo010bar020.zip";
//        String file = "foo9.txt";
//        String file = "F-15";
        int stIndex = 0;
        while (stIndex < file.length()) {
            char ch = file.charAt(stIndex);
            if ('0' <= ch && ch <= '9') {
                break;
            }
            stIndex++;
        }
        int endIndex = stIndex;
        while (endIndex < file.length()) {
            char ch = file.charAt(endIndex);
            if (!('0' <= ch && ch <= '9')) {
                break;
            }
            endIndex++;
        }
        System.out.println(file.substring(0, stIndex) + ", " + file.substring(stIndex, endIndex) + ", " + file.substring(endIndex));
    }

    @Test
    void case01() {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] expected = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        String[] files = {"foo9.txt", "F-15", "foo010bar020.zip"};
        String[] expected = {"F-15", "foo9.txt", "foo010bar020.zip"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        String[] files = {"ABC12","AbC12","aBc12"};
        String[] expected = {"ABC12","AbC12","aBc12"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case04() {
        String[] files = {"a00000456.png", "a00000123.GIF"};
        String[] expected = {"a00000456.png", "a00000123.GIF"};
//        String[] expected = {"a00000123.GIF", "a00000456.png"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }


    @Test
    void case05() {
        String[] files = {"img000012345", "img1.png","img2","IMG02"};
        String[] expected = {"img000012345", "img1.png","img2","IMG02"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case06() {
        String[] files = {"img465", "img123.png", "img123"};
        String[] expected = {"img123.png", "img123", "img465"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case07() {
        String[] files = {"img100.p2ng", "img202.png123"};
        String[] expected = {"img100.p2ng", "img202.png123"};
        String[] actual = n17686.solution(files);
        assertArrayEquals(expected, actual);
    }
}
