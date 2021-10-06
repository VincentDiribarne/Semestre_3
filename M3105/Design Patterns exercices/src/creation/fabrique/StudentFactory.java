package creation.fabrique;

public interface StudentFactory {
	Student createStudent();
}

class SmartStudentFactory implements StudentFactory {
	public Student createStudent() {
		return new SmartStudent();
	}
}

class DumbStudentFactory implements StudentFactory {
	public Student createStudent() {
		return new DumbStudent();
	}
}