package assignment2;
//Erjon Musa 20296816

public class Student extends Person{
	
	private String degree;
	private Date expectedGrad;
	private String school;
	
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degreeIn) {
		degree = degreeIn;
	}
	
	public Date getGradDate() {
		Date newDate = new Date(expectedGrad);
		return newDate;
	}
	
	public void setGradDate(Date dateIn) {
		expectedGrad = dateIn;
	}
	
	public void setSchool(String schoolIn) {
		school = schoolIn;
	}
	
	public String getSchool() {
		return school;
	}
	
	//overriding entityType in Person class
	public String entityType() {
		return "this entity is a Student";
	}
	public Student(){
		super();
		degree = "";
		expectedGrad = new Date();
		school = "";
	}
	
	public Student (String nameIn, Date bornIn, double difficultyIn, String genderIn, String degreeIn, Date expectedGradIn, String schoolIn) {
		super(nameIn, bornIn, difficultyIn, genderIn);
		degree = degreeIn;
		expectedGrad = expectedGradIn;
		school = schoolIn;
	}
	//copy constructor
	public Student(Student studentIn) {
		super(studentIn);
		degree = studentIn.getDegree();
		expectedGrad = studentIn.getGradDate();
		school = studentIn.getSchool();
	}
	
	public String toString() {
		return super.toString() + "\nDegree: " + degree + "\nExpected Graduation Date: " + expectedGrad.toString() + "\nSchool: " + school; 
	}
	
	//clone method implementing copy constructor
	public Student clone() {
		return new Student(this);
	}
}