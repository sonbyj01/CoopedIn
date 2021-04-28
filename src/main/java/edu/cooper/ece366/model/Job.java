package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;

import java.util.Arrays;
import java.util.List;

@AutoMatter
public interface Job {

    // job id must be unique. Otherwise, we'll get an error when trying to hash with duplicate keys
    String id();

    // define job attributes
    boolean available();
    String jobTitle();
    String company();
    String location();

    //application deadline? not sure the specific type though, suggest data format to link to maybe a calendar to send
    //an email notice to those who haven't finished applications (saved as draft in their application cache)
    //also maybe send a notice to the company so that they can change the availability of the job?

    //job description -- a StringStream? can link this to front-end template
    List<JobType> jobType();

    enum JobType{
        Internship,
        Coop,
        FullTime,
        PartTime;

        public static JobType fromDbValue(String dbValue) {
            return Arrays.asList(JobType.values()).stream()
                    .filter(s -> dbValue.equalsIgnoreCase(s.name()))
                    .findFirst().orElseThrow();
            }
    }
}
