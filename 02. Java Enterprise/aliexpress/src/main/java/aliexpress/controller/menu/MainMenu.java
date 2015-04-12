package aliexpress.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.actions.Action;
import aliexpress.controller.actions.OpenAccountManagementAction;
import aliexpress.controller.actions.OpenShopAction;
import aliexpress.controller.ui.UI;

@Component
public class MainMenu extends Menu {

	private OpenAccountManagementAction action1;
	private OpenShopAction action2;

	@Autowired
	public MainMenu(UI ui, OpenAccountManagementAction action1,
			OpenShopAction action2) {
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
