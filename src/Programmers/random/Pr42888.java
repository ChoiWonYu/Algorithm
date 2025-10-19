package Programmers.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr42888 {

    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<Event> events = new ArrayList<>();
        // event와 userMap 초기화
        for (String r : record) {
            String[] arr = r.split(" ");
            String event = arr[0];
            String uid = arr[1];

            Event e = new Event(event, uid);
            events.add(e);
            if (event.equals("Enter") || event.equals("Change")) {
                String name = arr[2];
                userMap.put(uid, name);
            }
        }

        return events.stream()
                     .filter(Event::needResult)
                     .map(e ->
                         String.format(e.getResult(), userMap.get(e.uid))
                     )
                     .toArray(String[]::new);
    }

    static class Event {

        String event;
        String uid;

        public Event(String event, String uid) {
            this.event = event;
            this.uid = uid;
        }

        public boolean needResult() {
            return !event.equals("Change");
        }

        public String getResult() {
            if (event.equals("Enter")) {
                return "%s님이 들어왔습니다.";
            } else if (event.equals("Leave")) {
                return "%s님이 나갔습니다.";
            } else {
                return null;
            }
        }
    }
}
