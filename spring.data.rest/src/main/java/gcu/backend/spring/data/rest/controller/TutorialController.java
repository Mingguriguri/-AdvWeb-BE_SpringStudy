package gcu.backend.spring.data.rest.controller;

import gcu.backend.spring.data.rest.model.Tutorial;
import gcu.backend.spring.data.rest.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping
public class TutorialController {

    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialController(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    // retrieve all Tutorials
    @GetMapping("/")
    public List<Tutorial> getAllTutorials(){
        return tutorialRepository.findAll();
    }

    // create New Tutorial
    @PostMapping("/")
    public ResponseEntity<String> addNewTutorial(@RequestBody Tutorial tutorial){
        tutorialRepository.save(tutorial);
        return ResponseEntity.ok(tutorial.toString());
    }

    // retrieve a Tutorial by id
    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable long id) {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        if (tutorialOptional.isPresent()) {
            return ResponseEntity.ok(tutorialOptional.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    // update a Tutorial by id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTutorialById(@PathVariable long id, @RequestBody Tutorial tutorial){
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        Tutorial existingTutorial = tutorialOptional.get();
        existingTutorial.setTitle(tutorial.getTitle());
        existingTutorial.setDescription(tutorial.getDescription());
        tutorialRepository.save(existingTutorial);

        return ResponseEntity.ok(tutorial.toString());
    }


    // delete a Tutorial by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTutorialById(@PathVariable long id){
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);
        if (tutorialOptional.isPresent()) {
            tutorialRepository.delete(tutorialOptional.get());
            return ResponseEntity.ok(tutorialOptional.toString());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
