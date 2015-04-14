package aliexpress.controller.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import aliexpress.model.Account;
import aliexpress.services.AccountService;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;

@Controller
@RequestMapping("/accountRegistration")
public class AccountWebController {

	private AccountService accountService;

	@Autowired
	public AccountWebController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		return "AccountRegistration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerAccount(@RequestParam("account") Account account,
			@RequestParam("email") String email,
			@RequestParam("password") String password)
			throws InvalidEmailException, EmailExistsException {
		accountService.insertOrUpdate(account);
		return "AccountRegistration";
	}
}
