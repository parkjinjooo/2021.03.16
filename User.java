package day0316;
// 게시판 관리 프로그램에서 사용될 사용자 클래스

// 필드: 회원번호 id, 회원 userName, 회원 passWord, 회원 닉네임
// 메소드: 겟터/셋터, id와 userName을 기준으로한 equals(), id와 비밀번호가 맞으면 true가 나오는 로그인

public class User {
    private int id;
    private String userName;
    private String password;
    private String nickName;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return nickName;
    }

    public boolean equals(Object o) {
        if (o instanceof User) {
            User u = (User) o;
            if (id == u.id && userName.equals(u.userName)) {
                return true;
            }
        }

        return false;

    }

    public boolean logIn(int id, String password) {
        if (this.id == id && this.password.equals(password)) {

            return true;

        }

        return false;
    }
}
