import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] participants = new String[3];
        String[] searchName = participants;
        System.out.println(participants.length);
        System.out.println(participants[0]
        );
        participants[0] = "김서윤";
        System.out.println(
                participants[0].length()
        );
        String[] names = {"김서윤", null};
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                System.out.println("빈 자리");
                continue;
            }
            System.out.println(names[i]);
        }
        boolean found = false;
        for (String participant : participants) {
            if (participant != null && participant.equals(searchName)) {
                found = true;
                break;
            }
        }
        System.out.println(found);
    }
}