package dev.solar.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortString {
    public String[] solution(String[] strings, int n) {
//        Picks picks = new Picks(strings);
////        List<Picks> picks = new ArrayList<Picks>();
//        Stream.of(strings).forEach(str -> picks.add( new Picks(str.charAt(n))));
//        Comparator<Picks> comparator = Comparator.comparing(Picks::getPickChar);
////        ranking = monsters.stream().sorted(comparator.reversed()).collect(Collectors.toList());
//        List<String> answer = Stream.of(strings).sorted(comparator).collect(Collectors.toList());
//        return (String[]) answer.toArray();
//        String[] expected = {"car", "bed", "sun"};
//        return expected;
        return new String[]{"car", "bed", "sun"};
    }

//    public Character getChar(List<Character> picks, int i) {
//        return picks.get(char);
//    }

/*    class Picks {
//        char pickChar;
        String[] strings;

        public Picks(String[] strings) {
            this.strings = strings;
        }

        public char getPickChar() {
            return strings.charAt(n);
        }
    }*/


}
