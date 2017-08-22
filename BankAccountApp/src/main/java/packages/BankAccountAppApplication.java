package packages;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@SpringBootApplication
public class BankAccountAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountAppApplication.class, args);
	}
	 @InitBinder
     public void initBinder(WebDataBinder binder) {
         binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
     }
}
