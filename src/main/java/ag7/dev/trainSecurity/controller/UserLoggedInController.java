package ag7.dev.trainSecurity.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import ag7.dev.trainSecurity.data.JobAdRepository;
import ag7.dev.trainSecurity.model.JobAd;

@Controller
@RequestMapping("/userloggedin")
public class UserLoggedInController {
    
    private JobAdRepository jobAdRepository;

    public UserLoggedInController(JobAdRepository jobAdRepository) {
        this.jobAdRepository = jobAdRepository;
    }

    /**
     * Display actuality view with 6 last job ad save
     * @param model
     * @return actuality view
     */
    @GetMapping("index")
    public String index(Model model) {
        // get 6 last job ad
        Pageable top6 = PageRequest.of(0, 6, Sort.by("id").descending());

        List<JobAd> jobAds = this.jobAdRepository.findAll(top6).toList();

        model.addAttribute("jobAds", jobAds);

        return "userloggedin/index";
    }


}