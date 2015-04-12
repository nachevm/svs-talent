package aliexpress.controller.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.menu.AccountsMenu;

@Component
public class OpenAccountManagementAction implements Action {

	private AccountsMenu menu;

	@Autowired
	public OpenAccountManagementAction(AccountsMenu menu) {
		super();
		this.menu = menu;
	}

	@Override
	public String getTitle() {
		return "Account Management";
	}

	@Override
	public void execute() {
		menu.run();
	}

}
