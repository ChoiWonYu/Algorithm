package Programmers.random_2nd;

import java.util.HashMap;
import java.util.Map;

public class Pr42888 {

    public static final String SEPARATOR = "-";

    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        StringBuilder answerBuilder = new StringBuilder();
        for (String rc : record) {
            String[] rcArr = rc.split(" ");
            String cmd = rcArr[0];
            String uid = rcArr[1];
            switch (cmd) {
                case "Enter":
                    users.put(uid, rcArr[2]);
                    answerBuilder.append(uid)
                                 .append(SEPARATOR)
                                 .append(" 들어왔습니다.")
                                 .append(SEPARATOR);
                    break;
                case "Change":
                    users.put(uid, rcArr[2]);
                    break;
                case "Leave":
                    answerBuilder.append(uid)
                                 .append(SEPARATOR)
                                 .append(" 나갔습니다.")
                                 .append(SEPARATOR);
                    break;
            }
        }
        String[] nameSeparated = answerBuilder.toString().split(SEPARATOR);
        answerBuilder.setLength(0);
        for (int i = 0; i < nameSeparated.length; i++) {
            if (users.containsKey(nameSeparated[i])) {
                answerBuilder.append(users.get(nameSeparated[i]))
                             .append("님이");
            } else {
                answerBuilder.append(nameSeparated[i])
                             .append(SEPARATOR);
            }
        }
        return answerBuilder.toString()
                            .split(SEPARATOR);
    }
}
