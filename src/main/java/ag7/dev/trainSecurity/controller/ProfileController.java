package ag7.dev.trainSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController {
    
    /**
     * display profile view
     * @return profile view
     */
    @GetMapping("index") 
    public String index() {
        return "profile/index";
    }
}