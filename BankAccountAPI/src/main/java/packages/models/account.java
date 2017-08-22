package packages.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")

public class account implements Serializable {
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	//TABLE MAPPING
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long account_id;
	
	private Integer accountbalance;
	private Integer total_deposit;
	private Integer total_withdraw;
	private Integer deposit_count;
	private Integer withdraw_count;
	

	//CONSTRUCTORS
	public account() {}
	public account(Long account_id, Integer accountbalance, Integer total_deposit, Integer total_withdraw,
			Integer deposit_count, Integer withdraw_count) {
		super();
		this.account_id = account_id;
		this.accountbalance = accountbalance;
		this.total_deposit = total_deposit;
		this.total_withdraw = total_withdraw;
		this.deposit_count = deposit_count;
		this.withdraw_count = withdraw_count;
	}

	//GETTER & SETTER METHODS
	public Long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	public Integer getAccountbalance() {
		return accountbalance;
	}
	
	public void setAccountbalance(Integer accountbalance) {
		this.accountbalance = accountbalance;
	}
	public Integer getTotal_deposit() {
		return total_deposit;
	}
	public void setTotal_deposit(Integer total_deposit) {
		this.total_deposit = total_deposit;
	}
	public Integer getTotal_withdraw() {
		return total_withdraw;
	}
	public void setTotal_withdraw(Integer total_withdraw) {
		this.total_withdraw = total_withdraw;
	}
	public Integer getDeposit_count() {
		return deposit_count;
	}
	public void setDeposit_count(Integer deposit_count) {
		this.deposit_count = deposit_count;
	}
	public Integer getWithdraw_count() {
		return withdraw_count;
	}
	public void setWithdraw_count(Integer withdraw_count) {
		this.withdraw_count = withdraw_count;
	}
	
	

}
