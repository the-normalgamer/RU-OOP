package student;

public class Student {
    private String firstName;
    private String lastName;
    private int stNumber;
    
    public Student (String fName, String lName, int sNum) {
        this.firstName = fName;
        this.lastName = lName;
        this.stNumber = sNum;
    }

    public void changeName(String fName, String lName) {
        this.firstName = fName;
        this.lastName  = lName;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getStNumber() {
        return this.stNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStNumber(int stNumber) {
        this.stNumber = stNumber;
    }
}
