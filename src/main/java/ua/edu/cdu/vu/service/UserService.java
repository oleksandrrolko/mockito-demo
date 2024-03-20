package ua.edu.cdu.vu.service;

import ua.edu.cdu.vu.database.Database;
import ua.edu.cdu.vu.domain.User;

import static java.util.Objects.isNull;

public class UserService {

    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public long create(User user) {
        return database.save(user);
    }

    public User getById(long id) {
        return database.findById(id).orElseThrow();
    }

    public void update(User user) {
        if (isNull(user.getId())) {
            throw new IllegalArgumentException("User id is required");
        }

        var userById = database.findById(user.getId());
        if (userById.isEmpty()) {
            database.save(user);
        }

        database.update(user);
    }
}
