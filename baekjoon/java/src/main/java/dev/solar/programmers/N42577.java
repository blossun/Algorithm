package dev.solar.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class N42577 {
    public boolean solution(String[] phone_book) {
//        Arrays.sort(phone_book); //문자열로 정렬되므로 첫 숫자가 작은값이 앞서게 된다.
        // 문자열이 짧은 순서로 정렬하도록 해야함
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        HashSet<Integer> hashSetPhoneBook = new HashSet<>();
        HashSet<Integer> phoneLengths = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            for (Integer phoneLength : phoneLengths) {
                int hashCode = phone_book[i].substring(0, phoneLength).hashCode();
                if (hashSetPhoneBook.contains(hashCode)) {
                    return false;
                }
            }
            hashSetPhoneBook.add(phone_book[i].hashCode());
            phoneLengths.add(phone_book[i].length());
        }

        return true;
    }
}
