package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Company;
import edu.cooper.ece366.model.Job;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class CompanyStorePostgres implements CompanyStore {

    // for testing
    public static void main(String[] args) {
        //UserStorePostgres userStorePostgres = new UserStorePostgres(
                //CoopedInJdbi.create("jdbc:postgresql://localhost:5432/c0mpany"));

        CompanyStorePostgres jobStorePostgres = new CompanyStorePostgres(
                CoopedInJdbi.create("jdbc:postgresql://localhost:5432/c0mpany"));

        String company_name = "Adobe";
        String company_id = "C1";
        String location = "NY";
        try {
            //List<Job> job = jobStorePostgres.getByCompany(company);
            //List<Job> job = jobStorePostgres.getByLocation(location);
            //Company company = CompanyStorePostgres.get(company_id);
            System.out.println("success");
            //System.out.println(company);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not fetch job");
        }

    }

    private final Jdbi jdbi;

    public CompanyStorePostgres(final Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public Company get(String id) {
        return (Company) jdbi.withHandle(handle -> handle.attach(CompanyDao.class).get(id));
    }

}
