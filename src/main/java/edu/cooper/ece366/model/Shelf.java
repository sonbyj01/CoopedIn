package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;

import java.util.List;

@AutoMatter
public interface Shelf {

    List<Job> shelfItems();
}
