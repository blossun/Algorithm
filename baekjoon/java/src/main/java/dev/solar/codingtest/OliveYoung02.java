package dev.solar.codingtest;

import java.util.*;
import java.util.stream.Collectors;

public class OliveYoung02 {
    static HashMap<Integer, List<Station>> subwayMap = new HashMap<>();
    static HashMap<Integer, List<Integer>> lineMap = new HashMap<>();
    static int answer = 1;
    static int end;

    public int solution(String[] subway, int start, int end) {
        this.end = end;
        //노선 정보 저장
        //각 역을 key로 갖는 HashMap <역, <호선:index>>
        for (int line = 0; line < subway.length; line++) {
            String[] stopStation = subway[line].split(" ");
            lineMap.put(line, Arrays.stream(stopStation).map(Integer::parseInt).collect(Collectors.toList()));

            for (int i = 0; i < stopStation.length; i++) {
                int currentStation = Integer.parseInt(stopStation[i]);
                if (subwayMap.containsKey(currentStation)) {
                    List<Station> lineStation = subwayMap.get(currentStation);
                    lineStation.add(new Station(currentStation, line, i));
                } else {
                    List<Station> lineStation = new ArrayList<>();
                    lineStation.add(new Station(currentStation, line, i));
                    subwayMap.put(currentStation, lineStation);
                }
            }
        }

        List<Station> lineStation = subwayMap.get(start);
        dfs(lineStation.get(0), 0);

        return answer;
    }

    public void dfs(Station station, int count) { //station 현재 위치한 역
        // 최종 목적지에 도착한 경우
        // 이미 방문한 역이거나, 더이상 갈 역이 없거나 <- 도달 가능한 경우만 주어짐
        if (station.getStation() == end) {
            answer = Math.min(answer, count);
            return ;
        }

        // 다음으로 이동할 수 있는 모든 역 탐색
        List<Integer> line = lineMap.get(station.getLine());
        int stationIndex = station.getIndex() + 1;

        // 해당 노선의 다음 역이 없다면 종료
        if (stationIndex == line.size()) {
            return ;
        }

        List<Station> nextStations = subwayMap.get(line.get(stationIndex));
        for (Station nextStation : nextStations) {
            dfs(nextStation, count++);
        }
    }
}

class Station {
    private int station;
    private int line;
    private int index;

    public Station (int station, int line, int index) {
        this.station = station;
        this.line = line;
        this.index = index;
    }

    public int getStation() {
        return station;
    }

    public int getLine() {
        return line;
    }

    public int getIndex() {
        return index;
    }
}
