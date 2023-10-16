package com.example.demo.controller;

// src/main/java/com/example/demo/controller/LoadController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Load;
import com.example.demo.repository.LoadRepository;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @PostMapping
    public String addLoad(@RequestBody Load load) {
        Load savedLoad = loadRepository.save(load);
        return "Load details added successfully with ID: " + savedLoad.id;
    }

    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public Load getLoad(@PathVariable Long loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    @PutMapping("/{loadId}")
    public void updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
        Load load = loadRepository.findById(loadId).orElse(null);
        if (load != null) {
            // Update load properties
            loadRepository.save(load);
        }
    }

    @DeleteMapping("/{loadId}")
    public String deleteLoad(@PathVariable Long loadId) {
        if (loadRepository.existsById(loadId)) {
            loadRepository.deleteById(loadId);
            return "Load with ID " + loadId + " deleted successfully";
        } else {
            return "Load with ID " + loadId + " not found";
        }
    }
}
