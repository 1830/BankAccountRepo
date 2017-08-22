package packages.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")

public class transactions {
	

	//TABLE MAPPING
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "transaction_id")
	private Long transaction_id;
	@Column(name = "account_id")
	private Long account_id;
	
	@Column(name = "transaction_type")
	private String transaction_type;
	@Column(name = "transaction_amount")
	private double transaction_amount;
	@Column(name = "transaction_time")
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
