package dev.destiny.portfoliositebackendspringboot.repository;
import dev.destiny.portfoliositebackendspringboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepo extends JpaRepository<Project,Long> {
    List<Project> findByName(String name);
}
