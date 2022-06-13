package java2.LabGroup2.part2.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class entryMap {
    private HashMap<Integer,Student> list = new HashMap();
    public entryMap(){
//        list.put(1,new Student(1,"minh thanh",19,10));
//        list.put(2,new Student(2,"minh thanh",19,9));
//        list.put(3,new Student(3,"minh thanh",19,10));
//        list.put(4,new Student(4,"minh thanh",19,8));
    }

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
        Scanner sc = new Scanner(System.in);
        System.out.println("NHập key :");
        int key = sc.nextInt();
        list.put(key,a);
    }
    public void loadFile() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("student13062022.json");
        list = gson.fromJson(reader,new TypeToken<Map<Integer,Student>>(){}.getType());
        reader.close();
    }
    public void saveFile() throws IOException{
        Gson gson = new Gson();
        FileWriter writer = new FileWriter("student13062022.json");
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
        System.out.println(list.get(id));
    }
    public void displayStudent(){
        System.out.println("=====================");
        list.forEach((key,value) -> System.out.println("key = "+ key + "value = "+ value));
        System.out.println("=====================");
    }
    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        displayStudent();
        System.out.println("nhập vị trí cần xóa");
        try {
            int vitri = sc.nextInt();
            list.forEach((key, value) -> {
                if (vitri == key) {
                    list.remove(key);
                }
            });
        }catch (Exception a){
            System.out.println(a.getMessage() + "Đã xóa");
        }
    }
    public void updateStudent(){
        Scanner sc = new Scanner(System.in);
        String namefirst;
        String namelast;
        int age;
        int mark;
        System.out.println("Nhập Student có key :");
        int key = sc.nextInt();
        System.out.println("Thông tin ban đầu :");
        list.get(key);
        System.out.println("Nhập id cần đổi:");
        int rollid = sc.nextInt();
        System.out.println("Nhập first name:");
        namefirst = sc.next();
        System.out.println("Nhập last name:");
        namelast = sc.next();
        System.out.println("Nhập tuổi cần đổi:");
        age = sc.nextInt();
        System.out.println("Nhập điểm cần đổi:");
        mark = sc.nextInt();
        String name = namefirst + " " + namelast;
        list.put(key,new Student(rollid,name,age,mark));
    }
    public static void main(String[] args) throws IOException {
        entryMap entryList = new entryMap();
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
