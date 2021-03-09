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
public final class JobPostsBuilder {
  private List<Job> jobPostItems;

  public JobPostsBuilder() {
  }

  private JobPostsBuilder(JobPosts v) {
    List<Job> _jobPostItems = v.jobPostItems();
    this.jobPostItems = (_jobPostItems == null) ? null : new ArrayList<Job>(_jobPostItems);
  }

  private JobPostsBuilder(JobPostsBuilder v) {
    this.jobPostItems = (v.jobPostItems == null) ? null : new ArrayList<Job>(v.jobPostItems);
  }

  public List<Job> jobPostItems() {
    if (this.jobPostItems == null) {
      this.jobPostItems = new ArrayList<Job>();
    }
    return jobPostItems;
  }

  public JobPostsBuilder jobPostItems(List<? extends Job> jobPostItems) {
    return jobPostItems((Collection<? extends Job>) jobPostItems);
  }

  public JobPostsBuilder jobPostItems(Collection<? extends Job> jobPostItems) {
    if (jobPostItems == null) {
      throw new NullPointerException("jobPostItems");
    }
    for (Job item : jobPostItems) {
      if (item == null) {
        throw new NullPointerException("jobPostItems: null item");
      }
    }
    this.jobPostItems = new ArrayList<Job>(jobPostItems);
    return this;
  }

  public JobPostsBuilder jobPostItems(Iterable<? extends Job> jobPostItems) {
    if (jobPostItems == null) {
      throw new NullPointerException("jobPostItems");
    }
    if (jobPostItems instanceof Collection) {
      return jobPostItems((Collection<? extends Job>) jobPostItems);
    }
    return jobPostItems(jobPostItems.iterator());
  }

  public JobPostsBuilder jobPostItems(Iterator<? extends Job> jobPostItems) {
    if (jobPostItems == null) {
      throw new NullPointerException("jobPostItems");
    }
    this.jobPostItems = new ArrayList<Job>();
    while (jobPostItems.hasNext()) {
      Job item = jobPostItems.next();
      if (item == null) {
        throw new NullPointerException("jobPostItems: null item");
      }
      this.jobPostItems.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final JobPostsBuilder jobPostItems(Job... jobPostItems) {
    if (jobPostItems == null) {
      throw new NullPointerException("jobPostItems");
    }
    return jobPostItems(Arrays.asList(jobPostItems));
  }

  public JobPostsBuilder addJobPostItem(Job jobPostItem) {
    if (jobPostItem == null) {
      throw new NullPointerException("jobPostItem");
    }
    if (this.jobPostItems == null) {
      this.jobPostItems = new ArrayList<Job>();
    }
    jobPostItems.add(jobPostItem);
    return this;
  }

  public JobPosts build() {
    List<Job> _jobPostItems = (jobPostItems != null) ? Collections.unmodifiableList(new ArrayList<Job>(jobPostItems)) : Collections.<Job>emptyList();
    return new Value(_jobPostItems);
  }

  public static JobPostsBuilder from(JobPosts v) {
    return new JobPostsBuilder(v);
  }

  public static JobPostsBuilder from(JobPostsBuilder v) {
    return new JobPostsBuilder(v);
  }

  private static final class Value implements JobPosts {
    private final List<Job> jobPostItems;

    private Value(@AutoMatter.Field("jobPostItems") List<Job> jobPostItems) {
      this.jobPostItems = (jobPostItems != null) ? jobPostItems : Collections.<Job>emptyList();
    }

    @AutoMatter.Field
    @Override
    public List<Job> jobPostItems() {
      return jobPostItems;
    }

    public JobPostsBuilder builder() {
      return new JobPostsBuilder(this);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof JobPosts)) {
        return false;
      }
      final JobPosts that = (JobPosts) o;
      if (jobPostItems != null ? !jobPostItems.equals(that.jobPostItems()) : that.jobPostItems() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.jobPostItems != null ? this.jobPostItems.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "JobPosts{" +
      "jobPostItems=" + jobPostItems +
      '}';
    }
  }
}
