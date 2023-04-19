import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Student {

    String firstName;
    String latName;
    String faculty;
    int birthDate;
    int admissionYear;
    int IDNP;

    public Student(){
        firstName = null;
        latName = null;
        faculty = null;
        birthDate = 0;
        admissionYear = 0;
        IDNP = 0;
    }

    public Student(String firstName, String latName, String faculty, int birthDate, int admissionYear, int IDNP) {
        this.firstName = firstName;
        this.latName = latName;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.admissionYear = admissionYear;
        this.IDNP = IDNP;
    }

    public Student(Student stud){
        this.firstName = stud.firstName;
        this.latName = stud.latName;
        this.faculty = stud.faculty;
        this.birthDate = stud.birthDate;
        this.admissionYear = stud.admissionYear;
        this.IDNP = stud.IDNP;
    }

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

    //AutoCreated Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthDate == student.birthDate && admissionYear == student.admissionYear && IDNP == student.IDNP && firstName.equals(student.firstName) && latName.equals(student.latName) && faculty.equals(student.faculty);
    }

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
