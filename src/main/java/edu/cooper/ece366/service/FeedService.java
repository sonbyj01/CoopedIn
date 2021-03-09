package edu.cooper.ece366.service;

import edu.cooper.ece366.model.Company;
import edu.cooper.ece366.model.Feed;
import edu.cooper.ece366.model.User;

public interface FeedService {

    Feed getFeedForUser(User user);
    //Ella: feed jobs to company so that they can manage the jobs belong to them
    Feed getFeedForCompanies(Company company);
}
