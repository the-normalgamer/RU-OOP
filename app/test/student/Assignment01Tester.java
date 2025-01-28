package student;

public class Assignment01Tester {
	private Group group;
	public void createGroup(int i) {
		this.group = new Group(i);
	}
	public void addStudent(int sNumber, String firstName, String lastName) {
		this.group.addToGroup(new Student (firstName , lastName, sNumber ));
	}

	public void changeStudent(int sNumber, String firstName, String lastName) {
		this.group.changeStudent(new Student(firstName,lastName,sNumber));
	}

	public String printStudents() {
		return this.group;
	}

}
