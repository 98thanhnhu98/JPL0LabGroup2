package java2.LabGroup2.part2.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class entryLinkedList {
    private List<Student> list = new LinkedList<>();


    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID :");
        int id = sc.nextInt();
        System.out.println("Nhập first name :");
        String firstname = sc.next();
        System.out.println("Nhập Last name : ");
        String lastname = sc.next();
        String name = firstname + " " + lastname;
        System.out.println("Nhập tuổi của bạn :");
        int age = sc.nextInt();
        System.out.println("Nhập điểm của bạn :");
        int mark = sc.nextInt();
        Student e = new Student(id,name,age,mark);
        add(e);
    }
    public void add(Student a){
        list.add(a);
    }
    public void loadFile() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("student13062023.json");
        list = gson.fromJson(reader,new TypeToken<List<Student>>(){}.getType());
        reader.close();
    }
    public void saveFile() throws IOException{
        Gson gson = new Gson();
        FileWriter writer = new FileWriter("student13062023.json");
        gson.toJson(list,writer);
        writer.close();
    }
    public void menu (){
        System.out.println("1. Add Student");
        System.out.println("2. Update a Student");
        System.out.println("3. Delete a Student");
        System.out.println("4. Search a Student");
        System.out.println("5. Display All Student");
        System.out.println("6. Save to File");
        System.out.println("7. Load form File");
        System.out.println("8. Exit");
        System.out.println("Your choice :");
    }
    public void findStudent(){
        Scanner sc = new Scanner(System.in);
        displayStudent();
        System.out.println("Nhập id cần tìm");
        int id = sc.nextInt();
        for (Student a : list){
            if (a.getRollNumber() == id) {
                System.out.println(a);
            }
        }
    }
    public void displayStudent(){
//        Collections.sort(list);
        System.out.println("=====================");
        for (Student a : list){
            System.out.println(a);
        }
        System.out.println("=====================");
    }
    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        displayStudent();
        System.out.println("nhập vị trí cần xóa");
        int vitri = sc.nextInt();
        list.remove(vitri);
    }
    public void updateStudent(){
        Scanner sc = new Scanner(System.in);
        String namefirst;
        String namelast;
        String name;
        int age;
        int mark;
        System.out.println("1. đổi name\n2. đổi age\n3. đổi mark");
        int chon = sc.nextInt();
        switch (chon){
            case 1:
                System.out.println("Nhập Student có id :");
                int id = sc.nextInt();
                for (Student a : list) {
                    if (a.getRollNumber() == id) {
                        System.out.println("Student ID:" + id);
                        System.out.println("Name : " + a.getName());
                        System.out.println("Nhập tên mới");
                        System.out.println("First name:");
                        namefirst = sc.next();
                        System.out.println("Last name:");
                        namelast = sc.next();
                        name = namefirst + " " + namelast;
                        a.setName(name);
                    }
                }
                break;
            case 2:
                System.out.println("Nhập Student có id :");
                int id1 = sc.nextInt();
                for (Student a : list) {
                    if (a.getRollNumber() == id1) {
                        System.out.println("Student ID:" + id1);
                        System.out.println("Age : " + a.getAge());
                        System.out.println("Nhập tuổi mới");
                        age = sc.nextInt();
                        a.setAge(age);
                    }
                }
                break;
            case 3:
                System.out.println("Nhập Student có id :");
                int id2 = sc.nextInt();
                for (Student a : list) {
                    if (a.getRollNumber() == id2) {
                        System.out.println("Student ID:" + id2);
                        System.out.println("Mark : " + a.getMark());
                        System.out.println("Nhập tuổi mới");
                        mark = sc.nextInt();
                        a.setMark(mark);
                    }
                }
                break;
            default:
                System.out.println("Nothing happen??");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        entryLinkedList entryList = new entryLinkedList();
        Scanner sc = new Scanner(System.in);
        entryList.menu();
        while (true){
            int chon = sc.nextInt();
            switch (chon){
                case 1:
                    entryList.addStudent();
                    entryList.menu();
                    break;
                case 2:
                    entryList.updateStudent();
                    entryList.menu();
                    break;
                case 3:
                    entryList.deleteStudent();
                    entryList.menu();
                    break;
                case 4:
                    entryList.findStudent();
                    entryList.menu();
                    break;
                case 5:
                    entryList.displayStudent();
                    entryList.menu();
                    break;
                case 6:
                    entryList.saveFile();
                    entryList.menu();
                    break;
                case 7:
                    entryList.loadFile();
                    entryList.menu();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not Happen!!");
                    break;
            }
        }
    }
}
