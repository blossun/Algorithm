package dev.solar.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Woo06 {
    public String[] solution(int totalTicket, String[] logs) throws ParseException {
        List<String> result = new ArrayList<>();
        Persion current = null;
        for (String log : logs) {
            String[] info = log.split(" ");
            if (info[1].equals("request")) {
                // 다른 유저가 접속한 상태인 경우
                if (current == null) {
                    current = new Persion(info[0], info[2]);
                    continue;
                }
                if (isPasswedOneMin(current.request, convertString2Date(info[2]))) { //다른 유저가 접속 후 1분이 지난 경우
                    result.add(current.name);
                    current = new Persion(info[0], info[2]);
                }
                continue;
            }
            if (isPasswedOneMin(current.request, convertString2Date(info[2]))) {
                result.add(current.name);
            }
            current = null;
        }
        // 마지막에 남은 사람이 티켓팅 종료시가(10:00) 전에 성공했는지 확인해서 추가
        if (current != null && isPasswedOneMin(current.request, convertString2Date("10:00:00"))) {
            result.add(current.name);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    public boolean isPasswedOneMin(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        long min = diff / (1000 * 60);
        return min >= 1;
    }

    public Date convertString2Date(String date) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss", Locale.KOREA);
        return f.parse(date);
    }

    class Persion {
        String name;
        Date request;

        public Persion(final String name, final String request) throws ParseException {
            this.name = name;
            this.request = convertString2Date(request);
        }

    }
}
