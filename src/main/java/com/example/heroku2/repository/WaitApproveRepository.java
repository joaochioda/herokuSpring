package com.example.heroku2.repository;

import com.example.heroku2.model.WaitApprove;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitApproveRepository extends JpaRepository<WaitApprove,Long> {
}
