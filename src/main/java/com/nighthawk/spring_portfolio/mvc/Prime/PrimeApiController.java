package com.nighthawk.spring_portfolio.mvc.Prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/prime")  // all requests in file begin with this URI
public class PrimeApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private PrimeJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Prime>> getPrime() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @PostMapping("/like/{id}")
    public ResponseEntity<Prime> setLike(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Prime> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Prime prime = optional.get();  // value from findByID
            prime.setLike(prime.getLike()+1); // increment value
            repository.save(prime);  // save entity
            return new ResponseEntity<>(prime, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    /* Update Jeer
     */
    @PostMapping("/dislike/{id}")
    public ResponseEntity<Prime> setDislike(@PathVariable long id) {
        Optional<Prime> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Prime prime = optional.get();
            prime.setDislike(prime.getDislike()+1);
            repository.save(prime);
            return new ResponseEntity<>(prime, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
