package com.example.pandaprioritype;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("personallists")

@RestController

public class PersonalListsController {

    private final PersonalListsService personalListsService;

    public PersonalListsController(PersonalListsService personalListsService) {
        this.personalListsService = personalListsService;
    }

    @GetMapping("list")
    public List<PersonalList> getPersonalLists() {
        return this.personalListsService.getPersonalLists();
    }

    @GetMapping("{id}")
    public PersonalList getPersonalList(@PathVariable Long id) {
        return this.personalListsService.getPersonalListById(id);
    }

    @DeleteMapping("{id}")
    public void deletePersonalList(@PathVariable Long id) {
        this.personalListsService.deletePersonalList(id);
    }

    @PostMapping()
    public PersonalList createPersonalList(@RequestBody PersonalList personalList) {
        return this.personalListsService.createPersonalList(personalList);
    }

    @PutMapping("{id}")
    public PersonalList updatePersonalList(@PathVariable Long id, @RequestBody PersonalList personalList) {
        return this.personalListsService.updatePersonalList(id, personalList);
    }
}