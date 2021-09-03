package structure.adaptateur;

public class TestEtudiant {

	public static void main(String[] args) {
		Student aStudent = new Student();
		
		IEtudiant unEtudiant = new AdaptStudentObject(aStudent);
		
		unEtudiant.etudie();
	}

}
