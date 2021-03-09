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
public final class FeedBuilder {
  private List<JobPosts> jobPostings;

  public FeedBuilder() {
  }

  private FeedBuilder(Feed v) {
    List<JobPosts> _jobPostings = v.jobPostings();
    this.jobPostings = (_jobPostings == null) ? null : new ArrayList<JobPosts>(_jobPostings);
  }

  private FeedBuilder(FeedBuilder v) {
    this.jobPostings = (v.jobPostings == null) ? null : new ArrayList<JobPosts>(v.jobPostings);
  }

  public List<JobPosts> jobPostings() {
    if (this.jobPostings == null) {
      this.jobPostings = new ArrayList<JobPosts>();
    }
    return jobPostings;
  }

  public FeedBuilder jobPostings(List<? extends JobPosts> jobPostings) {
    return jobPostings((Collection<? extends JobPosts>) jobPostings);
  }

  public FeedBuilder jobPostings(Collection<? extends JobPosts> jobPostings) {
    if (jobPostings == null) {
      throw new NullPointerException("jobPostings");
    }
    for (JobPosts item : jobPostings) {
      if (item == null) {
        throw new NullPointerException("jobPostings: null item");
      }
    }
    this.jobPostings = new ArrayList<JobPosts>(jobPostings);
    return this;
  }

  public FeedBuilder jobPostings(Iterable<? extends JobPosts> jobPostings) {
    if (jobPostings == null) {
      throw new NullPointerException("jobPostings");
    }
    if (jobPostings instanceof Collection) {
      return jobPostings((Collection<? extends JobPosts>) jobPostings);
    }
    return jobPostings(jobPostings.iterator());
  }

  public FeedBuilder jobPostings(Iterator<? extends JobPosts> jobPostings) {
    if (jobPostings == null) {
      throw new NullPointerException("jobPostings");
    }
    this.jobPostings = new ArrayList<JobPosts>();
    while (jobPostings.hasNext()) {
      JobPosts item = jobPostings.next();
      if (item == null) {
        throw new NullPointerException("jobPostings: null item");
      }
      this.jobPostings.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final FeedBuilder jobPostings(JobPosts... jobPostings) {
    if (jobPostings == null) {
      throw new NullPointerException("jobPostings");
    }
    return jobPostings(Arrays.asList(jobPostings));
  }

  public FeedBuilder addJobPosting(JobPosts jobPosting) {
    if (jobPosting == null) {
      throw new NullPointerException("jobPosting");
    }
    if (this.jobPostings == null) {
      this.jobPostings = new ArrayList<JobPosts>();
    }
    jobPostings.add(jobPosting);
    return this;
  }

  public Feed build() {
    List<JobPosts> _jobPostings = (jobPostings != null) ? Collections.unmodifiableList(new ArrayList<JobPosts>(jobPostings)) : Collections.<JobPosts>emptyList();
    return new Value(_jobPostings);
  }

  public static FeedBuilder from(Feed v) {
    return new FeedBuilder(v);
  }

  public static FeedBuilder from(FeedBuilder v) {
    return new FeedBuilder(v);
  }

  private static final class Value implements Feed {
    private final List<JobPosts> jobPostings;

    private Value(@AutoMatter.Field("jobPostings") List<JobPosts> jobPostings) {
      this.jobPostings = (jobPostings != null) ? jobPostings : Collections.<JobPosts>emptyList();
    }

    @AutoMatter.Field
    @Override
    public List<JobPosts> jobPostings() {
      return jobPostings;
    }

    public FeedBuilder builder() {
      return new FeedBuilder(this);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Feed)) {
        return false;
      }
      final Feed that = (Feed) o;
      if (jobPostings != null ? !jobPostings.equals(that.jobPostings()) : that.jobPostings() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.jobPostings != null ? this.jobPostings.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "Feed{" +
      "jobPostings=" + jobPostings +
      '}';
    }
  }
}
