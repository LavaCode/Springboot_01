package nl.kasper.springbootdemo.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import nl.kasper.springbootdemo.exception.RecordNotFoundException;

@RestController     
public class ClientsController {

    Map<Long, String> data = new HashMap<>(); 

    // constructor
    ClientsController() {
        this.data.put(1L, "Jansen");
        this.data.put(2L, "Pietersen");
        this.data.put(3L, "Kardol");
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<Object> getClients() {
        return new ResponseEntity<Object>(this.data.values(), HttpStatus.OK);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Object> getClient(@PathVariable("id") Long id) {
        if(!this.data.keySet().contains(id)){
            throw new RecordNotFoundException();
        }
            return new ResponseEntity<Object>(this.data.get(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable("id") Long id) {
        this.data.remove(id);
        return new ResponseEntity<Object>("Record deleted", HttpStatus.OK);
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<Object> addClient(@RequestBody String clientName) {
        long maxID = this.data.keySet().stream().max(Comparator.comparing(Long::valueOf)).get();
        this.data.put(maxID + 1, clientName);
        return new ResponseEntity<Object>("Record created", HttpStatus.OK);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable("id") Long id, @RequestBody String clientName) {
        this.data.put(id, clientName);
        return new ResponseEntity<Object>("Record updated", HttpStatus.OK);
    }
}
