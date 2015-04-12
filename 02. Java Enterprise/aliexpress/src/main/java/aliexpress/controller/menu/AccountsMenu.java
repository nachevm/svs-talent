package aliexpress.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.actions.AccountRegistrationAction;
import aliexpress.controller.actions.AccountUpdateAction;
import aliexpress.controller.actions.Action;
import aliexpress.controller.ui.UI;

@Component
public class AccountsMenu extends Menu {

	private AccountRegistrationAction action1;
	private AccountUpdateAction action2;

	@Autowired
	public AccountsMenu(UI ui, AccountRegistrationAction action1,
			AccountUpdateAction action2) {
		super(ui);
		this.action1 = action1;
		this.action2 = action2;
	}

	@Override
	public Action[] getActions() {
		Action[] actions = { action1, action2 };
		return actions;
	}

}
