package creation.fabrique;

public interface StudentFactory {

	public Student createStudent();
}

class SmartStudentFactory implements StudentFactory {

	public Student createStudent() {
		return null;
	}
}

class DumbStudentFactory implements StudentFactory {

	public Student createStudent() {
		return null;
	}
}