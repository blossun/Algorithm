package dev.solar.codingtest;

import java.util.HashMap;

public class Woowa02 {
    public String solution(String S) {
        HashMap<Type, Long> totalFiles = new HashMap<>();
        totalFiles.put(Type.MUSIC, 0L);
        totalFiles.put(Type.IMAGE, 0L);
        totalFiles.put(Type.MOVIE, 0L);
        totalFiles.put(Type.OTHER, 0L);

        String[] fileInfos = S.split("\n");
        for (String fileInfo : fileInfos) {
            File file = new File(fileInfo);
            classifyFile(file, totalFiles);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getInfo(Type.MUSIC, totalFiles))
                .append('\n');
        sb.append(getInfo(Type.IMAGE, totalFiles))
                .append('\n');
        sb.append(getInfo(Type.MOVIE, totalFiles))
                .append('\n');
        sb.append(getInfo(Type.OTHER, totalFiles));
        return sb.toString();
    }

    private String getInfo(final Type type, final HashMap<Type, Long> totalFiles) {
        StringBuilder sb = new StringBuilder();
        return sb.append(type.value).append(' ')
                .append(totalFiles.get(type))
                .append('b').toString();
    }

    private void classifyFile(final File file, final HashMap<Type, Long> totalFile) {
        totalFile.put(file.type, totalFile.get(file.type) + file.size);
    }

    class File {
        Type type;
        long size;

        public File(final String fileInfo) {
            String[] split = fileInfo.split(" ");
            String fileType = extractFileType(split[0]);
            this.type = classifyFileType(fileType);
            this.size = extractFileSize(split[1]);
        }

        private Type classifyFileType(final String fileType) {
            if (fileType.equals("mp3") || fileType.equals("aac") || fileType.equals("flac")) {
                return Type.MUSIC;
            }
            if (fileType.equals("jpg") || fileType.equals("bmp") || fileType.equals("gif")) {
                return Type.IMAGE;
            }
            if (fileType.equals("mp4") || fileType.equals("avi") || fileType.equals("mkv")) {
                return Type.MOVIE;
            }
            return Type.OTHER;
        }

        private Long extractFileSize(final String fileSize) {
            return Long.parseLong(fileSize.replace("b", ""));
        }

        private String extractFileType(final String fileName) {
            int lastDot = fileName.lastIndexOf('.');
            return fileName.substring(lastDot + 1);
        }
    }

    enum Type {
        MUSIC("music"), IMAGE("images"), MOVIE("movies"), OTHER("other");

        Type(final String type) {
            this.value = type;
        }

        private final String value;

        public String value() {
            return value;
        }
    }
}
