import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private int id;
    private String name;
    private String gender;

    @JsonProperty("student_number")
    private int studentNumber;

    public Student() {
        id = -1;
        name = "-1";
        gender = "-1";
        studentNumber = -1;
    }

    public Student(int id, String name, String gender, int studentNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.studentNumber = studentNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getId() {
        return id;
    }
    public String getStringId() {
        return String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    public String getStringStudentNumber() {
        return String.valueOf(studentNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
