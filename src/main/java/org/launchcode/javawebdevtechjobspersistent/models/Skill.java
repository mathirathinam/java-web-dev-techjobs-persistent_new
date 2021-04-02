package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @ManyToMany(mappedBy="skills")
    public List<Job> jobs = new ArrayList<>();

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Description is too long")
    private String description;

    public Skill(String description){
        this.description=description;
    }
    public Skill(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}