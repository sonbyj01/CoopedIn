package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;
import javax.annotation.processing.Generated;

@Generated("io.norberg.automatter.processor.AutoMatterProcessor")
public final class JobBuilder {
  private String id;

  private boolean available;

  private String jobTitle;

  private String company;

  private String location;

  private Job.JobType jobType;

  public JobBuilder() {
  }

  private JobBuilder(Job v) {
    this.id = v.id();
    this.available = v.available();
    this.jobTitle = v.jobTitle();
    this.company = v.company();
    this.location = v.location();
    this.jobType = v.jobType();
  }

  private JobBuilder(JobBuilder v) {
    this.id = v.id;
    this.available = v.available;
    this.jobTitle = v.jobTitle;
    this.company = v.company;
    this.location = v.location;
    this.jobType = v.jobType;
  }

  public String id() {
    return id;
  }

  public JobBuilder id(String id) {
    if (id == null) {
      throw new NullPointerException("id");
    }
    this.id = id;
    return this;
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

  public String location() {
    return location;
  }

  public JobBuilder location(String location) {
    if (location == null) {
      throw new NullPointerException("location");
    }
    this.location = location;
    return this;
  }

  public Job.JobType jobType() {
    return jobType;
  }

  public JobBuilder jobType(Job.JobType jobType) {
    if (jobType == null) {
      throw new NullPointerException("jobType");
    }
    this.jobType = jobType;
    return this;
  }

  public Job build() {
    return new Value(id, available, jobTitle, company, location, jobType);
  }

  public static JobBuilder from(Job v) {
    return new JobBuilder(v);
  }

  public static JobBuilder from(JobBuilder v) {
    return new JobBuilder(v);
  }

  private static final class Value implements Job {
    private final String id;

    private final boolean available;

    private final String jobTitle;

    private final String company;

    private final String location;

    private final Job.JobType jobType;

    private Value(@AutoMatter.Field("id") String id,
        @AutoMatter.Field("available") boolean available,
        @AutoMatter.Field("jobTitle") String jobTitle, @AutoMatter.Field("company") String company,
        @AutoMatter.Field("location") String location,
        @AutoMatter.Field("jobType") Job.JobType jobType) {
      if (id == null) {
        throw new NullPointerException("id");
      }
      if (jobTitle == null) {
        throw new NullPointerException("jobTitle");
      }
      if (company == null) {
        throw new NullPointerException("company");
      }
      if (location == null) {
        throw new NullPointerException("location");
      }
      if (jobType == null) {
        throw new NullPointerException("jobType");
      }
      this.id = id;
      this.available = available;
      this.jobTitle = jobTitle;
      this.company = company;
      this.location = location;
      this.jobType = jobType;
    }

    @AutoMatter.Field
    @Override
    public String id() {
      return id;
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
    public String location() {
      return location;
    }

    @AutoMatter.Field
    @Override
    public Job.JobType jobType() {
      return jobType;
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
      if (id != null ? !id.equals(that.id()) : that.id() != null) {
        return false;
      }
      if (available != that.available()) {
        return false;
      }
      if (jobTitle != null ? !jobTitle.equals(that.jobTitle()) : that.jobTitle() != null) {
        return false;
      }
      if (company != null ? !company.equals(that.company()) : that.company() != null) {
        return false;
      }
      if (location != null ? !location.equals(that.location()) : that.location() != null) {
        return false;
      }
      if (jobType != null ? !jobType.equals(that.jobType()) : that.jobType() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
      result = 31 * result + (this.available ? 1231 : 1237);
      result = 31 * result + (this.jobTitle != null ? this.jobTitle.hashCode() : 0);
      result = 31 * result + (this.company != null ? this.company.hashCode() : 0);
      result = 31 * result + (this.location != null ? this.location.hashCode() : 0);
      result = 31 * result + (this.jobType != null ? this.jobType.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "Job{" +
      "id=" + id +
      ", available=" + available +
      ", jobTitle=" + jobTitle +
      ", company=" + company +
      ", location=" + location +
      ", jobType=" + jobType +
      '}';
    }
  }
}
