package java2.LabGroup2.part2.Set;

public class Student {
    public Student(){};
    private int RollNumber;
    private String name;
    private int Age;
    private int Mark;

    public Student(int rollNumber , String name , int age , int mark){
        this.RollNumber = rollNumber;
        this.name = name;
        this.Age = age;
        this.Mark = mark;
    }
    public int getRollNumber() {
        return RollNumber;
    }

    public String getName() {
        return name;
    }

    public void setRollNumber(int rollNumber) {
        RollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setMark(int mark) {
        Mark = mark;
    }

    public int getAge() {
        return Age;
    }

    public int getMark() {
        return Mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "RollNumber=" + RollNumber +
                ", name='" + name + '\'' +
                ", Age=" + Age +
                ", Mark=" + Mark +
                '}';
    }
}
