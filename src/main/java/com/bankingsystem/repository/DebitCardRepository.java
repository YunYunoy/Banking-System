package com.bankingsystem.repository;

import com.bankingsystem.entity.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitCardRepository extends JpaRepository<DebitCard,Long> {
}
