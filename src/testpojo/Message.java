package testpojo;

import javax.persistence.*;

@Entity
@Table(name = "message", schema = "feroz")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	String content;
	@OneToOne // (mappedBy = "message")
	Email email;

	public Message() {
	}

	public Message(String content) {
		setContent(content);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}