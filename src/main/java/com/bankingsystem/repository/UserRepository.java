package com.bankingsystem.repository;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {
}
