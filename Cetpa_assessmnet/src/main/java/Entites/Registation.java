package Entites;
import javax.persistence.*;


@Entity
@Table(name = "registration")
public class Registation {

	@Id
	private long Emp_id;
	private String Emp_name;
	private String Emp_email;
	private String Emp_address;
	private String Emp_profile;
	private String Emp_password;
	public long getEmp_id() {
		return Emp_id;
	}
	public void setEmp_id(long emp_id) {
		Emp_id = emp_id;
	}
	public Registation()
	{
		
	}
	public Registation(long Emp_id, String Emp_name, String Emp_email, String Emp_addres, String Emp_profile, String Emp_password) {
	   
	    this.Emp_id = Emp_id;
	    this.Emp_name = Emp_name;
	    this.Emp_email = Emp_email;
	    this.Emp_address = Emp_addres;
	    this.Emp_profile = Emp_profile;
	    this.Emp_password = Emp_password;
	    // TODO Auto-generated constructor stub
	}

	public String getEmp_name() {
		return Emp_name;
	}
	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}
	public String getEmp_email() {
		return Emp_email;
	}
	public void setEmp_email(String emp_email) {
		Emp_email = emp_email;
	}
	public String getEmp_address() {
		return Emp_address;
	}
	public void setEmp_address(String emp_address) {
		Emp_address = emp_address;
	}
	public String getEmp_profile() {
		return Emp_profile;
	}
	public void setEmp_profile(String emp_profile) {
		Emp_profile = emp_profile;
	}
	
	public String getEmp_password() {
		return Emp_password;
	}
	public void setEmp_password(String emp_password) {
		Emp_password = emp_password;
	}
	
	
}
