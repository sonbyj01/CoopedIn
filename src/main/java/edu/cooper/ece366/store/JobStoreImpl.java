package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Job;
import edu.cooper.ece366.model.Job.Locations;
import edu.cooper.ece366.model.JobBuilder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JobStoreImpl implements JobStore {

    private static final Map<Locations, Job> jobMap;

    static {
        List<Job> jobs =
                List.of(
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .company("Adobe")
                                .jobTitle("R&D Engineer")
                                .available(true)
                                .location(Locations.NY).build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .company("Amazon")
                                .jobTitle("Mechanical Engineer")
                                .available(true)
                                .location(Locations.CT).build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .company("NYU")
                                .jobTitle("Professor")
                                .available(true)
                                .location(Locations.TX).build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .company("Aetna")
                                .jobTitle("Lawyer")
                                .available(true)
                                .location(Locations.NJ).build());
        jobMap = jobs.stream().collect(Collectors.toMap(Job::location, Function.identity()));
    }

    public JobStoreImpl() {}

    //@Override
    //public Job get(final Locations location) { return jobMap.get(location); }

    @Override
    public List<Job> getByLocation(final Locations location) {
        return jobMap.values().stream()
                .filter(jobs -> location.equals(jobs.location()))
                .collect(Collectors.toList());
    }
}
