package day0316;
// 캡슐화

// 객체지향 프로그래밍에서는
// 우리가 만든 클래스의 세부적 내용을
// 굳이 바깥에서 알 필요없다고 보고
// 따라서 우리 클래스 안에 
// 모든 필드 그리고 바깥이 몰라도 되는 메소드의 경우
// 아예 볼 수 없게 
// 접근제한을 하게 된다.
// 하지만 우리가 필드에 접근제한자를 사용하게 된다면?
// 외부 클래스에서 객체를 생성하더라도
// 필드에 값을 직접 넣어줄 수 없게 된다!

// 대신 우리가 메소드를 만들어서, 해당 메소드를 사용하여
// 간접적으로 값을 넣어주거나 아니면 호출하게 된다. 

// private으로 설정된 필드에 값을 넣을 때에는
// 우리가 setter 메소드를 사용하게 된다. 
// setter 메소드는 다음과 같은 형식을 가진다.
// public void set 필드명(필드타입 필드명){
//   this.필드명 = 필드명;
// }

// private으로 설정된 필드에서 값을 호출할 때에는
// 우리가 getter 메소드를 사용하게 된다. 
// getter 메소드는 다음과 같은 형식을 가진다. 
// public 필드타입 get필드명(){
// return 필드명;
// }

// Student 클래스 ver 2.0
// 캡슐화의 개념이 적용된 Student 클래스

public class Student {

    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;
    private final int SIZE = 3;

    // id에 대한 getter/setter
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    // name 에 대한 getter/setter
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // korean 에 대한 getter/setter
    
    public void setKorean(int korean) {
        this.korean = korean;
    }
    
    public int getKorean() {
        return korean;
    }
    
    // english 에 대한 getter/setter 
    
    public void setEnglish(int english) {
        this.english = english;
    }
    
    public int getEnglish() {
        return english;
    }
    
    // math 에 대한 getter/setter
    
    public void setMath(int math) {
        this.math = math;
    }
    
    public int getMath() {
        return math;
    }
    
    private int calculateSum() {
        return korean + english + math;
    }
    
    
    
    
    

    private double calculateAverage() {
        return calculateSum() / (double) SIZE;
    }

    public void showInfo() {
        System.out.printf("번호: %02d 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균 %06.2f점\n", calculateSum(), calculateAverage());

    }

    public Student(int id, String name, int korean, int english, int math) {
        this.id = id;
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;

    }

    public Student() {
        id = -1;
        name = new String("아직 입력 안됨");
        korean = -1;
        english = -1;
        math = -1;
    }

    public boolean equals(Object o) {
        if (o instanceof Student) {

            Student s = (Student) o;

            if (id == s.id && name.equals(name)) {
                return true;
            }
        }

        return false;
    }

}
