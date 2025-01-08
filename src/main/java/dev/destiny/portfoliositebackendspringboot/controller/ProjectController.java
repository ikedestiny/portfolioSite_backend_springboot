package dev.destiny.portfoliositebackendspringboot.controller;

import dev.destiny.portfoliositebackendspringboot.model.Project;
import dev.destiny.portfoliositebackendspringboot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    @GetMapping("/all")
    public List<Project> getAllProjects(){
        return projectService.getALl();
    }

    @GetMapping("/nameSearch/{name}")
    public ResponseEntity<List<Project>> findByName(@PathVariable String name){
        List<Project> projects = projectService.getByName(name);
        if (projects.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projects);
    }

    // Get person by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getPersonById(@PathVariable Long id) {
        Optional<Project> person = projectService.getById(id);
        return person.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new person
    @PostMapping("/new")
    public ResponseEntity<Project> addNewProject(@RequestBody Project project) {
        Project savedProject = projectService.save(project);
        return ResponseEntity.status(201).body(savedProject);
    }


    //Delete Project
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
