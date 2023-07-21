package com.heritage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heritage.entity.UserProject;

@Repository
public interface AchievementRepository extends JpaRepository<UserProject, Long> {
UserProject findByName(String name);
}
