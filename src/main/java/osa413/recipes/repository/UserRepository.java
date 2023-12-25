package osa413.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osa413.recipes.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

}