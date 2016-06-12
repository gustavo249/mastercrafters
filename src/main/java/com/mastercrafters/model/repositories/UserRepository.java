package com.mastercrafters.model.repositories;

import com.mastercrafters.model.accounts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gustavo on 12/06/2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
}
