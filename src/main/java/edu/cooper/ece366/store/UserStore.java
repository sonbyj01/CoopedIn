package edu.cooper.ece366.store;

import edu.cooper.ece366.model.User;

public interface UserStore {

  User get(String id);
  boolean add(String id, String name, String location);
}
