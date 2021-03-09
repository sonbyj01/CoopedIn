package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Company;
import edu.cooper.ece366.model.CompanyBuilder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompanyStoreImpl implements CompanyStore{
    private static final Map<String, Company> companyMap;
    static {
        companyMap =
                List.of(
                        new CompanyBuilder()
                            .id("C1")
                            .name("Adobe")
                            .build(),
                        new CompanyBuilder()
                            .id("C2")
                            .name("Amazon")
                            .build(),
                        new CompanyBuilder()
                                .id("C3")
                                .name("NYU")
                                .build(),
                        new CompanyBuilder()
                                .id("C4")
                                .name("Aetna")
                                .build())
                        .stream()
                        .collect(Collectors.toMap(Company::id, Function.identity()));
    }
    @Override
    public Company get(final String id) {
        return companyMap.get(id);
    }
}
