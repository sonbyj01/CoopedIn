package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Company;
import edu.cooper.ece366.model.Job;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class CompanyStorePostgres implements CompanyStore {

    private final Jdbi jdbi;

    public CompanyStorePostgres(final Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public Company get(String id) {
        return (Company) jdbi.withHandle(handle -> handle.attach(CompanyDao.class).get(id));
    }

}
