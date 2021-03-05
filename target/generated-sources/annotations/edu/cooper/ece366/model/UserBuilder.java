package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;
import javax.annotation.processing.Generated;

@Generated("io.norberg.automatter.processor.AutoMatterProcessor")
public final class UserBuilder {
  private String id;

  private String name;

  private String location;

  public UserBuilder() {
  }

  private UserBuilder(User v) {
    this.id = v.id();
    this.name = v.name();
    this.location = v.location();
  }

  private UserBuilder(UserBuilder v) {
    this.id = v.id;
    this.name = v.name;
    this.location = v.location;
  }

  public String id() {
    return id;
  }

  public UserBuilder id(String id) {
    if (id == null) {
      throw new NullPointerException("id");
    }
    this.id = id;
    return this;
  }

  public String name() {
    return name;
  }

  public UserBuilder name(String name) {
    if (name == null) {
      throw new NullPointerException("name");
    }
    this.name = name;
    return this;
  }

  public String location() {
    return location;
  }

  public UserBuilder location(String location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    this.location = location;
    return this;
  }

  public User build() {
    return new Value(id, name, location);
  }

  public static UserBuilder from(User v) {
    return new UserBuilder(v);
  }

  public static UserBuilder from(UserBuilder v) {
    return new UserBuilder(v);
  }

  private static final class Value implements User {
    private final String id;

    private final String name;

    private final String location;

    private Value(@AutoMatter.Field("id") String id, @AutoMatter.Field("name") String name,
        @AutoMatter.Field("location") String location) {
      if (id == null) {
        throw new NullPointerException("id");
      }
      if (name == null) {
        throw new NullPointerException("name");
      }
      if (location == null) {
        throw new NullPointerException("location");
      }
      this.id = id;
      this.name = name;
      this.location = location;
    }

    @AutoMatter.Field
    @Override
    public String id() {
      return id;
    }

    @AutoMatter.Field
    @Override
    public String name() {
      return name;
    }

    @AutoMatter.Field
    @Override
    public String location() {
      return location;
    }

    public UserBuilder builder() {
      return new UserBuilder(this);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof User)) {
        return false;
      }
      final User that = (User) o;
      if (id != null ? !id.equals(that.id()) : that.id() != null) {
        return false;
      }
      if (name != null ? !name.equals(that.name()) : that.name() != null) {
        return false;
      }
      if (location != null ? !location.equals(that.location()) : that.location() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
      result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
      result = 31 * result + (this.location != null ? this.location.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "User{" +
      "id=" + id +
      ", name=" + name +
      ", location=" + location +
      '}';
    }
  }
}
