package ag7.dev.trainSecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobAd {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String githubId;

    private String title;

    private String location;

    private String company;

    @Column(columnDefinition="text")
    private String description;

    @Column(columnDefinition="text")
    private String howToApply;

    private String techno;

    public JobAd() {
    }

    public JobAd(long id, String title, String location, String company, String description, String howToApply) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.company = company;
        this.description = description;
        this.howToApply = howToApply;
    }

    public JobAd(String title, String location, String company, String description, String howToApply) {
        this.title = title;
        this.location = location;
        this.company = company;
        this.description = description;
        this.howToApply = howToApply;
    }

    public JobAd(long id, String title, String location, String company, String description, String howToApply,
            String techno) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.company = company;
        this.description = description;
        this.howToApply = howToApply;
        this.techno = techno;
    }

    public JobAd(String title, String location, String company, String description, String howToApply, String techno) {
        this.title = title;
        this.location = location;
        this.company = company;
        this.description = description;
        this.howToApply = howToApply;
        this.techno = techno;
    }

    public JobAd(String location, String techno) {
        this.location = location;
        this.techno = techno;
    }

    public JobAd(String githubId, String title, String location, String company, String description, String howToApply,
            String techno) {
        this.githubId = githubId;
        this.title = title;
        this.location = location;
        this.company = company;
        this.description = description;
        this.howToApply = howToApply;
        this.techno = techno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToApply() {
        return howToApply;
    }

    public void setHowToApply(String howToApply) {
        this.howToApply = howToApply;
    }

    public String getTechno() {
        return techno;
    }

    public void setTechno(String techno) {
        this.techno = techno;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    @Override
    public String toString() {
        return "JobAd [company=" + company + ", howtoapply=" + howToApply + ", id=" + id + ", location=" + location
                + ", techno=" + techno + ", title=" + title + "]";
    }

}