package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Company;
import edu.cooper.ece366.model.Job;
import edu.cooper.ece366.model.JobBuilder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JobStoreImpl implements JobStore {

    private static final Map<String, Job> jobMap;

    static {
        List<Job> jobs =
                List.of(
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .id("1")
                                .company("Adobe")
                                .jobTitle("R&D Engineer")
                                .available(true)
                                .location("NY").build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .id("2")
                                .company("Adobe")
                                .jobTitle("SW Engineer")
                                .available(true)
                                .location("NY").build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .id("3")
                                .company("Adobe")
                                .jobTitle("Marketing Manager")
                                .available(true)
                                .location("NY").build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .id("4")
                                .company("Adobe")
                                .jobTitle("SW Engineer")
                                .available(true)
                                .location("NJ").build(),
                        new JobBuilder().jobType(Job.JobType.Coop)
                                .id("5")
                                .company("Amazon")
                                .jobTitle("Mechanical Engineer")
                                .available(true)
                                .location("NJ").build(),
                        new JobBuilder().jobType(Job.JobType.PartTime)
                                .id("6")
                                .company("Amazon")
                                .jobTitle("Quality Engineer")
                                .available(true)
                                .location("NJ").build(),
                        new JobBuilder().jobType(Job.JobType.Internship)
                                .id("7")
                                .company("Amazon")
                                .jobTitle("Backend Engineer")
                                .available(true)
                                .location("NJ").build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .id("8")
                                .company("NYU")
                                .jobTitle("Professor")
                                .available(true)
                                .location("NY").build(),
                        new JobBuilder().jobType(Job.JobType.FullTime)
                                .id("9")
                                .company("Aetna")
                                .jobTitle("Lawyer")
                                .available(true)
                                .location("NJ").build());
        //Ella: Monday afternoon: change the way job is mapped to hashmap
        jobMap = jobs.stream().collect(Collectors.toMap(Job::id, Function.identity()));
    }

    public JobStoreImpl() {}

    //@Override
    //public Job get(final Locations location) { return jobMap.get(location); }

    @Override
    public List<Job> getByLocation(final String location) {
        return jobMap.values().stream()
                .filter(jobs -> location.equals(jobs.location()))
                .collect(Collectors.toList());
    }

    //this is feed for the company

    public List<Job> getByCompany(final String company) {
        return jobMap.values().stream()
                .filter(jobs -> company.equals(jobs.company()))
                .collect(Collectors.toList());
    }
}
