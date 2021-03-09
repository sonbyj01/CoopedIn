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
public final class CompanyBuilder {
  private String id;

  private List<String> name;

  public CompanyBuilder() {
  }

  private CompanyBuilder(Company v) {
    this.id = v.id();
    List<String> _name = v.name();
    this.name = (_name == null) ? null : new ArrayList<String>(_name);
  }

  private CompanyBuilder(CompanyBuilder v) {
    this.id = v.id;
    this.name = (v.name == null) ? null : new ArrayList<String>(v.name);
  }

  public String id() {
    return id;
  }

  public CompanyBuilder id(String id) {
    if (id == null) {
      throw new NullPointerException("id");
    }
    this.id = id;
    return this;
  }

  public List<String> name() {
    if (this.name == null) {
      this.name = new ArrayList<String>();
    }
    return name;
  }

  public CompanyBuilder name(List<? extends String> name) {
    return name((Collection<? extends String>) name);
  }

  public CompanyBuilder name(Collection<? extends String> name) {
    if (name == null) {
      throw new NullPointerException("name");
    }
    for (String item : name) {
      if (item == null) {
        throw new NullPointerException("name: null item");
      }
    }
    this.name = new ArrayList<String>(name);
    return this;
  }

  public CompanyBuilder name(Iterable<? extends String> name) {
    if (name == null) {
      throw new NullPointerException("name");
    }
    if (name instanceof Collection) {
      return name((Collection<? extends String>) name);
    }
    return name(name.iterator());
  }

  public CompanyBuilder name(Iterator<? extends String> name) {
    if (name == null) {
      throw new NullPointerException("name");
    }
    this.name = new ArrayList<String>();
    while (name.hasNext()) {
      String item = name.next();
      if (item == null) {
        throw new NullPointerException("name: null item");
      }
      this.name.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final CompanyBuilder name(String... name) {
    if (name == null) {
      throw new NullPointerException("name");
    }
    return name(Arrays.asList(name));
  }

  public Company build() {
    List<String> _name = (name != null) ? Collections.unmodifiableList(new ArrayList<String>(name)) : Collections.<String>emptyList();
    return new Value(id, _name);
  }

  public static CompanyBuilder from(Company v) {
    return new CompanyBuilder(v);
  }

  public static CompanyBuilder from(CompanyBuilder v) {
    return new CompanyBuilder(v);
  }

  private static final class Value implements Company {
    private final String id;

    private final List<String> name;

    private Value(@AutoMatter.Field("id") String id, @AutoMatter.Field("name") List<String> name) {
      if (id == null) {
        throw new NullPointerException("id");
      }
      this.id = id;
      this.name = (name != null) ? name : Collections.<String>emptyList();
    }

    @AutoMatter.Field
    @Override
    public String id() {
      return id;
    }

    @AutoMatter.Field
    @Override
    public List<String> name() {
      return name;
    }

    public CompanyBuilder builder() {
      return new CompanyBuilder(this);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Company)) {
        return false;
      }
      final Company that = (Company) o;
      if (id != null ? !id.equals(that.id()) : that.id() != null) {
        return false;
      }
      if (name != null ? !name.equals(that.name()) : that.name() != null) {
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
      return result;
    }

    @Override
    public String toString() {
      return "Company{" +
      "id=" + id +
      ", name=" + name +
      '}';
    }
  }
}
