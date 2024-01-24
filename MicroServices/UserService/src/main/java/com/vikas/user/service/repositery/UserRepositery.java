package com.vikas.user.service.repositery;

import com.vikas.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositery extends JpaRepository<User , Long> {

    User findByUserId(Long userId);
}
