import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * <h2>Class Student</h2>
 * <p></p>
 * The Student program implements an application that
 * simply adds data about students.
 *
 * @see Student#toString() 
 * @see Student#equals(Object)
 * @see Student#createStudentFromString(String) 
 * @see Student#input(File)
 * @version 1.0
 * @author EgorBusuioc
 */
public class Student {

    String firstName;
    String latName;
    String faculty;
    int birthDate;
    int admissionYear;
    int IDNP;

    /**
     * <h3>Constructor without parameters.</h3>
     */
    public Student(){
        firstName = null;
        latName = null;
        faculty = null;
        birthDate = 0;
        admissionYear = 0;
        IDNP = 0;
    }

    /**
     * <h3>Constructor with parameters</h3>
     * <p></p>
     * @param firstName First Name
     * @param latName Last Name
     * @param faculty Faculty
     * @param birthDate  Birth Date
     * @param admissionYear Admission year
     * @param IDNP IDNP
     */
    public Student(String firstName, String latName, String faculty, int birthDate, int admissionYear, int IDNP) {
        this.firstName = firstName;
        this.latName = latName;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.admissionYear = admissionYear;
        this.IDNP = IDNP;
    }

    /**
     * <h3>Copy constructor</h3>
     * <p></p>
     * @param stud Object 
     */
    public Student(Student stud){
        this.firstName = stud.firstName;
        this.latName = stud.latName;
        this.faculty = stud.faculty;
        this.birthDate = stud.birthDate;
        this.admissionYear = stud.admissionYear;
        this.IDNP = stud.IDNP;
    }

    /**
     * <h3>Method toString</h3>
     * <p></p>
     * @return Readable string with parameters Student's class.
     */
    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' +
                ", latName='" + latName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", birthDate=" + birthDate +
                ", admissionYear=" + admissionYear +
                ", IDNP=" + IDNP +
                '}';
    }

    public Student copy(Student stud){

        return new Student(stud);
    }

    /**
     * <h3>AutoCreated method Equals</h3>
     * <p></p>
     * @param o Object
     * @return True or False.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthDate == student.birthDate && admissionYear == student.admissionYear && IDNP == student.IDNP && firstName.equals(student.firstName) && latName.equals(student.latName) && faculty.equals(student.faculty);
    }

    /**
     * <h3>Method createStudentFromString</h3>
     * <p></p>
     * This method reads strings from "MOCK_DATA.csv" and
     * adds parameters to class Student.
     *
     * @param string - String from file
     * @return Object Student.
     */
    public static Student createStudentFromString(String string){
        Student student;
        String[] stringArray = string.split(",");
        int IDNP = Integer.parseInt(stringArray[0]);
        String firstName = stringArray[1];
        String lastName = stringArray[2];
        String faculty = stringArray[3];
        int birthDate = Integer.parseInt(stringArray[4]);
        int admissionYear = Integer.parseInt(stringArray[5]);

        return student = new Student(firstName, lastName, faculty, birthDate, admissionYear, IDNP);
    }

    /**
     * <h3>Input to ArrayList Method</h3>
     * <p></p>
     * This method reads data from a file and writes it to an ArrayList
     *
     * @param resource MOCK_DATA.csv
     * @return StudentList
     */
    public static ArrayList<Student> input(File resource){
        ArrayList<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resource))) {
            String st;
            while ((st = br.readLine()) != null) {
                if (st.isEmpty()) {
                } else {
                    studentList.add(createStudentFromString(st));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
