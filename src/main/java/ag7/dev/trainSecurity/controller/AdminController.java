package ag7.dev.trainSecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ag7.dev.trainSecurity.data.UserRepository;
import ag7.dev.trainSecurity.model.User;

@Controller
@RequestMapping("admin")
public class AdminController {

    private UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Display Admin view
     * @param model
     * @return admin view
     */

    @GetMapping("index")
    public String index(Model model) {
        List<User> users = this.userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/index";
    }

    /**
     * Upgrade Role of a User from User to Management
     * @param id
     * @return admin view
     */

    @GetMapping("upgradeToManagement/{id}")
    public String upgradeToManagement(@PathVariable Long id, Model model) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()){
            user.get().setRoles("MANAGEMENT");
            this.userRepository.save(user.get());
        }
        return "redirect:/admin/index";
    }

    /**
     * Downgrade Role of a User from Management to User
     * @param id
     * @return admin view
     */

    @GetMapping("downgradeToUser/{id}")
    public String downgradeToUser(@PathVariable Long id, Model model) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()){
            user.get().setRoles("USER");
            this.userRepository.save(user.get());
        }
        return "redirect:/admin/index";
    }

    
    
}