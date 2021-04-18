package edu.cooper.ece366.store;

import edu.cooper.ece366.model.*;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.postgres.PostgresPlugin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CoopedInJdbi {

    public static Jdbi create(String jdbcUrl) {
        Jdbi jdbi = Jdbi.create(jdbcUrl, "n1mda", "5uper5ecret");
        // I am having issues with this plugin
        jdbi.installPlugin(new SqlObjectPlugin());
        //jdbi.installPlugin(new JdbiPlugin.Singleton());
        jdbi.registerRowMapper(new UserRowMapper());
        return jdbi;
    }

    public static class UserRowMapper implements RowMapper<User> {
        @Override
        public User map(final ResultSet rs, final StatementContext ctx) throws SQLException {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String location = rs.getString("location");

            return new UserBuilder().id(id).name(name).location(location).build();
        }
    }

    public static class JobRowMapper implements RowMapper<Job> {
        @Override
        public Job map(final ResultSet rs, final StatementContext ctx) throws SQLException {
            String id = rs.getString("id");
            String jobTitle = rs.getString("job_title");
            String company = rs.getString("company");
            String location = rs.getString("location");
            String jobType = rs.getString("job_type");

            /*
            List<Job.JobType> jobType =
                    Optional.ofNullable(rs.getString("job_type"))
                            .map(
                                    jobTypeString ->
                                            Arrays.stream(jobTypeString.split(",", -1))
                                                .map(Job.JobType::fromDbValue)
                                                .collect(Collectors.toList()))
                                                .orElse(List.of());
            */
            return new JobBuilder()
                    .jobType(List.of(Job.JobType.fromDbValue(jobType)))
                    .id(id)
                    .company(company)
                    .jobTitle(jobTitle)
                    .available(true)
                    .location(location).build();
        }

    }

    public static class CompanyRowMapper implements RowMapper<Company> {
        @Override
        public Company map(final ResultSet rs, final StatementContext ctx) throws SQLException {
            String id = rs.getString("company_id");
            String company_name = rs.getString("company_name");

            return new CompanyBuilder().id(id).name(List.of(company_name)).build();
        }

    }

    /*
    public static class JobRowMapper implements RowMapper<Job> {
        @Override
        public Job map(final ResultSet rs, final StatementContext ctx) throws SQLException {
            List<Job> jobs;

            while(rs.next()) {
                String id = rs.getString("id");
                String jobTitle = rs.getString("job_title");
                String company = rs.getString("company");
                String location = rs.getString("location");
                //String jobType = rs.getString("job_type");

                List<Job.JobType> jobType =
                        Optional.ofNullable(rs.getString("job_type"))
                                .map(jobTypeString ->
                                                Arrays.stream(jobTypeString.split(",", -1))
                                                .map(Job.JobType::fromDbValue)
                                                .collect(Collectors.toList()))
                                                .orElse(List.of());

                Job job = JobBuilder()
                        .jobType(jobType)
                        .id(id)
                        .company(company)
                        .jobTitle(jobTitle)
                        .available(true)
                        .location(location).build();

                jobs.add(job);
            }
        }
    }
    */
}
