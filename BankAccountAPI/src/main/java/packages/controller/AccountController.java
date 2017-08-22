package packages.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import packages.models.TransactionSettings;
import packages.models.account;
import packages.models.transactions;
import packages.services.*;


@RestController    // This means that this class is a Controller
@RequestMapping(path="/bankaccount") // This means URL's start with /demo (after Application path)
public class AccountController {
	
    // Which is auto-generated by Spring, we will use it to handle the data
	// This means to get the bean called userRepository
	
	@Autowired 
    private AccountRepository acc_repo;
	
	@Autowired 
    private TransactionRepository trans_repo;
	
	@Autowired 
    private TranSettingRepo setting_repo;
	
	transactions transaction = new transactions() ;

	TransactionSettings trans;


	
//********************BALANCE ENDPOINT*************************
	@RequestMapping(path="/balance" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String, Object>> getbalance(@RequestBody account acc) { 		// This returns a JSON or XML with the users
		Long  id = acc.getAccount_id();
		
		account accc = acc_repo.findOne(acc.getAccount_id());
		transactions transaction = new transactions();
		String balance = "balance";


		  //logging withdraw transaction
		  transaction.setTransaction_type(balance);
		  transaction.setTransaction_amount(0);
		  transaction.setAccount_id(id);
		  trans_repo.save(transaction); 
		  
		  Map<String, Object> successmessage_b = new HashMap<String, Object>();
		  successmessage_b.put("status",  "TRANSACTION SUCCESSFUL");
		  successmessage_b.put("message", "CURRENT BALANCE          : " +accc.getAccountbalance());
		  
		    return (new ResponseEntity<Map<String, Object>>(successmessage_b, HttpStatus.OK));

		  
		  
		}
	
	
//******************DEPOSIT ENDPOINT*****************************
	@RequestMapping(path="/deposit" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String, Object>> deposit(@RequestBody account acc) {
	       //1.take amount from balance in reqbody, assign to deposit
		   //2. fetch account from db, assign to useracc
		   //3. from account fetched, take balance
		   //4. add the original and the new
		
	     account useracc = acc_repo.findOne(acc.getAccount_id());
		transactions transaction = new transactions();
		String deposit = "deposit";



		
		//GET CONSTRAINTS
		 Long num = (long) 1;
		TransactionSettings trans = setting_repo.findOne(num);
			
				Integer MaxdepoCount = trans.getMax_depo_freq();
				Integer MaxDaydepo = trans.getMax_depo_per_day();
				Integer MaxdepoTrans = trans.getMax_depo_per_trans();     
		  
				
		 //DepositCount
         Integer originalDepoCount = useracc.getDeposit_count();
	      Integer depoCount_ = originalDepoCount + 1;

        
         //TotalBalance
		 Integer depositedAmount = acc.getAccountbalance();
	     Integer originalbal =  useracc.getAccountbalance();
	      Integer finalbal = depositedAmount + originalbal;

	     
	     //TotalDeposit
	     Integer originalTotaldepo = useracc.getTotal_deposit();
	     Integer totaldepo = depositedAmount +  originalTotaldepo;
	     
	     
//***************RESPONSE MESSAGES TO TRANSACTIONS*******************
		  Map<String, Object> successmessage_ = new HashMap<String, Object>();
		  successmessage_.put("status",  "TRANSACTION SUCCESSFUL");
		  successmessage_.put("message", "CURRENT BALANCE          : " +finalbal);
		  
		  Map<String, Object> message1_ = new HashMap<String, Object>();
		  message1_.put("status", "FAILED");
		  message1_.put("message", "MAX DEPOSIT AMOUNT/TRANSACTION PASSED");
		  
		  
		  Map<String, Object> message3_ = new HashMap<String, Object>();
		  message3_.put("status", "FAILED");
		  message3_.put("message"," MAX DEPOSIT/DAY AMOUNT PASSED");
		  
		  
		  Map<String, Object> message2_ = new HashMap<String, Object>();
		  message2_.put("status", "FAILED");
		  message2_.put("message", "MAX DEPOSIT COUNT PER DAY PASSED");

	     
         //VALIDATION OF ENTRY ACCORDING TO SPECIFICATION IN DATABASE
         if (depositedAmount > MaxdepoTrans == true) {
  		    return (new ResponseEntity<Map<String, Object>>(message1_, HttpStatus.NOT_ACCEPTABLE));
	 
         }else if(totaldepo > MaxDaydepo == true) {
  		    return (new ResponseEntity<Map<String, Object>>(message3_, HttpStatus.NOT_ACCEPTABLE));
        	 
         }else if(depoCount_ >  MaxdepoCount == true) {
  		    return (new ResponseEntity<Map<String, Object>>(message2_, HttpStatus.NOT_ACCEPTABLE));
   
         }else {

			  useracc.setTotal_deposit(totaldepo);
			  useracc.setAccountbalance(finalbal);
			  useracc.setDeposit_count(depoCount_);
			  acc_repo.save(useracc);	
			  

			  //logging deposit transaction
			  transaction.setTransaction_type(deposit);
			  transaction.setTransaction_amount(depositedAmount);
			  transaction.setAccount_id(acc.getAccount_id());
			  trans_repo.save(transaction);
			  
  		    return (new ResponseEntity<Map<String, Object>>(successmessage_, HttpStatus.OK));
	     }

	}
	
//*************************WITHDRAW ENDPOINT*************************
	@ModelAttribute
	@RequestMapping(path="/withdraw" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String, Object>> withdraw(@RequestBody account acc ) {
        
	     account useracc = acc_repo.findOne(acc.getAccount_id());
		transactions transaction = new transactions();
		String withdraw = "withdraw";


	     
		 Long num = (long) 1;
		TransactionSettings trans = setting_repo.findOne(num);

		
		//GET CONSTRAINTS
		Integer MaxwithCount = trans.getMax_withd_freq();
		Integer MaxDaywith = trans.getMax_withd_per_day();
		Integer MaxWithTrans = trans.getMax_withd_per_trans();
		

	     //TotalBalance
		 Integer withdAmount = acc.getAccountbalance();
	     Integer originalbal =  useracc.getAccountbalance();
	     Integer finalbal = originalbal - withdAmount;

	     
	     //TotalWithdraw
	     Integer originalTotalwith = useracc.getTotal_withdraw();
	     Integer totalwith = withdAmount +  originalTotalwith;
	     
	     //WithdrawCount
         Integer originalWithdCount = useracc.getWithdraw_count();
         Integer withdCount_ = originalWithdCount + 1;
         
		    
		    
//***************RESPONSE MESSAGES TO TRANSACTIONS*******************
 			  Map<String, Object> successmessage = new HashMap<String, Object>();
     		  successmessage.put("status",  "TRANSACTION SUCCESSFULL");
     		  successmessage.put("message", "CURRENT BALANCE         :"+finalbal);
     		  
     		  Map<String, Object> message1 = new HashMap<String, Object>();
     		  message1.put("status", "FAILED");
     		  message1.put("message", "  MAX WITHDRAW AMOUNT PASSED");
     		  
     		  
     		  Map<String, Object> message3 = new HashMap<String, Object>();
     		  message3.put("status", "FAILED");
     		  message3.put("message", " MAX WITHDRAW/DAY AMOUNT PASSED");
     		  
     		  
     		  Map<String, Object> message2 = new HashMap<String, Object>();
     		 message2.put("status", "FAILED");
     		message2.put("message", "MAX WITHDRAW COUNT /DAY PASSED");
     		  
     		  
     		  Map<String, Object> message4 = new HashMap<String, Object>();
     		  message4.put("status", "FAILED. INSUFFICIENT BALANCE");
     		  message4.put("message", "AVAILABLE BALANCE          :" +originalbal );
     		  

//     		    HttpHeaders headers = new HttpHeaders();
//     		    headers.add("Content-Type", "application/json; charset=UTF-8");
//     		    headers.add("X-Fsl-Location", "/");
//     		    headers.add("X-Fsl-Response-Code", "302");
//     		    headers.add("withdraw", "999");
     		  
     		  
         
//********************VALIDATION OF ENTRY ACCORDING TO SPECIFICATION IN DATABASE**************************     		  
         if (withdAmount > MaxWithTrans == true) {
 		    return (new ResponseEntity<Map<String, Object>>(message1, HttpStatus.NOT_ACCEPTABLE));
	 
         }else if(totalwith > MaxDaywith == true) {
  		    return (new ResponseEntity<Map<String, Object>>(message3, HttpStatus.NOT_ACCEPTABLE));
        	 
         }else if(withdCount_ > MaxwithCount == true) {
  		    return (new ResponseEntity<Map<String, Object>>(message2, HttpStatus.NOT_ACCEPTABLE));
        	 
         }else if(withdAmount > originalbal == true ){
  		    return (new ResponseEntity<Map<String, Object>>(message4, HttpStatus.NOT_ACCEPTABLE));
  		    

         }else {
        	 
        	  useracc.setAccountbalance(finalbal);
       		  useracc.setTotal_withdraw(totalwith);
       		  useracc.setWithdraw_count(withdCount_);
       		  acc_repo.save(useracc);
       		  

    		  //logging withdraw transaction 
    		  transaction.setTransaction_type(withdraw);
    		  transaction.setTransaction_amount(withdAmount);
    		  transaction.setAccount_id(acc.getAccount_id());
    		  trans_repo.save(transaction);
    		  
    	
    		    
    		    return (new ResponseEntity<Map<String, Object>>(successmessage, HttpStatus.OK));
    
        	 
           }}}
         
         
         
	

        


        		 
        	 
	
         
	
	     
      
	 
    	
	