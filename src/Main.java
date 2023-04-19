import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        File file = new File(".\\src\\MOCK_DATA.csv");
        ArrayList<Student> arrayList = Student.input(file);
        for(Student s : arrayList){
            System.out.println(s);
        }
    }
}