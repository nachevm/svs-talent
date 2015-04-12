package aliexpress.dataaccess.accountdao;

import java.util.List;

import aliexpress.model.Account;

public interface AccountDAO {

	List<Account> getAll();

	Account get(String email, String password);

	void insert(Account account);

	void update(Account account);
}
