package com.idhit.hms.idhithealthclinicclient.repo;

import com.idhit.hms.idhithealthclinicclient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
