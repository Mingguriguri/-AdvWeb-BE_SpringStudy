package gcu.backend.spring.data.rest.repository;

import gcu.backend.spring.data.rest.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin(origins = "http://localhost/8081")
@RepositoryRestResource(path = "tutorials")
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContainingIgnoreCase(String title);
    List<Tutorial> findByTitleContaining(String title); // Mission
}
