package packages.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class transactions {
	private Long transaction_id;
	private Long account_id;
	private String transaction_type;
	private double transaction_amount;
	private Timestamp date;
	
	//CONSTRUCTORS
	public transactions() {}
	public transactions( Long account_id, String transaction_type, double transaction_amount,
			Timestamp date) {
		super();
		this.account_id = account_id;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.date = date;
	}

	
	
	//GETTERS & SETTERS
	
	public Long getTransaction_id() {
		return transaction_id;
	}
	public Long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	
	
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	

	
	

}
