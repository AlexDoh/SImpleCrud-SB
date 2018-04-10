package com.odmytrenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/users")
class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public Collection<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        if (!repository.existsByName(user.getName())) {
            return repository.save(user);
        } else {
            return user;
        }
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        if (repository.existsById(id)) {
            User existUser = repository.findById(id).get();
            user.setId(existUser.getId());
            return repository.save(user);
        } else {
            return user;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}