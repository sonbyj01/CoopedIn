package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Company;


public interface CompanyStore {
    Company get(String id);
}
