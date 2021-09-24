package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woowa02Test {
    Woowa02 woowa02 = new Woowa02();

    @Test
    void temp() {
        String fileName = "my.song.mp3";
        int lastDot = fileName.lastIndexOf('.');
        String type = fileName.substring(lastDot + 1);
        System.out.println(type);
        String fileSize = "10000b";
        Long size = Long.parseLong(fileSize.replace("b", ""));
        System.out.println(size);
    }

    @Test
    void case01() {
        String S = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";
        String expected = "music 1011b\n" +
                "images 0b\n" +
                "movies 10200b\n" +
                "other 105b";
        String actual = woowa02.solution(S);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String S = "my.song.mp3 11b\n" + "greatSong.flac 1000b\n" + ".mp3.txt 5b\n" + "video.mp4 200b\n" + "game.exe 100b\n" + "mov!e.mkv 10000b";
        String expected = "music 1011b\n" +
                "images 0b\n" +
                "movies 10200b\n" +
                "other 105b";
        String actual = woowa02.solution(S);
        assertEquals(expected, actual);
    }
}
