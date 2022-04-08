import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private int id;
    private String name;
    private String gender;

    @JsonProperty("student_number")
    private int studentNumber;

    public Student() {
        id = -1;
        name = "";
        gender = "";
        studentNumber = -1;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getId() {
        return id;
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
}
