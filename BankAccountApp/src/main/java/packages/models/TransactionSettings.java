package packages.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class TransactionSettings {
	private Long transaction_limit_id;
	private Integer max_depo_per_day;
	private Integer max_depo_per_trans;
	private int max_depo_freq;
	private Integer max_withd_per_day;
	private Integer max_withd_per_trans;
	private int max_withd_freq;
	
	//CONSTRUCTORS
	public TransactionSettings() {}
	public TransactionSettings(Long transaction_limit_id, Integer max_depo_per_day, Integer max_depo_per_trans,
			int max_depo_freq, Integer max_withd_per_day, Integer max_withd_per_trans, int max_withd_freq) {
		super();
		this.transaction_limit_id = transaction_limit_id;
		this.max_depo_per_day = max_depo_per_day;
		this.max_depo_per_trans = max_depo_per_trans;
		this.max_depo_freq = max_depo_freq;
		this.max_withd_per_day = max_withd_per_day;
		this.max_withd_per_trans = max_withd_per_trans;
		this.max_withd_freq = max_withd_freq;
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
	

}
