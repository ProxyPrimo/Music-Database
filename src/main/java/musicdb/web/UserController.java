package musicdb.web;

import musicdb.data.binding.UserLoginBindingModel;
import musicdb.data.binding.UserRegistrationBindingModel;
import musicdb.data.service.UserServiceModel;
import musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    private String register(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) return "redirect:/";
        if (!model.containsAttribute("userRegistrationBindingModel")) {
            model
                    .addAttribute(
                            "userRegistrationBindingModel", new UserRegistrationBindingModel());
        }
        return "register";
    }


    @PostMapping("/register")
    private String registerConfirm(@Valid UserRegistrationBindingModel userRegistrationBindingModel
    , BindingResult bindingResult
    , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.register(modelMapper
                .map(userRegistrationBindingModel
                        , UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    private String login(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) return "redirect:/";

        if (!model.containsAttribute("userLoginBindingModel")) {
            model
                    .addAttribute(
                            "userLoginBindingModel", new UserLoginBindingModel());
        }

        return "login";
    }

    @PostMapping("/login")
    private String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel
    , BindingResult bindingResult
    , RedirectAttributes redirectAttributes
    , HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername()
        , userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel.getUsername());

        return "redirect:/";
    }


    @GetMapping("/logout")
    private String logout(HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) httpSession.invalidate();
        return "redirect:/";
    }
}
