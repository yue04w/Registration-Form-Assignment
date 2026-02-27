package model;


public class Registration {
	
	private String userName;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private String email;
//	private String captcha;
	
	//Primary Constructor
	public Registration() {}
	
	//Constructor
	public Registration(String userName, String password, String confirmPassword, String phoneNum, String email,
			String captcha) {
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phoneNumber = phoneNum;
		this.email = email;
//		this.captcha = captcha; 
	}
	
	// Getter and Setter 
	
	//Username 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//Primary Password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Confirm Password
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	//Phone Number 
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Captcha
//	public String getCaptcha() {
//		return captcha;
//	}
//	public void setCaptcha(String captcha) {
//		this.captcha = captcha;
//	}
//	

}
