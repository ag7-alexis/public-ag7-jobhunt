package ag7.dev.trainSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.json.*;

import ag7.dev.trainSecurity.data.JobAdRepository;
import ag7.dev.trainSecurity.model.JobAd;

@Controller
@RequestMapping("management")
public class ManagementController {

    private JobAdRepository jobAdRepository;

    public ManagementController(JobAdRepository jobAdRepository) {
        this.jobAdRepository = jobAdRepository;
    }

    /**
     * Display management view
     * @param model
     * @return management view
     */

    @GetMapping("index")
    public String index(Model model) {
        JobAd jobad = new JobAd();
        model.addAttribute("jobad", jobad);
        return "management/index";
    }

    /**
     * Call github job api to get job ad info to save in database
     * @param id
     * @return management view
     * @throws JSONException
     */

    @GetMapping("saveJobAd/{id}")
    public String saveJobAd(@PathVariable String id) throws JSONException {
        String url = "https://jobs.github.com/positions/"+ id + ".json";

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);

        JSONObject item = new JSONObject(result);

        String githubId = item.getString("id");
        String company = item.getString("company");
        String location = item.getString("location");
        String title = item.getString("title");
        String description = item.getString("description");
        String howToApply = item.getString("how_to_apply");

        JobAd aJobAd = new JobAd();
        aJobAd.setGithubId(githubId);
        aJobAd.setCompany(company);
        aJobAd.setLocation(location);
        aJobAd.setTitle(title);
        aJobAd.setDescription(description);
        aJobAd.setHowToApply(howToApply);

        this.jobAdRepository.save(aJobAd);

        return "redirect:/management/index";
    }

    /**
     * Call github job api to get the list of job ad who match with search param (techno and location) and display result on management view
     * @param model
     * @param jobAd
     * @return management view
     * @throws JSONException
     */

    @PostMapping("search")
    public String search(Model model, @ModelAttribute(value = "jobad") JobAd jobAd) throws JSONException {

        String url = "https://jobs.github.com/positions.json?search=" + jobAd.getTechno() + "&location="
                + jobAd.getLocation();

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);

        JSONArray items = new JSONArray(result);

        List<JobAd> jobAds = new ArrayList<>();

        for(int i = 0 ; i < items.length() ; i++){
            String githubId = items.getJSONObject(i).getString("id");
             String company = items.getJSONObject(i).getString("company");
             String location = items.getJSONObject(i).getString("location");
             String title = items.getJSONObject(i).getString("title");
             String description = items.getJSONObject(i).getString("description");
             String howToApply = items.getJSONObject(i).getString("how_to_apply");
             
             JobAd aJobAd = new JobAd();
             aJobAd.setGithubId(githubId);
             aJobAd.setCompany(company);
             aJobAd.setLocation(location);
             aJobAd.setTitle(title);
             aJobAd.setDescription(description);
             aJobAd.setHowToApply(howToApply);

             jobAds.add(aJobAd);
        }

        if (jobAds.size() == 0) model.addAttribute("noResult", true);

        model.addAttribute("jobAds", jobAds);
        return "/management/index";
    }


    
}