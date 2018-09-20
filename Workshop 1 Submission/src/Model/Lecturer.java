package Model;

public class Lecturer {
	
	private int id;
	private String LID;
	public String username;
	private String Name;
	private String Password;
	public String Email;
	private String Questions;
	private String Answer;
	private String Position;
	private String Telephone;
	public byte[] person_image;
	public String Status;
	public String Kohout;
	
	
	
	
	
	public String getKohout() {
		return Kohout;
	}
	public void setKohout(String kohout) {
		Kohout = kohout;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getPerson_image() {
		return person_image;
	}
	public void setPerson_image(byte[] person_image) {
		this.person_image = person_image;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLID() {
		return LID;
	}
	public void setLID(String lID) {
		LID = lID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
