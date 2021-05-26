package musicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    private String index(HttpSession httpSession) {
        return httpSession.getAttribute("user") == null ? "index" : "home";
    }
}