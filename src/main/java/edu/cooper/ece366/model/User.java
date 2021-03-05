package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;
import java.util.List;
import java.util.Optional;

@AutoMatter
public interface User {
  String id();

  String name();

  String location();

  enum account_type {
    Company,
    Member,
    Admin
  }

}
