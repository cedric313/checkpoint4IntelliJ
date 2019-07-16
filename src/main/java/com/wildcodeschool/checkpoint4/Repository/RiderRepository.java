package com.wildcodeschool.checkpoint4.Repository;

import com.wildcodeschool.checkpoint4.Entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
