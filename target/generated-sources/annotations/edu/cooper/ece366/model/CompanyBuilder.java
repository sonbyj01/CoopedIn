package edu.cooper.ece366.model;

import javax.annotation.processing.Generated;

@Generated("io.norberg.automatter.processor.AutoMatterProcessor")
public final class CompanyBuilder {
  public CompanyBuilder() {
  }

  private CompanyBuilder(Company v) {
  }

  private CompanyBuilder(CompanyBuilder v) {
  }

  public Company build() {
    return new Value();
  }

  public static CompanyBuilder from(Company v) {
    return new CompanyBuilder(v);
  }

  public static CompanyBuilder from(CompanyBuilder v) {
    return new CompanyBuilder(v);
  }

  private static final class Value implements Company {
    private Value() {
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
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      return result;
    }

    @Override
    public String toString() {
      return "Company{" +
      '}';
    }
  }
}
