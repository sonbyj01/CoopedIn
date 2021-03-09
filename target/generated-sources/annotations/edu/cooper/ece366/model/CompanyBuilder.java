package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;
import javax.annotation.processing.Generated;

@Generated("io.norberg.automatter.processor.AutoMatterProcessor")
public final class CompanyBuilder {
  private String id;

  private String name;

  public CompanyBuilder() {
  }

  private CompanyBuilder(Company v) {
    this.id = v.id();
    this.name = v.name();
  }

  private CompanyBuilder(CompanyBuilder v) {
    this.id = v.id;
    this.name = v.name;
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

  public String name() {
    return name;
  }

  public CompanyBuilder name(String name) {
    if (name == null) {
      throw new NullPointerException("name");
    }
    this.name = name;
    return this;
  }

  public Company build() {
    return new Value(id, name);
  }

  public static CompanyBuilder from(Company v) {
    return new CompanyBuilder(v);
  }

  public static CompanyBuilder from(CompanyBuilder v) {
    return new CompanyBuilder(v);
  }

  private static final class Value implements Company {
    private final String id;

    private final String name;

    private Value(@AutoMatter.Field("id") String id, @AutoMatter.Field("name") String name) {
      if (id == null) {
        throw new NullPointerException("id");
      }
      if (name == null) {
        throw new NullPointerException("name");
      }
      this.id = id;
      this.name = name;
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
