package edu.cooper.ece366.model;

import io.norberg.automatter.AutoMatter;

import java.util.List;
@AutoMatter
public interface Job {
    boolean available();
    String jobTitle();
    String company();
    List<String> locations();
    //application deadline? not sure the specific type though, suggest data format to link to maybe a calendar to send
    //an email notice to those who haven't finished applications (saved as draft in their application cache)
    //also maybe send a notice to the company so that they can change the availability of the job?

    //job description -- a StringStream? can link this to front-end template


    enum jobType{
        Internship,
        Coop,
        FullTime,
        PartTime,
        SummerInternship
    }

}
