package edu.cooper.ece366.store;

import edu.cooper.ece366.model.User;
import org.jdbi.v3.core.Jdbi;

public class UserStorePostgres implements UserStore {


    // for testing
    public static void main(String[] args) {
        UserStorePostgres userStorePostgres = new UserStorePostgres(
                CoopedInJdbi.create("jdbc:postgresql://localhost:5432/c0mpany"));

        String userId = "1";
        try {
            User user = userStorePostgres.get(userId);
            System.out.println("success");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not fetch user");
        }
    }

    private final Jdbi jdbi;

    public UserStorePostgres (final Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public User get(String id) {
        return jdbi.withHandle(handle -> handle.attach(UserDao.class).getUser(id));
    }

    @Override
    public boolean add(String id, String name, String location) {
        try {jdbi.useHandle(
                handle -> {
                    handle.attach(UserDao.class).insertUser(id, name, location);
                });
            return true;} catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



}
