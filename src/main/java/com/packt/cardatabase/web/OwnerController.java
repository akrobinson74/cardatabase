package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
    private final OwnerRepository ownerRepository;
    
    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    
    @GetMapping("/owners")
    public Iterable<Owner> getOwners() {
        return ownerRepository.findAll();
    }
    
    @PostMapping("/owners")
    public Owner addOwner(@RequestBody Owner newOwner) {
        return ownerRepository.save(newOwner);
    }
    
    @GetMapping("/owners/{id}")
    public Owner getOwner(@PathVariable Long id) {
        return ownerRepository.findById(id).orElse(null);
    }
}
