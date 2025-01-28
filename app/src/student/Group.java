package student;

public class Group {
    private Student[] all;
    private int numStud;
    
    public Group(int amount) {
        all = new Student[amount];
        numStud = 0;
    }

    public void addStudent (Student name, int place) {
        this.all[place] = name;
    }
}
