package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Job;
import edu.cooper.ece366.model.User;
import edu.cooper.ece366.model.UserBuilder;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserStoreImpl implements UserStore {
  private static final Map<String, User> userMap;

  static {
    userMap =
        List.of(
                new UserBuilder()
                    .id("1")
                    .name("John S.")
                    .location("NY")
                    .build(),
                new UserBuilder()
                    .id("2")
                    .name("Mary S.")
                    .location("NJ")
                    .build(),
                new UserBuilder()
                    .id("3")
                    .name("Louis L.")
                    .location("NY")
                    .build(),
                new UserBuilder()
                    .id("4")
                    .name("SpongeBob")
                    .location("NJ")
                    .build(),
                new UserBuilder()
                    .id("5")
                    .name("Jerry")
                    .location("NY")
                    .build())
            .stream()
            .collect(Collectors.toMap(User::id, Function.identity()));
  }

  @Override
  public User get(final String id) {
    return userMap.get(id);
  }

  public static void addUser(final String id, final String name, final String location) {
    // create new user
    User newUser = new UserBuilder().id(id).name(name).location(location).build();

    // store new user
    userMap.put(id, newUser);
  }

}
