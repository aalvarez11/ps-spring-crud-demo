package com.perscholas.demo.controller;

import com.perscholas.demo.model.Tutorial;
import com.perscholas.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorials")
    public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
        return tutorialService.getAllTutorials();
    }

    @GetMapping("/tutorials/{id}")
    public Optional<Tutorial> getTutorialById(@PathVariable("id") Long id) {
        /* the TutorialRepository provides a method findById(). This methods takes the id of the
         * Tutorial to find. This method used to be findOne(). But since Spring data jpa 2.0 it's
         * changed to findById().
         */
        return tutorialService.getTutorialById(id);
    }

    // adding a tutorial is easy; just use TutorialRepository's save() method
    @PostMapping("/tutorials")
    public void createTutorial(@RequestBody Tutorial tutorial) {
        tutorialService.addTutorial(tutorial);
    }

    // updating a tutorial uses the same save() and findById()
    @PutMapping("/tutorials/{id}")
    public void updateTutorial(@PathVariable("id") Long id, @RequestBody Tutorial tutorial) {
        tutorialService.updateTutorial(id, tutorial);
    }

    @DeleteMapping("/tutorials/{id}")
    public void deleteTutorial(@PathVariable("id") Long id) {
        tutorialService.deleteTutorial(id);
    }

    @DeleteMapping("/tutorials")
    public void deleteAllTutorials() {
        tutorialService.deleteAllTutorials();
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        return tutorialService.findByPublished();
    }
}
