package bg.softUni.ShopingList.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(HttpSession httpSession){

        return httpSession.getAttribute("user") == null ? "index" : "home";
    }
}
