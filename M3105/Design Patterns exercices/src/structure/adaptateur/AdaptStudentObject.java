package structure.adaptateur;

public class AdaptStudentObject implements IEtudiant  {

	private Student student;
	
	public AdaptStudentObject(Student s) {
		super();
		student = s;
	}
	
	public void setStudent(Student s) {
		student = s;
	}
	
	public void etudie() {
		student.study();
	}
}
