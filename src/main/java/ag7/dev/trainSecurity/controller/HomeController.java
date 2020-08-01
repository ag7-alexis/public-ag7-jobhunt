package ag7.dev.trainSecurity.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ag7.dev.trainSecurity.data.UserRepository;
import ag7.dev.trainSecurity.model.User;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public HomeController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Display Home view
     * @return home view
     */
    
    @GetMapping("index")
    public String index() {
        return "index";
    }

    /**
     * Display login view
     * @return login view
     */

    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * Display register view
     * @param model
     * @return register view
     */

    @GetMapping("register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    /**
     * Try to sign up a user and return error if user login allready exist
     * @param user
     * @return login view
     */

    @PostMapping("signup")
    public String signup(@ModelAttribute(value = "user") User user) {
        if (this.userRepository.findByUsername(user.getUsername()).isPresent()) return "redirect:/register?error";

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setPermissions("BASIC");
        user.setRoles("USER");
        
        this.userRepository.save(user);

        return "redirect:/login";
    }

    
}