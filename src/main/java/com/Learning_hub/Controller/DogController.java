package com.Learning_hub.Controller;

import com.Learning_hub.Entity.EntityControllerForDogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(("/dog"))
public class DogController {

    private Map<Long , EntityControllerForDogs> dogDetails  = new HashMap<>();

    @GetMapping
    public List<EntityControllerForDogs> GetAll() {
        return new ArrayList<>(dogDetails.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody EntityControllerForDogs entriesOfDog ){
        dogDetails.put(entriesOfDog.getId(),entriesOfDog);
        return true;
    }
    @GetMapping("id/{UserId}")
    public EntityControllerForDogs createEntry(@PathVariable Long UserId ){
       return  dogDetails.get(UserId);
    }
    @DeleteMapping("id/{UserId}")
    public EntityControllerForDogs DeleteEntry(@PathVariable Long UserId ){

        return dogDetails.remove(UserId);
    }
    @PutMapping("id/{UserId}")
    public EntityControllerForDogs DeleteEntry(@PathVariable Long UserId, @RequestBody EntityControllerForDogs Entries ){

        return dogDetails.put(UserId,Entries);
    }

}
