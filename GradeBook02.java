package day0316;

// 캡슐화가 적용된 Student 클래스를 사용하여

// 학생 5명 관리하고
// 만약 똑같은 이름과 번호를 가진 학생은 또다시 입력할 수 없는
// 성적관리 프로그램을 작성하시오 (12시 20분까지)

import day0316.Student;
import util.ArrayUtil;
import util.ScannerUtil;
import java.util.Scanner;

public class GradeBook02 {
    final static int SIZE_STUDENT = 5;
    final static int SCORE_MIN = 0;
    final static int SCORE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] array = new Student[0];

        while (true) {
            String message = new String("1. 입력 2. 출력 3. 종료");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                if (ArrayUtil.size(array) < SIZE_STUDENT) {
                    Student s = new Student();
                    // 번호 입력
                    message = new String("번호를 입력해주세요.");
                    s.setId(ScannerUtil.nextInt(scanner, message));
                    // 이름 입력
                    message = new String("이름을 입력해주세요.");
                    s.setName(ScannerUtil.nextLine(scanner, message));
                    
                    // 중복 시 다시 입력
                    while (ArrayUtil.contains(array, s)) {
                       System.out.println("이미 존재하는 학생입니다.");
                       message = new String("번호를 입력해주세요.");
                       s.setId(ScannerUtil.nextInt(scanner, message));
                       message = new String("이름을 입력해주세요.");
                       s.setName(ScannerUtil.nextLine(scanner, message));
                       
                    }
                    // 국어 점수 입력
                    message = new String("국어 점수를 입력해주세요.");
                    s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
                    // 영어 점수 입력
                    message = new String("영어 점수를 입력해주세요.");
                    s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
                    // 수학 점수 입력
                    message = new String("수학 점수를 입력해주세요.");
                    s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

                    array = ArrayUtil.add(array, s);
                } else {
                    System.out.println("더이상 입력하실 수 없습니다.");
                }

            } else if (userChoice == 2) {
                if (ArrayUtil.size(array) == 0) {
                    System.out.println("아직 입력된 학생 정보가 존재하지 않습니다.");
                } else {
                    for (int i = 0; i < ArrayUtil.size(array); i++) {

                        System.out.println();
                        System.out.println("============================");
                        array[i].showInfo();
                        System.out.println("============================");
                    }
                    System.out.println();
                }

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        scanner.close();
    }
}
