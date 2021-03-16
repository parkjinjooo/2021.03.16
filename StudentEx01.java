package day0316;

public class StudentEx01 {
    public static void main(String[] args) {
        Student s = new Student();
        //s.id = 1;
        s.setId(-1);
        //System.out.println("학생의 id: " + s.id);
        System.out.println("학생의 id: " + s.getId());
    }
}
