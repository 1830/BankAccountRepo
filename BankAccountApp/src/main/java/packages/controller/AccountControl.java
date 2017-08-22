package packages.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import packages.models.account;
 
 
@Controller
public class AccountControl {
  
	 @RequestMapping(value= "/", method = RequestMethod.GET)
	  public String home(){
			return "accountmenu";
	  }
	 
	 @RequestMapping(value= "/withdraw", method = RequestMethod.GET)
	  public String withd(Model model){
			model.addAttribute("account_", new account());			
			return "withdraw";
	  }
	 
	 @RequestMapping(value= "/withdraw", method = RequestMethod.POST)
	  public String withd_(account acc){
		 
		  RestTemplate restTemplate = new RestTemplate();
		  String url="http://localhost:8888/bankaccount/withdraw";
		  restTemplate.postForEntity(url,acc, account.class); 
			return "redirect:/";
	  }
	 
 
	 
	 @RequestMapping(value= "/deposit", method = RequestMethod.GET)
	  public String depo(Model model){
			model.addAttribute("account_", new account());			
			return "deposit";
	  }
	 
	 @RequestMapping(value= "/deposit", method = RequestMethod.POST)
	  public String depo_(account acc){
		 
		  RestTemplate restTemplate = new RestTemplate();
		  String url="http://localhost:8888/bankaccount/deposit";
		  restTemplate.postForObject(url,acc, account.class); 
			return "redirect:/";
	  }
	 
	
	 
	 @RequestMapping(value= "/balance", method = RequestMethod.GET)
	  public String bal(){
			return "balance";
	  }
	 
	 
	 
	 
  
  //GET BALANCE
//  @RequestMapping(value = "/balance", method = RequestMethod.GET)
//  public String balance(account acc){
//

  
 
}
