package student;

public class Group {
    private Student[] all;
    private int numStud;
    
    public Group(int amount) {
        this.all     = new Student[amount];
        this.numStud = 0;
    }

    public void addStudent(Student student) {
        this.all[numStud] = student;
        numStud++;
    }

    public void changeStudentName(int numStud, String fName, String lName) {
        for (Student student : this.all) {
            if (student.getStNumber() == numStud) {
                student.changeName(fName, lName);
                break;
            }
        }
    }

    public String asString() {
        String string = "";
        for (Student student : this.all) {
            string += student.getFirstName() + " "
                    + student.getLastName()  + ", "
                    + "s" + student.getStNumber() + "\n";
        }
        return string;
    }
}
