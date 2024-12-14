package com.anilkumawat.quiz.repositories;

import com.anilkumawat.quiz.entities.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession,Long> {
}
