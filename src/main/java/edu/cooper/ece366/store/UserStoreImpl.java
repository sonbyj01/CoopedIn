package edu.cooper.ece366.store;

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
                    .location("New York")
                    .build(),
                new UserBuilder()
                    .id("2")
                    .name("Mary S.")
                    .location("New Jersey")
                    .build(),
                new UserBuilder()
                    .id("3")
                    .name("Louis L.")
                    .location("New York")
                    .build())
            .stream()
            .collect(Collectors.toMap(User::id, Function.identity()));
  }

  @Override
  public User get(final String id) {
    return userMap.get(id);
  }
}