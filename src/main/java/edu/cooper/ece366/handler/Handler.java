package edu.cooper.ece366.handler;

import edu.cooper.ece366.model.User;
import edu.cooper.ece366.store.UserStore;
import spark.Request;

public class Handler {

  private final UserStore userStore;

  public Handler(UserStore userStore) {
    this.userStore = userStore;
  }

  public User getUser(Request request) {
    String userId = request.params(":userId");
    return userStore.get(userId);
  }

}
