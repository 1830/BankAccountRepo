package packages.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_limits")

public class TransactionSettings {
	
//TABLE MAPPINGS
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "transaction_limit_id")
	private Long transaction_limit_id;
	
	@Column(name = "max_depo_per_day")
	private Integer max_depo_per_day;
	
	@Column(name = "max_depo_per_transaction")
	private Integer max_depo_per_trans;
	
	@Column(name = "max_depo_freq")
	private Integer max_depo_freq;
	
	@Column(name = "max_withdraw_per_day")
	private Integer max_withd_per_day;
	
	@Column(name = "max_withdraw_per_transaction")
	private Integer max_withd_per_trans;
	
	@Column(name = "max_withdraw_freq")
	private Integer max_withd_freq;
	
	//CONSTRUCTORS
	public TransactionSettings() {}
	public TransactionSettings(Long transaction_limit_id, Integer max_depo_per_day, Integer max_depo_per_trans,
			Integer max_depo_freq, Integer max_withd_per_day, Integer max_withd_per_trans, Integer max_withd_freq) {
		super();
		this.transaction_limit_id = transaction_limit_id;
		this.max_depo_per_day = max_depo_per_day;
		this.max_depo_per_trans = max_depo_per_trans;
		this.max_depo_freq = max_depo_freq;
		this.max_withd_per_day = max_withd_per_day;
		this.max_withd_per_trans = max_withd_per_trans;
		this.max_withd_freq = max_withd_freq;
	}
	
	
	
	public void setTransaction_limit_id(Long transaction_limit_id) {
		this.transaction_limit_id = transaction_limit_id;
	}
	//GETTERS & SETTERS
	public Long getTransaction_limit_id() {
		return transaction_limit_id;
	}
	
	public Integer getMax_depo_per_day() {
		return max_depo_per_day;
	}
	public void setMax_depo_per_day(Integer max_depo_per_day) {
		this.max_depo_per_day = max_depo_per_day;
	}
	public Integer getMax_depo_per_trans() {
		return max_depo_per_trans;
	}
	public void setMax_depo_per_trans(Integer max_depo_per_trans) {
		this.max_depo_per_trans = max_depo_per_trans;
	}
	public Integer getMax_depo_freq() {
		return max_depo_freq;
	}
	public void setMax_depo_freq(Integer max_depo_freq) {
		this.max_depo_freq = max_depo_freq;
	}
	public Integer getMax_withd_per_day() {
		return max_withd_per_day;
	}
	public void setMax_withd_per_day(Integer max_withd_per_day) {
		this.max_withd_per_day = max_withd_per_day;
	}
	public Integer getMax_withd_per_trans() {
		return max_withd_per_trans;
	}
	public void setMax_withd_per_trans(Integer max_withd_per_trans) {
		this.max_withd_per_trans = max_withd_per_trans;
	}
	public Integer getMax_withd_freq() {
		return max_withd_freq;
	}
	public void setMax_withd_freq(Integer max_withd_freq) {
		this.max_withd_freq = max_withd_freq;
	}
	@Override
	public String toString() {
		return "TransactionSettings [transaction_limit_id=" + transaction_limit_id + ", max_depo_per_day="
				+ max_depo_per_day + ", max_depo_per_trans=" + max_depo_per_trans + ", max_depo_freq=" + max_depo_freq
				+ ", max_withd_per_day=" + max_withd_per_day + ", max_withd_per_trans=" + max_withd_per_trans
				+ ", max_withd_freq=" + max_withd_freq + "]";
	}
	
	
	

}
