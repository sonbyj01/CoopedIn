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
public final class ShelfBuilder {
  private List<Job> shelfItems;

  public ShelfBuilder() {
  }

  private ShelfBuilder(Shelf v) {
    List<Job> _shelfItems = v.shelfItems();
    this.shelfItems = (_shelfItems == null) ? null : new ArrayList<Job>(_shelfItems);
  }

  private ShelfBuilder(ShelfBuilder v) {
    this.shelfItems = (v.shelfItems == null) ? null : new ArrayList<Job>(v.shelfItems);
  }

  public List<Job> shelfItems() {
    if (this.shelfItems == null) {
      this.shelfItems = new ArrayList<Job>();
    }
    return shelfItems;
  }

  public ShelfBuilder shelfItems(List<? extends Job> shelfItems) {
    return shelfItems((Collection<? extends Job>) shelfItems);
  }

  public ShelfBuilder shelfItems(Collection<? extends Job> shelfItems) {
    if (shelfItems == null) {
      throw new NullPointerException("shelfItems");
    }
    for (Job item : shelfItems) {
      if (item == null) {
        throw new NullPointerException("shelfItems: null item");
      }
    }
    this.shelfItems = new ArrayList<Job>(shelfItems);
    return this;
  }

  public ShelfBuilder shelfItems(Iterable<? extends Job> shelfItems) {
    if (shelfItems == null) {
      throw new NullPointerException("shelfItems");
    }
    if (shelfItems instanceof Collection) {
      return shelfItems((Collection<? extends Job>) shelfItems);
    }
    return shelfItems(shelfItems.iterator());
  }

  public ShelfBuilder shelfItems(Iterator<? extends Job> shelfItems) {
    if (shelfItems == null) {
      throw new NullPointerException("shelfItems");
    }
    this.shelfItems = new ArrayList<Job>();
    while (shelfItems.hasNext()) {
      Job item = shelfItems.next();
      if (item == null) {
        throw new NullPointerException("shelfItems: null item");
      }
      this.shelfItems.add(item);
    }
    return this;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public final ShelfBuilder shelfItems(Job... shelfItems) {
    if (shelfItems == null) {
      throw new NullPointerException("shelfItems");
    }
    return shelfItems(Arrays.asList(shelfItems));
  }

  public ShelfBuilder addShelfItem(Job shelfItem) {
    if (shelfItem == null) {
      throw new NullPointerException("shelfItem");
    }
    if (this.shelfItems == null) {
      this.shelfItems = new ArrayList<Job>();
    }
    shelfItems.add(shelfItem);
    return this;
  }

  public Shelf build() {
    List<Job> _shelfItems = (shelfItems != null) ? Collections.unmodifiableList(new ArrayList<Job>(shelfItems)) : Collections.<Job>emptyList();
    return new Value(_shelfItems);
  }

  public static ShelfBuilder from(Shelf v) {
    return new ShelfBuilder(v);
  }

  public static ShelfBuilder from(ShelfBuilder v) {
    return new ShelfBuilder(v);
  }

  private static final class Value implements Shelf {
    private final List<Job> shelfItems;

    private Value(@AutoMatter.Field("shelfItems") List<Job> shelfItems) {
      this.shelfItems = (shelfItems != null) ? shelfItems : Collections.<Job>emptyList();
    }

    @AutoMatter.Field
    @Override
    public List<Job> shelfItems() {
      return shelfItems;
    }

    public ShelfBuilder builder() {
      return new ShelfBuilder(this);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Shelf)) {
        return false;
      }
      final Shelf that = (Shelf) o;
      if (shelfItems != null ? !shelfItems.equals(that.shelfItems()) : that.shelfItems() != null) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      long temp;
      result = 31 * result + (this.shelfItems != null ? this.shelfItems.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "Shelf{" +
      "shelfItems=" + shelfItems +
      '}';
    }
  }
}
