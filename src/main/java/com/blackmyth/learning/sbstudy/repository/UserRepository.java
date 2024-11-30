package com.blackmyth.learning.sbstudy.repository;

import com.blackmyth.learning.sbstudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
