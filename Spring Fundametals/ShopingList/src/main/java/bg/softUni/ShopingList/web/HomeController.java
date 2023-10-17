package bg.softUni.ShopingList.web;

import bg.softUni.ShopingList.model.entity.enums.CategoryName;
import bg.softUni.ShopingList.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalProductSum());
        model.addAttribute("drinks", productService.getAllProductByCategoryName(CategoryName.DRINK));
        model.addAttribute("food", productService.getAllProductByCategoryName(CategoryName.FOOD));
        model.addAttribute("household", productService.getAllProductByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("other", productService.getAllProductByCategoryName(CategoryName.OTHER));

        return "home";
    }
}
