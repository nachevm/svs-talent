package aliexpress.controller.actions;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.ui.UI;
import aliexpress.model.Account;
import aliexpress.model.CreditCard;
import aliexpress.services.AccountService;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;

@Component
public class AccountRegistrationAction implements Action {

	private UI ui;
	private AccountService accountService;

	@Autowired
	public AccountRegistrationAction(UI ui, AccountService accountService) {
		super();
		this.ui = ui;
		this.accountService = accountService;
	}

	@Override
	public String getTitle() {
		return "Account Registration";
	}

	@Override
	public void execute() {
		try {
			String name = ui.requestInput("name");
			String email = ui.requestInput("e-mail");
			String password = ui.requestInput("password");

			Set<CreditCard> creditcards = new HashSet<CreditCard>();
			int n = Integer.parseInt(ui
					.requestInput("number of credit cards (at least 1)"));
			if (n < 1) {
				n = 1;
			}
			for (int i = 0; i < n; i++) {
				long cardNumber = Long
						.parseLong(ui.requestInput("card number"));
				String nameOnCard = ui.requestInput("name on card");
				byte expirationMonth = Byte.parseByte(ui
						.requestInput("expiration month"));
				short expirationYear = Short.parseShort(ui
						.requestInput("expiration year"));
				short cvc = Short.parseShort(ui.requestInput("CVC2/CVV2"));
				CreditCard creditCard = new CreditCard(cardNumber, nameOnCard,
						expirationMonth, expirationYear, cvc);
				creditcards.add(creditCard);
			}

			Account account = new Account(name, email, password, creditcards);

			accountService.insert(account);

		} catch (InvalidEmailException e) {
			ui.log("Invalid e-mail!");
		} catch (EmailExistsException e) {
			ui.log("E-mail already exists!");
		}
	}
}
