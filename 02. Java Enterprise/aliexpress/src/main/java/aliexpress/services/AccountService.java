package aliexpress.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aliexpress.services.exceptions.NoSuchAccountException;
import aliexpress.dataaccess.accountdao.AccountDAO;
import aliexpress.dataaccess.creditcarddao.CreditCardDAO;
import aliexpress.model.Account;
import aliexpress.model.CreditCard;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;

@Service
public class AccountService {

	private AccountDAO accountDAO;
	private CreditCardDAO creditcardDAO;

	@Autowired
	public AccountService(AccountDAO accountDAO, CreditCardDAO creditcardDAO) {
		super();
		this.accountDAO = accountDAO;
		this.creditcardDAO = creditcardDAO;
	}

	public void insert(Account account) throws InvalidEmailException,
			EmailExistsException {
		if (!Validator.isValidEmailAddress(account.getEmail())) {
			throw new InvalidEmailException();
		}
		Validator.checkEmail(accountDAO.getAll(), account);

		accountDAO.insert(account);
		insertCreditCards(account);
	}

	public void update(Account account) throws InvalidEmailException,
			EmailExistsException, NoSuchAccountException {
		if (!Validator.isValidEmailAddress(account.getEmail())) {
			throw new InvalidEmailException();
		}
		Validator.checkEmail(accountDAO.getAll(), account);
		accountDAO.update(account);
		insertCreditCards(account);
	}

	public Account getAccount(String email, String password)
			throws NoSuchAccountException {
		Account account = accountDAO.get(email, password);
		if (account == null) {
			throw new NoSuchAccountException();
		}
		return account;
	}

	public void insertCreditCards(Account account) {
		Set<CreditCard> creditcards = account.getCreditcards();
		for (CreditCard c : creditcards) {
			c.setAccount(account);
			creditcardDAO.insert(c);
		}
	}

	public List<CreditCard> getCreditCards(Account account) {
		return creditcardDAO.getAll(account);
	}
}
