package edu.cooper.ece366.store;

import edu.cooper.ece366.model.User;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface JobDao {
    // data access object
    @SqlQuery("select id, company, location, job_title from jobs j left join job_types jobTypes on j.id = jobTypes.job_id where j.id = :id ")

    @RegisterRowMapper(CoopedInJdbi.UserRowMapper.class)
    User getUser(@Bind("id") String id);

    @SqlUpdate("insert into users(id, name, location) values (:id, :name, :location)")
    void insertUser(
            @Bind("id") String id,
            @Bind("name") String name,
            @Bind("location") String location);
}
