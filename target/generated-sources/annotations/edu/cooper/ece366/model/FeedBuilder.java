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
  private List<Shelf> shelves;

  public FeedBuilder() {
  }

  private FeedBuilder(Feed v) {
    List<Shelf> _shelves = v.shelves();
    this.shelves = (_shelves == null) ? null : new ArrayList<Shelf>(_shelves);
  }

  private FeedBuilder(FeedBuilder v) {
    this.shelves = (v.shelves == null) ? null : new ArrayList<Shelf>(v.shelves);
  }

  public List<Shelf> shelves() {
    if (this.shelves == null) {
      this.shelves = new ArrayList<Shelf>();
    }
    return shelves;
  }

  public FeedBuilder shelves(List<? extends Shelf> shelves) {
    return shelves((Collection<? extends Shelf>) shelves);
  }

  public FeedBuilder shelves(Collection<? extends Shelf> shelves) {
    if (shelves == null) {
      throw new NullPointerException("shelves");
    }
    for (Shelf item : shelves) {
      if (item == null) {
        throw new NullPointerException("shelves: null item");
      }
    }
    this.shelves = new ArrayList<Shelf>(shelves);
    return this;
  }

  public FeedBuilder shelves(Iterable<? extends Shelf> shelves) {
    if (shelves == null) {
      throw new NullPointerException("shelves");
    }
    if (shelves instanceof Collection) {
      return shelves((Collection<? extends Shelf>) shelves);
    }
    return shelves(shelves.iterator());
  }

  public FeedBuilder shelves(Iterator<? extends Shelf> shelves) {
    if (shelves == null) {
      throw new NullPointerException("shelves");
    }
    this.shelves = new ArrayList<Shelf>();
    while (shelves.hasNext()) {
      Shelf item = shelves.next();
      if (item == null) {
        throw new NullPointerException("shelves: null item");
      }
      this.shelves.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final FeedBuilder shelves(Shelf... shelves) {
    if (shelves == null) {
      throw new NullPointerException("shelves");
    }
    return shelves(Arrays.asList(shelves));
  }

  public FeedBuilder addShelf(Shelf shelf) {
    if (shelf == null) {
      throw new NullPointerException("shelf");
    }
    if (this.shelves == null) {
      this.shelves = new ArrayList<Shelf>();
    }
    shelves.add(shelf);
    return this;
  }

  public Feed build() {
    List<Shelf> _shelves = (shelves != null) ? Collections.unmodifiableList(new ArrayList<Shelf>(shelves)) : Collections.<Shelf>emptyList();
    return new Value(_shelves);
  }

  public static FeedBuilder from(Feed v) {
    return new FeedBuilder(v);
  }

  public static FeedBuilder from(FeedBuilder v) {
    return new FeedBuilder(v);
  }

  private static final class Value implements Feed {
    private final List<Shelf> shelves;

    private Value(@AutoMatter.Field("shelves") List<Shelf> shelves) {
      this.shelves = (shelves != null) ? shelves : Collections.<Shelf>emptyList();
    }

    @AutoMatter.Field
    @Override
    public List<Shelf> shelves() {
      return shelves;
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
      if (shelves != null ? !shelves.equals(that.shelves()) : that.shelves() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.shelves != null ? this.shelves.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "Feed{" +
      "shelves=" + shelves +
      '}';
    }
  }
}
