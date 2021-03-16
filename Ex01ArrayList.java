package day0316;
// 배열의 단점은, 크기가 고정되어있기 때문에

// 우리가 동적할당을 하더라도
// 매번 ArrayUtil에 우리가 만드는 클래스를 기준으로 해서
// 모든 메소드들을 처음부터 다시 만들어주어야 한다! -> 매우 귀찮고 불편함

// 그래서 자바에는 기본적으로 여러 개의 같은 클래스 객체들을 다룰 수 있게
// Collection 이라는 인터페이스(클래스의 규범)을 만들어놓고
// 그 Collection 인터페이스를 상속받아서
// 특정 메소드들이 모두 준비되어있는 클래스들이 존재한다. 

// 인터페이스란?
// 인터페이스란, 설계도를 위한 일종의 약속 규범이라고 보면 좋다.
// 인터페이스는 클래스와 다르게 우리가 어떤 메소드가 필요한지를 "선언" 만 한다.
// 그리고 해당 메소드가 어떻게 구현될지는 그 인터페이스를 상속받는 클래스가 
// 독자적으로 구현하게 된다. 
// 인터페이스를 사용하는 이유는 바로 다형성을 위해서이다.
// 파라미터 혹은 리턴 타입에 인터페이스를 적어주고, 실제 리턴되거나 파라미터로 들어올 때는
// 그 인터페이스를 상속받는 클래스면 뭐든 들어올 수 있기 때문이다. 

// Collection은 각각 아래와 같이 나뉜다.
// 1. List
//    리스트는 중복 입력이 가능하고 기본적으로 동적 할당이 구현된 배열이라고 생각하면 편하다. 
// 2. Set
//    셋은 중복 입력이 불가능한 동적 할당이 구현된 배열이라고 생각하면 편하다. 
// 3. Map
//    맵은 배열과는 다르게 순서가 존재하지 않고, 대신 우리가 key를 사용하여
//    우리가 저장할 객체를 꺼내오는 개념이다.
// 물론 리스트, 셋, 맵은 그 자체는 또다른 인터페이스이고, 그리고 그 인터페이스를 상속받는
// 실제 클래스들을 우리가 사용하게 된다.

// 우리가 이번 클래스에서 배울 콜렉션의 클래스는 바로
// List를 상속받는 클래스 중 하나인 ArrayList이다. 

import java.util.ArrayList;

public class Ex01ArrayList {
    public static void main(String[] args) {
        // 그간 우리가 ArrayUtil.java에 구현해놨던 모든 메소드들이
        // 모두 ArrayList가 독자적으로 가지고 있는 메소드들이다.

        // ArrayList 선언하기
        // ArrayList를 선언하는 방법은 다음과 같다.
        // ArrayList<클래스> 이름 = new ArrayList<>();
        // <> 는 자바에서 템플릿이라고 부른다.
        // 저 템플릿은 주로 콜렉션의 클래스들이 무엇을 모아둔 객체인지를 적어주게 되는데
        // 저 템플릿 안에는 무조건 클래스만 들어갈 수 있다.
        // Q1: 강사님, 그러면 템플릿 자리에 기본형 데이터타입은 들어갈 수 없나요?
        // A1: 네, 못들어갑니다.
        // Q2; 강사님, 그러면 템플릿 자리에 배열은 들어갈 수 없나요?
        // A2: 네, 못들어갑니다.
        // Q3: 강사님, 제가 정수를 모아둔 어레이리스트가 필요한데 그럼 못만드나요?
        // A3: 아니요, 만들 수 있습니다.
        // 자바에서는 기본적으로 클래스로 만들어놓은 기본형 데이터타입들이 있다.
        // 기본형 데이터타입을 클래스의 형태로 "포장" 해놓은 형태이기 때문에 우리가 "포장 클래스(Wrapper Class)" 라고도 부른다.
        // 대표적으로 int를 포장한 Integer클래스, double을 포장한 Double 클래스 등이 존재한다.
        // 따라서, 여러분들이 숙제로 해올
        // 로또게임의 ArrayList 버전 같은 경우, 저 <>에 Integer 라고 적어주면 된다!

        // Student 클래스의 어레이리스트를 만들어보자
        ArrayList<Student> list = new ArrayList<>();

        // 1. 현재 어레이리스트 객체의 크기를 알고 싶을땐
        // size()메소드를 실행하면 된다.
        System.out.println("1. size()");
        System.out.println("list.size(): " + list.size());
        System.out.println();

        // 이번 에제에서 사용할 Student 객체를 여러개 만들어보자
        Student s1 = new Student(1, "A1", 1, 1, 1);
        Student s11 = new Student(1, "A1", 1, 1, 1);
        Student s2 = new Student(2, "A2", 2, 2, 2);
        Student s22 = new Student(2, "A2", 2, 2, 2);
        Student s3 = new Student(3, "A3", 3, 3, 3);
        Student s33 = new Student(3, "A3", 3, 3, 3);

        // 2. 어레이리스트에 새로운 객체를 추가할 때에는
        // add(객체) 메소드를 실행하면 된다.
        System.out.println("2. add(e)");
        System.out.println("list.size(): " + list.size());
        list.add(s1);
        System.out.println("list.size(): " + list.size());
        list.add(s2);
        System.out.println("list.size(): " + list.size());
        System.out.println();

        // 3. 리스트에 존재하는 객체를 꺼내올 때에는
        // get(index) 메소드를 실행하면 된다.
        // 당연히 index는 0부터 크기-1 까지이다.
        System.out.println("3. get(index)");
        System.out.println("list.get(0).showInfo(): ");
        list.get(0).showInfo();
        System.out.println();

        // 4. 리스트에 특정 인덱스에 새로운 객체를 추가할 때에는
        // add(index, e) 메소드를 실행하면 된다.
        // 당연히 잘못된 index에는 추가할 수 없다.
        System.out.println("4. add(index, e)");
        System.out.println("list.get(0).getName(): " + list.get(0).getName());
        list.add(0, s3);
        System.out.println("list.get(0).getName(): " + list.get(0).getName());
        System.out.println();

        // 5. 리스트의 특정 인덱스에 있는 객체를 제거할 때에는
        // remove(index) 메소드를 실행하면 된다.
        // 당연히 잘못된 index는 제거할 수 없다.
        System.out.println("5. remove(index)");
        System.out.println("list.get(1).getName(): " + list.get(1).getName());
        list.remove(1);
        System.out.println("list.get(1).getName(): " + list.get(1).getName());
        System.out.println();

        // 6. 인덱스의 특정 인덱스에 있는 객체를 바꿀 떄에는
        // set(index, e)를 실행하면 된다.
        // 이 메소드의 결과값은 void가 아니라
        // 해당 index에 원래 있던 객체가 결과값이 된다!

        System.out.println("6. set(index, e)");
        System.out.println("list.get(0).getName(): " + list.get(0).getName());
        Student temp = list.set(0, s1);
        System.out.println("list.get(0).getName(): " + list.get(0).getName());
        list.set(0, temp);
        System.out.println("list.get(0).getName(): " + list.get(0).getName());
        System.out.println();

        // 여기서부터는 template에 들어가는 클래스 안에
        // equals() 메소드가 정확하게 구현되어있어야
        // 정상적으로 실행이 되는 메소드이다.

        // 7. 리스트 안에 특정 객체가 존재하는지 확인하고 싶을 때는
        // contains(e) 메소드를 실행하면 된다.
        // 이때에는 완전히 동일한 객체 뿐만이 아니라
        // equals()가 true가 나오는 객체를 넣어줘도 된다.
        
        System.out.println("7. contains(e)");
        System.out.println("A. 동일 객체를 사용하는 경우");
        System.out.println("list.contains(s2): " + list.contains(s2));
        System.out.println("list.contains(s1): " + list.contains(s1));
        System.out.println("B. equals()가 true가 나오는 객체를 사용하는 경우");
        System.out.println("list.contains(s22): " + list.contains(s22));
        System.out.println("list.contains(s11): " + list.contains(s11));
        System.out.println();

        // 8. 리스트 안에 특정 객체의 가장 먼저 등장하는 인덱스가 궁금할 때에는
        // indexOf(e) 메소드를 실행하면 된다.
        // comtain(e)와 마찬가지로, 원본 객체를 넣어줄 필요는 없지만
        // 만약 해당 객체와 equals()가 true가 나오는 객체가 존재하지 않는다면
        // 결과값은 -1이 나온다.
        System.out.println("8. indexOf(e)");
        System.out.println("A. 동일 객체를 사용하는 경우");
        System.out.println("list.contains(s3): " + list.indexOf(s3));
        System.out.println("list.contains(s1): " + list.indexOf(s1));
        System.out.println("B. equals()가 true가 나오는 객체를 사용하는 경우");
        System.out.println("list.contains(s33): " + list.indexOf(s33));
        System.out.println("list.contains(s11): " + list.indexOf(s11));
        System.out.println();

        // 9. 리스트 안에 득정 객체의 가장 마지막으로 등장하는 인덱스가 궁금할 때에는
        // lastIndexOf(e) 메소드를 실행하면 된다.
        System.out.println("9. lastIndexOf(e)");
        list.add(s3);
        System.out.println("list.indexOf(s3): " + list.indexOf(s3));
        System.out.println("list.lastIndexOf(s3): " + list.lastIndexOf(s3));
        System.out.println();

        // 10. 리스트 안에 특정 객체를 삭제할 때에는
        // remove(e) 메소드를 실행하면 된다.
        // 만약 해당 객체와 equals(true)가 나오는 객체가 없을 때에는 아무것도 삭제되지 않는다.
        // 다른 객체이지만 equals(true)사 나오는 객체는 삭제가 된다.
        System.out.println("10. remove(e)");
        System.out.println("A. 해당 객체를 사용하는 경우");
        System.out.println("list.indexOf(s3): " + list.indexOf(s3));
        list.remove(s3);
        System.out.println("list.indexOf(s3): " + list.indexOf(s3));
        list.remove(s33);
        System.out.println("list.indexOf(s3): " + list.indexOf(s3));
        System.out.println("B. 해당 객체가 존재하지 않는 경우");
        System.out.println("list.size(): " + list.size());
        list.remove(s1);
        System.out.println("list.size(): " + list.size());
        System.out.println();

    }
}
