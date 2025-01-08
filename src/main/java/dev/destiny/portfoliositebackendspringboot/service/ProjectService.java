package dev.destiny.portfoliositebackendspringboot.service;

import dev.destiny.portfoliositebackendspringboot.model.Project;
import dev.destiny.portfoliositebackendspringboot.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project save(Project project){
        return projectRepo.save(project);
    }

    public List<Project> getALl(){
        return projectRepo.findAll();
    }

    public List<Project> getByName(String name){
        return projectRepo.findByName(name);
    }

    public void deleteProject(Long id){
        projectRepo.deleteById(id);
    }

    public Optional<Project> getById(Long id) {
        return projectRepo.findById(id);
    }
}
