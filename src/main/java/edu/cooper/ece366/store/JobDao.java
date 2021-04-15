package edu.cooper.ece366.store;

import edu.cooper.ece366.model.Job;
import edu.cooper.ece366.model.User;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface JobDao {
    // data access object
    //@SqlQuery("select id, company, location, job_title from jobs j left join job_types jt on j.id = jt.job_id where j.company = :company and j.id = :id")
    @SqlQuery("select * from jobs where jobs.company = :company")

    @RegisterRowMapper(CoopedInJdbi.JobRowMapper.class)
    //Job getJob(@Bind("id") String id);
    Job getByCompany(@Bind("company") String company);

    @SqlUpdate("insert into jobs(id, company, location, job_title) values (:id, :company, :location, :job_title)")
    void insertJob(
            @Bind("id") String id,
            @Bind("company") String company,
            @Bind("location") String location,
            @Bind("job_title") String job_title);
}
