package day0316;

import util.ScannerUtil;
import java.util.Scanner;
import util.ArrayUtil;
import day0315.Student;

// 사용자로부터 학생의 정보를 입력 받아서 
// 관리하는 프로그램
// 단, 5명을 초과해서 관리할 수 없고
// 입력시에, 만약 이미 존재하는 학생이면 다시 번호와 이름을 입력 받는다.
// (10시 20분까지)
public class GradeBook01 {
    final static int SIZE_STUDENT = 5;
    final static int SCORE_MIN = 0;
    final static int SCORE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] arr = new Student[0];

        while (true) {
            String message = new String("1. 입력 2. 출력 3. 종료");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                if (ArrayUtil.size(arr) < SIZE_STUDENT) {
                    Student s = new Student();
                    message = new String("번호를 입력해주세요.");
                    s.id = ScannerUtil.nextInt(scanner, message);
                    message = new String("이름을 입력해주세요.");
                    s.name = ScannerUtil.nextLine(scanner, message);

                    while (ArrayUtil.contains(arr, s)) {
                        System.out.println("이미 존재하는 학생입니다.");
                        System.out.println("번호와 이름이 다른 학생을 입력해 주세요.");
                        message = new String("번호를 입력해주세요.");
                        s.id = ScannerUtil.nextInt(scanner, message);
                        message = new String("이름을 입력해주세요.");
                        s.name = ScannerUtil.nextLine(scanner, message);
                    }

                    message = new String("국어 점수를 입력해주세요.");
                    s.korean = ScannerUtil.nextInt(scanner, message, 0, 100);
                    message = new String("영어 점수를 입력해주세요.");
                    s.english = ScannerUtil.nextInt(scanner, message, 0, 100);
                    message = new String("수학 점수를 입력해주세요.");
                    s.math = ScannerUtil.nextInt(scanner, message, 0, 100);

                    arr = ArrayUtil.add(arr, s);
                } else {
                    System.out.println("더이상 입력하실 수 없습니다!");
                }

            } else if (userChoice == 2) {
                if (ArrayUtil.size(arr) == 0) {
                    System.out.println("아직 입력된 학생 정보가 존재하지 않습니다.");

                } else {
                    for (int i = 0; i < ArrayUtil.size(arr); i++) {
                        System.out.println();
                        System.out.println("===================================");
                        arr[i].showInfo();
                        System.out.println("====================================");
                        System.out.println();
                    }
                }
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }

        }
        scanner.close();
    }
}
