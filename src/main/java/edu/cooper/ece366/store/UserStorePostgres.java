package edu.cooper.ece366.store;

import edu.cooper.ece366.model.User;
import org.jdbi.v3.core.Jdbi;

public class UserStorePostgres implements UserStore {

    // for testing
    public static void main(String[] args) {
        UserStorePostgres userStorePostgres = new UserStorePostgres(CoopedInJdbi.create("jdbc:postgresql://localhost:5432/c0mpany"));
        String userId = "1";
        User user = userStorePostgres.get(userId);
        System.out.println(user);
    }
    private final Jdbi jdbi;

    public UserStorePostgres (final Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public User get(String id) {
        return jdbi.withHandle(handle -> handle.attach(UserDao.class).getUser(id));
    }
}
