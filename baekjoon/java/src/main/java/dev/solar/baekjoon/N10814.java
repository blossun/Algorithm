package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N10814 {

    public static List<Person> arr = new ArrayList<>();
    public static List<Person> sorted = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            arr.add(new Person(Integer.parseInt(str[0]), str[1]));
        }
        Collections.sort(arr);
        for (Person person : arr) {
            sb.append(person.getAge()).append(" ").append(person.getName()).append("\n");
        }
        System.out.println(sb);
    }


}

class Person implements Comparable<Person> {
    private Integer age; //int 안됨.
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        return this.age.compareTo(person.age);
    }

}
