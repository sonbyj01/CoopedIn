package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("io.norberg.automatter.processor.AutoMatterProcessor")
public final class UserBuilder {
  private String id;

  private String name;

  private List<String> location;

  public UserBuilder() {
  }

  private UserBuilder(User v) {
    this.id = v.id();
    this.name = v.name();
    List<String> _location = v.location();
    this.location = (_location == null) ? null : new ArrayList<String>(_location);
  }

  private UserBuilder(UserBuilder v) {
    this.id = v.id;
    this.name = v.name;
    this.location = (v.location == null) ? null : new ArrayList<String>(v.location);
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

  public List<String> location() {
    if (this.location == null) {
      this.location = new ArrayList<String>();
    }
    return location;
  }

  public UserBuilder location(List<? extends String> location) {
    return location((Collection<? extends String>) location);
  }

  public UserBuilder location(Collection<? extends String> location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    for (String item : location) {
      if (item == null) {
        throw new NullPointerException("location: null item");
      }
    }
    this.location = new ArrayList<String>(location);
    return this;
  }

  public UserBuilder location(Iterable<? extends String> location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    if (location instanceof Collection) {
      return location((Collection<? extends String>) location);
    }
    return location(location.iterator());
  }

  public UserBuilder location(Iterator<? extends String> location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    this.location = new ArrayList<String>();
    while (location.hasNext()) {
      String item = location.next();
      if (item == null) {
        throw new NullPointerException("location: null item");
      }
      this.location.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final UserBuilder location(String... location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    return location(Arrays.asList(location));
  }

  public User build() {
    List<String> _location = (location != null) ? Collections.unmodifiableList(new ArrayList<String>(location)) : Collections.<String>emptyList();
    return new Value(id, name, _location);
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

    private final List<String> location;

    private Value(@AutoMatter.Field("id") String id, @AutoMatter.Field("name") String name,
        @AutoMatter.Field("location") List<String> location) {
      if (id == null) {
        throw new NullPointerException("id");
      }
      if (name == null) {
        throw new NullPointerException("name");
      }
      this.id = id;
      this.name = name;
      this.location = (location != null) ? location : Collections.<String>emptyList();
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
    public List<String> location() {
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
