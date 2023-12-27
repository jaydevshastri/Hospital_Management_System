package hospital.bo;

public class hospital1_bo 
{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String dob;
	private String diseased;
	private String blood_group;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDiseased() {
		return diseased;
	}
	public void setDiseased(String diseased) 
	{
		this.diseased = diseased;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	
	}
	public hospital1_bo(String name, String email, String phone, String dob, String diseased, String blood_group) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.diseased = diseased;
		this.blood_group = blood_group;
	
	}
	public hospital1_bo() 
	{

	}
	public String toString() 
	{
		return "hospital1_bo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob + ", diseased=" + diseased + ", blood_group=" + blood_group+"]";
	}
	
	
	
	
	
	

}
