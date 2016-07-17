package pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users",schema = "feroz")
public class Login {
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "id")
	   private int id;

	   @Column(name = "first_name")
	   private String firstName;

	   @Column(name = "last_name")
	   private String lastName;

	   @Column(name = "user_type")
	   private String userType;

	   @Column(name = "createAt")	   
	   private Date createAt;

	   @Column(name = "login_count")	   
	   private int loginCount;

		@OneToOne(cascade = CascadeType.ALL)
		 private Address studentAddress;


	public Login(String firstName, String lastName, String userType, Date createAt, int loginCount,
				Address studentAddress) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userType = userType;
			this.createAt = createAt;
			this.loginCount = loginCount;
			this.studentAddress = studentAddress;
		}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	   
	   
	   
}
