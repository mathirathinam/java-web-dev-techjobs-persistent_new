package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

   /* @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Description is too long")
    private String name; */
   @ManyToOne
    private Employer employer;
    @ManyToMany
    private List<Skill> skills = new ArrayList<>();
   //private List<Skill> skills;

    public Job() {
    }

    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters.
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
*/

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}