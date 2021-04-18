package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Company;
import edu.cooper.ece366.model.Job;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface CompanyDao {
    // data access object
    //@SqlQuery("select id, company, location, job_title, true as available from jobs j left join job_types jt on j.id = jt.job_id where j.company = :company")
    //@SqlQuery("select * from jobs where jobs.company = :company")
    //@SqlQuery("select id, company, location, job_title, true as available, jt.job_type from jobs j left join job_types jt on j.id = jt.job_id where j.company = :company")
    @SqlQuery("select * from companies where company_id = :company_id")

    @RegisterRowMapper(CoopedInJdbi.CompanyRowMapper.class)
    Company get(@Bind("company_id") String company_id);

    @SqlUpdate("insert into jobs(id, company, location, job_title) values (:id, :company, :location, :job_title)")
    void insertJob(
            @Bind("id") String id,
            @Bind("company") String company,
            @Bind("location") String location,
            @Bind("job_title") String job_title);
}
