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
import aliexpress.services.exceptions.NoSuchAccountException;

@Component
public class AccountUpdateAction implements Action {

	private UI ui;
	private AccountService accountService;

	@Autowired
	public AccountUpdateAction(UI ui, AccountService accountService) {
		super();
		this.ui = ui;
		this.accountService = accountService;
	}

	@Override
	public String getTitle() {
		return "Modify Account";
	}

	@Override
	public void execute() {
		try {
			String oldEmail = ui.requestInput("e-mail");
			String oldPassword = ui.requestInput("password");
			Account account = accountService.getAccount(oldEmail, oldPassword);

			String name = ui.requestInput("new name");
			String email = ui.requestInput("new e-mail");
			String password = ui.requestInput("new password");

			Set<CreditCard> creditcards = new HashSet<CreditCard>();
			int n = Integer.parseInt(ui
					.requestInput("number of new credit cards"));
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

			account.setName(name);
			account.setEmail(email);
			account.setPassword(password);
			account.setCreditcards(creditcards);

			accountService.update(account);

		} catch (NoSuchAccountException e) {
			ui.log("No such account!");
		} catch (InvalidEmailException e) {
			ui.log("Invalid e-mail!");
		} catch (EmailExistsException e) {
			ui.log("E-mail already exists!");
		}
	}

}
