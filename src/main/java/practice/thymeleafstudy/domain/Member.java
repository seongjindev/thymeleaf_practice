package practice.thymeleafstudy.domain;

public class Member {

    private int number;
    private String name;
    private String contents;

    public Member() {
    }

    public Member(int number, String name, String contents) {
        this.number = number;
        this.name = name;
        this.contents = contents;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
