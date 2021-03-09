package edu.cooper.ece366.service;

import edu.cooper.ece366.model.Feed;
import edu.cooper.ece366.model.User;

public interface FeedService {

    Feed getFeedForUser(User user);
}
