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
        jdbi.installPlugin(new SqlObjectPlugin());
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

}
