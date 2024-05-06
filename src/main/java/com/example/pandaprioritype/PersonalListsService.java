package com.example.pandaprioritype;


import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalListsService {

    private long id = 0;

    @Getter
    private List<PersonalList> personalLists = new ArrayList<>();

    public PersonalListsService() {
        this.personalLists.add(new PersonalList(this.id++, "PersonalList 1", "PersonalList 1 description",
                "16/04/2024", "High", "Important"));
        this.personalLists.add(new PersonalList(this.id++, "PersonalList 2", "PersonalList 2 description",
                "17/04/2024", "Medium", "Urgent"));
        this.personalLists.add(new PersonalList(this.id++, "PersonalList 3", "PersonalList 3 description",
                "18/04/2024", "Low", "Normal"));
    }

    public PersonalList getPersonalListById(long id) {
        for (PersonalList personalList : personalLists) {
            if (personalList.getId() == id) {
                return personalList;
            }
        }
        return null;
    }

    public void deletePersonalList(long id) {
        personalLists.removeIf(personalList -> personalList.getId() == id);
    }

    public PersonalList createPersonalList(PersonalList personalList) {
        personalList.setId(this.id++);
        this.personalLists.add(personalList);
        return personalList;
    }

    public PersonalList updatePersonalList(Long id, PersonalList updatedPersonalList) {
        PersonalList currentPersonalList = getPersonalListById(id);
        if (currentPersonalList != null) {
            currentPersonalList.toString(updatedPersonalList.getDescription());
            currentPersonalList.setDueDate(updatedPersonalList.getDueDate());
            currentPersonalList.setPriority(updatedPersonalList.getPriority());
            currentPersonalList.setLabel(updatedPersonalList.getLabel());
            return currentPersonalList;
        }
        return null;
    }
}

