import java.util.Scanner;

class StudentEntry {
    String studentId;
    String name;
}

public class FinalEventCheckIn_student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentEntry[] entries = new StudentEntry[5];

        while (true) {
            System.out.println("\n[취업 특강 접수]");
            System.out.println("1 신청  2 명단  3 취소  4 현황  0 종료");
            System.out.print("선택: ");
            String menu = scanner.nextLine().trim();

            if (menu.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case "1":
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine().trim();
                    System.out.print("이름: ");
                    String name = scanner.nextLine().trim();

                    // TODO 1. 빈 학번이나 빈 이름은 거절하세요.
                    if(studentId.isEmpty() || name.isEmpty()){
                        System.out.println("이름과 학번둘다 적으세요.");
                        break;
                    }
                    // TODO 2. 같은 학번이 이미 있는지 배열 전체를 확인하세요.
                    boolean duplicate = false;
                    for(int i = 0; i < entries.length; i++){
                        if(entries[i] != null && entries[i].studentId.equals(studentId)){
                            duplicate = true;
                            break;
                        }
                    }
                    if(duplicate){
                        System.out.println("이미 신청한 학생");
                    }

                    // TODO 3. null인 첫 칸을 찾고 StudentEntry 객체를 저장하세요.
                    int emptyIndex = -1;
                    for(int i=0;i< entries.length;i++){
                        if(entries[i]==null){
                             emptyIndex = i;
                             break;
                        }
                    }
                    StudentEntry newEntry = new StudentEntry();
                    newEntry.studentId = studentId;
                    newEntry.name = name;
                    entries[emptyIndex] = newEntry;
                    System.out.println(name + "학생의 신청이 완료");

                    // TODO 4. 다섯 칸이 모두 찼다면 정원 마감을 출력하세요.
                   if(emptyIndex == -1){
                       System.out.println("정원 마감");
                       break;
                   }
                    break;

                case "2":
                    // TODO 5. null을 건너뛰며 위치, 학번, 이름을 출력하세요.
                    // 아무도 없으면 "등록된 신청자가 없습니다."를 출력하세요.
                    boolean hasEntry = false;
                    for (int i = 0; i < entries.length; i++) {
                        if (entries[i] != null) { // null이 아닌 칸만 출력하여 예외 방지
                            System.out.println((i + 1) + "번 - 학번: " + entries[i].studentId + ", 이름: " + entries[i].name);
                            hasEntry = true;
                        }
                    }
                    if (!hasEntry) {
                        System.out.println("등록된 신청자가 없습니다.");
                    }
                    break;

                case "3":
                    System.out.print("취소할 학번: ");
                    String cancelId = scanner.nextLine().trim();
                    // TODO 6. 학번을 찾아 해당 칸에 null을 넣으세요.
                    // 없는 학번이라면 그 사실을 알려 주세요.
                    int cancelIndex = -1;
                    for(int i=0; i<entries.length; i++){
                        if(entries[i] != null && entries[i].studentId.equals(cancelId)){
                            cancelIndex = i;
                            break;
                        }
                    }
                    if(cancelIndex==-1){
                        System.out.println("해당 학번의 신청이 없습니다.");
                    }else {
                        String canceledName = entries[cancelIndex].name;
                        entries[cancelIndex] = null;
                        System.out.println(canceledName + "학생이 취소함.");
                    }
                    break;

                case "4":
                    // TODO 7. null이 아닌 칸을 세어 현재 인원과 남은 자리를 출력하세요.
                    int currentCount = 0;
                    for (int i = 0; i < entries.length; i++) {
                        if (entries[i] != null) {
                            currentCount++;
                        }
                    }

                    int remainingSpots = entries.length - currentCount;

                    System.out.println("\n[신청 현황]");
                    System.out.println("현재 신청 인원: " + currentCount + "명");
                    System.out.println("남은 가능 자리: " + remainingSpots + "명 (전체 " + entries.length + "명)");
                    break;

                default:
                    System.out.println("0부터 4까지 선택하세요.");
            }
        }
    }
}
