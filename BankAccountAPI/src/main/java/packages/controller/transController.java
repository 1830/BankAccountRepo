package packages.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import packages.models.TransactionSettings;
import packages.models.transactions;
import packages.services.TranSettingRepo;
import packages.services.TransactionRepository;

@RestController
public class transController {

	@Autowired 
    private TransactionRepository trans_repo;
	

	@Autowired 
    private TranSettingRepo setting_repo;
	
	
	@RequestMapping(value="/bankaccount/transactions", method= RequestMethod.GET)
	public @ResponseBody Iterable<transactions> viewTransactions() {
		return trans_repo.findAll();
		
	}
	
	
	
	@RequestMapping(value="/bankaccount/settings", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String, Object>> settings(@RequestBody TransactionSettings tranSettt) {
		System.out.println("Recieved transaction settin request: " + tranSettt.toString());
		Long id = tranSettt.getTransaction_limit_id();
		TransactionSettings ts = setting_repo.findOne(id);
		
		ts.setMax_depo_freq(tranSettt.getMax_depo_freq());
		ts.setMax_depo_per_day(tranSettt.getMax_depo_per_day());
		ts.setMax_depo_per_trans(tranSettt.getMax_depo_per_trans());
		
		ts.setMax_withd_freq(tranSettt.getMax_withd_freq());
		ts.setMax_withd_per_day(tranSettt.getMax_withd_per_day());
		ts.setMax_withd_per_trans(tranSettt.getMax_withd_per_trans());
	     setting_repo.save(ts);
	   
	 	setting_repo.findOne(tranSettt.getTransaction_limit_id());
		  
		  Map<String, Object> successmessage_S = new HashMap<String, Object>();
		  successmessage_S.put("status",  "TRANSACTION SUCCESSFUL");
		  successmessage_S.put("message", "ACCOUNT SETTINGS SET SUCCESSFULLY");
		  
		    return (new ResponseEntity<Map<String, Object>>(successmessage_S, HttpStatus.OK));
		
	}
	
	


}
