import java.io.File;
import java.util.ArrayList;

/**
 * <h2>Class Main</h2>
 * The Main program implements an application that
 * simply displays data from a "MOCK_DATA.csv" file to the standard output.
 *
 * @see Student
 * @version 1.0
 * @author EgorBusuioc
 */
public class Main {
    public static void main(String[] args) {

        File file = new File(".\\src\\MOCK_DATA.csv");
        ArrayList<Student> arrayList = Student.input(file);
        for(Student s : arrayList){
            System.out.println(s);
        }
    }
}