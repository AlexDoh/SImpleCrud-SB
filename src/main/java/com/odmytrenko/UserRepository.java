package com.odmytrenko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);
}