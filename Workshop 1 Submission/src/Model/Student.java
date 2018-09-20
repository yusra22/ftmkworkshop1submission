package Model;

public class Student {
	
	private int id;
	private String SID;
	private String Name;
	private String Username;
	private String Password;
	private String Email;
	private String Course;
	private String Telephone;
	public byte[] person_image;
	private String Questions;
	private String Answer;
	private String LID;
	public String Kohout;
	
	
	
	

	
	public String getKohout() {
		return Kohout;
	}
	public void setKohout(String kohout) {
		Kohout = kohout;
	}
	public String getLID() {
		return LID;
	}
	public void setLID(String lID) {
		LID = lID;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public byte[] getPerson_image() {
		return person_image;
	}
	public void setPerson_image(byte[] person_image) {
		this.person_image = person_image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getQuestions() {
		return Questions;
	}
	public void setQuestions(String questions) {
		Questions = questions;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	
	

}
