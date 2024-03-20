package ua.edu.cdu.vu.database;

import ua.edu.cdu.vu.domain.User;

import java.util.Optional;

public interface Database {

    long save(User user);

    Optional<User> findById(long id);

    void update(User user);
}
