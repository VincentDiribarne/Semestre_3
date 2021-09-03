package creation.prototype;

public class Employee implements Cloneable {

	private int empoyeeId;
	private String employeeName;
	private Department department;

	public Employee(int id, String name, Department dept) {
		this.empoyeeId = id;
		this.employeeName = name;
		this.department = dept;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getEmpoyeeId() {
		return empoyeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	// Accessor/mutators methods will go there

}

class Department {
	private int id;
	private String name;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	// Accessor/mutators methods will go there

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}