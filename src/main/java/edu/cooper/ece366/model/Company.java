package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;

@AutoMatter
public interface Company {
    //list of Job objects?
    String id();
    String name();
}
