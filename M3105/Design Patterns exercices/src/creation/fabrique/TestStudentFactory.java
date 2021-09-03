package creation.fabrique;

public class TestStudentFactory {

	public static void main(String[] args) {

		StudentFactory factory = new DumbStudentFactory(); // or the other Smart one

		Student aStudent = factory.createStudent();

		aStudent.giveOOskill();
	}

}
