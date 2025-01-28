package student;

public class Assignment01Tester {
	private Group group;
	public void createGroup(int i) {
		this.group = new Group(i);
	}
	public void addStudent(int sNumber, String firstName, String lastName) {
		this.group.addStudent(new Student (firstName , lastName, sNumber ));
	}

	public void changeStudent(int sNumber, String firstName, String lastName) {
		this.group.changeStudentName(sNumber,firstName,lastName);
	}

	public String printStudents() {
		return this.group.asString();
	}

}
