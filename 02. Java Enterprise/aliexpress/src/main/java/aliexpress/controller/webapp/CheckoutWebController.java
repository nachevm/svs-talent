package aliexpress.controller.webapp;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aliexpress.model.Basket;
import aliexpress.model.Product;

@Controller
@SessionAttributes("basket")
@RequestMapping("/checkout")
public class CheckoutWebController {

	@ModelAttribute("products")
	public List<Product> getProducts(@ModelAttribute("basket") Basket basket) {
		return basket.getProducts();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts() {
		return "Checkout";
	}
}
