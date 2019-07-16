package com.wildcodeschool.checkpoint4.Repository;

import com.wildcodeschool.checkpoint4.Entity.Circus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircusRepository extends JpaRepository<Circus, Long> {
}
