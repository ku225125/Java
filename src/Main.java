import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        try {
            int count = Integer.parseInt(input);
            System.out.println("프로젝트: " + count);
        } catch (NumberFormatException e) {
            System.out.println("정수로 입력해 주세요.");
        }
    }
}