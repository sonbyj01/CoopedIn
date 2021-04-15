package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Job;
import edu.cooper.ece366.model.User;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class JobStorePostgres implements JobStore {

    // for testing
    public static void main(String[] args) {
        //UserStorePostgres userStorePostgres = new UserStorePostgres(
                //CoopedInJdbi.create("jdbc:postgresql://localhost:5432/c0mpany"));

        JobStorePostgres jobStorePostgres = new JobStorePostgres(
                CoopedInJdbi.create("jdbc:postgresql://localhost:5432/c0mpany"));

        String company = "Adobe";
        try {
            List<Job> job = jobStorePostgres.getByCompany(company);
            System.out.println("success");
            System.out.println(job);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not fetch job");
        }

    }

    private final Jdbi jdbi;

    public JobStorePostgres (final Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<Job> getByCompany(String company) {
        return (List<Job>) jdbi.withHandle(handle -> handle.attach(JobDao.class).getByCompany(company));
    }

    @Override
    public List<Job> getByLocation(String location) {
        return null;
    }

    /*
    @Override
    public boolean add(String id, String name, String location) {
        try {jdbi.useHandle(
                handle -> {
                    handle.attach(UserDao.class).insertUser(id, name, location);
                });
            return true;} catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }*/
}
