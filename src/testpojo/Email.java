package testpojo;

import javax.persistence.*;

@Entity
@Table(name = "email",schema = "feroz")

public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	String subject;
	@OneToOne  (mappedBy = "email",cascade = CascadeType.REFRESH)
	Message message;

	public Email() {
	}

	public Email(String subject) {
		setSubject(subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
