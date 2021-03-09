package edu.cooper.ece366.service;

import edu.cooper.ece366.model.*;
import edu.cooper.ece366.store.JobStore;

import java.util.List;
import java.util.stream.Collectors;

public class FeedServiceImpl implements FeedService {

    private final JobStore jobStore;

    public FeedServiceImpl(JobStore jobStore) { this.jobStore = jobStore; }

    @Override
    public Feed getFeedForUser(final User user) {
        List<JobPosts> jobPostings =
                user.location().stream()
                        .map(jobStore::getByLocation)
                        .filter(list -> !list.isEmpty())
                        .map(items ->
                                new JobPostsBuilder()
                                        .jobPostItems(items)
                                        .build())
                        .collect(Collectors.toList());

        return new FeedBuilder().jobPostings(jobPostings).build();
    }
    @Override
    public Feed getFeedForCompanies(final Company company){
        List<JobPosts> jobPostings =
                company.name()
                        .stream()
                        .map(jobStore::getByCompany)
                        .filter(list -> !list.isEmpty())
                        .map(items ->
                                new JobPostsBuilder()
                                        .jobPostItems(items)
                                        .build())
                        .collect(Collectors.toList());

        return new FeedBuilder().jobPostings(jobPostings).build();
    }

}
