package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report", schema = "feroz")
public class Report {
	@Id
	@GeneratedValue
	@Column(name = "report_id")
	private int report_id;
	
	@Column(name = "report_name")
	private String report_name;
	
	@Column(name = "report_type")
	private String report_type;
	
	@Column(name = "report_url")
	private String report_url;
	
	@Column(name = "user_type")
	private String user_type;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(String report_name, String report_type, String report_url,String user_type) {
		super();
		this.report_name = report_name;
		this.report_type = report_type;
		this.report_url = report_url;
		this.user_type = user_type;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public String getReport_url() {
		return report_url;
	}

	public void setReport_url(String report_url) {
		this.report_url = report_url;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	
	
	
}
