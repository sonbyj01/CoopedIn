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
public final class JobBuilder {
  private boolean available;

  private String jobTitle;

  private String company;

  private List<String> locations;

  public JobBuilder() {
  }

  private JobBuilder(Job v) {
    this.available = v.available();
    this.jobTitle = v.jobTitle();
    this.company = v.company();
    List<String> _locations = v.locations();
    this.locations = (_locations == null) ? null : new ArrayList<String>(_locations);
  }

  private JobBuilder(JobBuilder v) {
    this.available = v.available;
    this.jobTitle = v.jobTitle;
    this.company = v.company;
    this.locations = (v.locations == null) ? null : new ArrayList<String>(v.locations);
  }

  public boolean available() {
    return available;
  }

  public JobBuilder available(boolean available) {
    this.available = available;
    return this;
  }

  public String jobTitle() {
    return jobTitle;
  }

  public JobBuilder jobTitle(String jobTitle) {
    if (jobTitle == null) {
      throw new NullPointerException("jobTitle");
    }
    this.jobTitle = jobTitle;
    return this;
  }

  public String company() {
    return company;
  }

  public JobBuilder company(String company) {
    if (company == null) {
      throw new NullPointerException("company");
    }
    this.company = company;
    return this;
  }

  public List<String> locations() {
    if (this.locations == null) {
      this.locations = new ArrayList<String>();
    }
    return locations;
  }

  public JobBuilder locations(List<? extends String> locations) {
    return locations((Collection<? extends String>) locations);
  }

  public JobBuilder locations(Collection<? extends String> locations) {
    if (locations == null) {
      throw new NullPointerException("locations");
    }
    for (String item : locations) {
      if (item == null) {
        throw new NullPointerException("locations: null item");
      }
    }
    this.locations = new ArrayList<String>(locations);
    return this;
  }

  public JobBuilder locations(Iterable<? extends String> locations) {
    if (locations == null) {
      throw new NullPointerException("locations");
    }
    if (locations instanceof Collection) {
      return locations((Collection<? extends String>) locations);
    }
    return locations(locations.iterator());
  }

  public JobBuilder locations(Iterator<? extends String> locations) {
    if (locations == null) {
      throw new NullPointerException("locations");
    }
    this.locations = new ArrayList<String>();
    while (locations.hasNext()) {
      String item = locations.next();
      if (item == null) {
        throw new NullPointerException("locations: null item");
      }
      this.locations.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final JobBuilder locations(String... locations) {
    if (locations == null) {
      throw new NullPointerException("locations");
    }
    return locations(Arrays.asList(locations));
  }

  public JobBuilder addLocation(String location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    if (this.locations == null) {
      this.locations = new ArrayList<String>();
    }
    locations.add(location);
    return this;
  }

  public Job build() {
    List<String> _locations = (locations != null) ? Collections.unmodifiableList(new ArrayList<String>(locations)) : Collections.<String>emptyList();
    return new Value(available, jobTitle, company, _locations);
  }

  public static JobBuilder from(Job v) {
    return new JobBuilder(v);
  }

  public static JobBuilder from(JobBuilder v) {
    return new JobBuilder(v);
  }

  private static final class Value implements Job {
    private final boolean available;

    private final String jobTitle;

    private final String company;

    private final List<String> locations;

    private Value(@AutoMatter.Field("available") boolean available,
        @AutoMatter.Field("jobTitle") String jobTitle, @AutoMatter.Field("company") String company,
        @AutoMatter.Field("locations") List<String> locations) {
      if (jobTitle == null) {
        throw new NullPointerException("jobTitle");
      }
      if (company == null) {
        throw new NullPointerException("company");
      }
      this.available = available;
      this.jobTitle = jobTitle;
      this.company = company;
      this.locations = (locations != null) ? locations : Collections.<String>emptyList();
    }

    @AutoMatter.Field
    @Override
    public boolean available() {
      return available;
    }

    @AutoMatter.Field
    @Override
    public String jobTitle() {
      return jobTitle;
    }

    @AutoMatter.Field
    @Override
    public String company() {
      return company;
    }

    @AutoMatter.Field
    @Override
    public List<String> locations() {
      return locations;
    }

    public JobBuilder builder() {
      return new JobBuilder(this);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Job)) {
        return false;
      }
      final Job that = (Job) o;
      if (available != that.available()) {
        return false;
      }
      if (jobTitle != null ? !jobTitle.equals(that.jobTitle()) : that.jobTitle() != null) {
        return false;
      }
      if (company != null ? !company.equals(that.company()) : that.company() != null) {
        return false;
      }
      if (locations != null ? !locations.equals(that.locations()) : that.locations() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.available ? 1231 : 1237);
      result = 31 * result + (this.jobTitle != null ? this.jobTitle.hashCode() : 0);
      result = 31 * result + (this.company != null ? this.company.hashCode() : 0);
      result = 31 * result + (this.locations != null ? this.locations.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "Job{" +
      "available=" + available +
      ", jobTitle=" + jobTitle +
      ", company=" + company +
      ", locations=" + locations +
      '}';
    }
  }
}
