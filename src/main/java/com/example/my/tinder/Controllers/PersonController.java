package com.example.my.tinder.Controllers;

import com.example.my.tinder.model.Gender;
import com.example.my.tinder.model.PersonRepository;
import com.example.my.tinder.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.example.my.tinder.model.Gender.FEMALE;
import static com.example.my.tinder.model.Gender.MALE;
import static com.example.my.tinder.model.Gender.OUTOFGENDER;

@Controller
public class PersonController {

    public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    final PersonRepository personRepository;
    private List<Person> people;
    private Gender gender;
    private Person person;

    PersonController(final PersonRepository personRepository) {
        this.personRepository = personRepository;
        people = personRepository.findAllPeople();
    }

    /*
        public static void main(String[] args) {
            PersonRepository personRepository = new PersonRepository();
            System.out.println(personRepository.findByAge(20,30));
        }*/
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        List<Gender> listOfGender = Arrays.asList(FEMALE, MALE, OUTOFGENDER);
        model.addAttribute("listOfGender", listOfGender);
        return "register_form";
    }
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("person") Person person) {
        System.out.println(person);
        return "register_success";
    }

    @GetMapping("/peoples")
    public String viewPeople(Model model){
        model.addAttribute("people", personRepository.findAllPeople());
        System.out.println(people.toString());
        return "peoples";
    }


    @GetMapping(value = "/example")
    String readAllPersons(Model model) {
        logger.warn("Explosing all the Persons");
        List<Person> people = personRepository.findAllPeople();
        System.out.println(people.toString());
        model.addAttribute("people",people);
        return "example";
    }
    @GetMapping(value = "/person/age")
    List<Person> readPersonsByAge(@Param("from") int from, @Param("to") int to) {
        logger.info("Explosing  Persons  according to sorts by age");
        return personRepository.findByAge(from, to);
    }

    @GetMapping(value = "/person/id")
    List<Person> readPersonsById(@Param("id") int id) {
        logger.info("Explosing  Persons  according to id");
        return personRepository.findById(id);
    }

}