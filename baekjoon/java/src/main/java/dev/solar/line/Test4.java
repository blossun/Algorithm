package dev.solar.line;

import java.util.HashMap;

public class Test4 {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        HashMap<String, String> flagRules = new HashMap<>();
        for (String flag_rule : flag_rules) {
            String[] rule = flag_rule.replace("-", "").split(" ");
            flagRules.put(rule[0], rule[1]);
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            // 프로그램명 확인
            if (!isCorrectProgramName(program, command)) {
                continue;
            }
            command = command.substring(command.indexOf(" "));
            String[] params = command.split(" -");
            boolean violation = false;
            for (int j = 0; j < params.length; j++) {
                Flag flag = Flag.parseFlag(params[j]);
                if (flag == null) {
                    continue;
                }
                if (flagRules.containsKey(flag.getFlagName())) {
                    if (!isCorrentFlagRule(flagRules.get(flag.getFlagName()), flag)) {
                        violation = true;
                    }
                } else { //없는 flag인 경우
                    violation = true;
                }
            }

            answer[i] = !violation;
        }
        return answer;
    }

    public boolean isCorrentFlagRule(String flagType, Flag flag) { //flag가 지정한 규칙에 맞는지 확인
        if (flagType.equals("NULL")) {
            return flag.getFlagValue() == null;
        }
        if (flagType.equals("STRING")) {
            char[] chars = flag.getFlagValue().toCharArray();
            for (char ch : chars) {
                if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                    return false;
                }
            }
            return true;
        }
        if (flagType.equals("NUMBER")) {
            char[] chars = flag.getFlagValue().toCharArray();
            for (char ch : chars) {
                if (!(ch >= '0' && ch <= '9')) {
                    return false;
                }
            }
            return true;
        }
        return false; //규칙에 없는 flag라면 false
    }

    private boolean isCorrectProgramName(String program, String command) {
        String inputProgramName = command.substring(0, command.indexOf(" "));
        return inputProgramName.equals(program);
    }

    static class Flag {
        private String flagName;
        private String flagValue;

        public Flag(String flagName) {
            this.flagName = flagName;
        }

        public Flag(String flagName, String flagValue) {
            this.flagName = flagName;
            this.flagValue = flagValue;
        }

        public String getFlagName() {
            return flagName;
        }

        public String getFlagValue() {
            return flagValue;
        }

        public static Flag parseFlag(String flag) { //flag 문자열을 파싱해서 Flag 생성
            if (flag.equals("")) {
                return null;
            }

            String[] splitString = flag.split(" ");
            if (splitString.length == 1) {
                return new Flag(splitString[0]);
            }
            if (splitString.length == 2) {
                return new Flag(splitString[0], splitString[1]);
            }
            return null;
        }
    }

}

