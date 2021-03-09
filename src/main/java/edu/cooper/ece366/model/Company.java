package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;

import java.util.List;

@AutoMatter
public interface Company {
    //list of Job objects?
    String id();
    List<String> name();
}
