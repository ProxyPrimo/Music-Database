package musicdb.web;

import musicdb.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }


    @GetMapping("/")
    private String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) return "index";

        model.addAttribute("albums", albumService.showAllAlbums());
        model.addAttribute("copiesCount", albumService.getCopiesCount());
        return "home";
    }
}
