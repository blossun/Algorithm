package dev.solar.kakao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class N03 {
    public int[] solution(int[] fees, String[] records) throws ParseException {
        // 주차했던 차량 목록
        HashMap<String, ParkingInfo> hashMap = new HashMap<>();

        for (String record : records) {
            String[] info = record.split(" ");
            if (info[2].equals("IN")) {
                // 주차한적 있는 차량인 경우
                if (hashMap.containsKey(info[1])) {
                    ParkingInfo parkingInfo = hashMap.get(info[1]);
                    parkingInfo.in(info[0]);
                } else { // 처음 주차하는 차량
                    ParkingInfo parkingInfo = new ParkingInfo(info[1]);
                    parkingInfo.in(info[0]);
                    hashMap.put(info[1], parkingInfo);
                }
            } else {
                ParkingInfo parkingInfo = hashMap.get(info[1]);
                parkingInfo.out(info[0]);
            }
        }

        // 출차하지 않은 차량 출차
        for (ParkingInfo info : hashMap.values()) {
            if (!info.isOut) {
                info.out();
            }
            info.charge(fees);
        }

        int[] answer = hashMap.values().stream()
                .sorted(ParkingInfo::compareTo)
                .mapToInt(p -> p.price)
                .toArray();

        // 시각 차량번호 내역
        return answer;
    }

    class ParkingInfo implements Comparable<ParkingInfo> {
        String id;
        int accumulateSum;
        String inTime;
        String outTime;
        boolean isOut;
        int price;

        public ParkingInfo(final String id) {
            this.id = id;
        }

        public void in(String time) {
            this.inTime = time;
            this.outTime = "23:59";
            this.isOut = false;
        }

        public void out(String time) throws ParseException {
            this.outTime = time;
            accumulate();
            this.isOut = true;
        }

        public void out() throws ParseException {
            accumulate();
            this.isOut = true;
        }

        private void accumulate() throws ParseException {
            this.accumulateSum += getTimeLag(this.inTime, this.outTime);
        }

        public void charge(int[] fees) {
            if (accumulateSum <= fees[0]) {
                this.price = fees[1];
                return;
            }
            this.price = (int) (fees[1] + Math.ceil((accumulateSum - fees[0]) / (double)fees[2]) * fees[3]);
        }

        @Override
        public int compareTo(final ParkingInfo o) {
//            차량 번호가 작은 자동차부터
            return this.id.compareTo(o.id);
        }
    }

    public int getTimeLag(String before, String after) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
        Date date1 = f.parse(before);
        Date date2 = f.parse(after);
        long diff = date2.getTime() - date1.getTime();
        long min = diff / (1000 * 60);
        return (int) min;
    }
}
