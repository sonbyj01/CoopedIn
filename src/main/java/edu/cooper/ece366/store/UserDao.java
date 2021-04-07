package edu.cooper.ece366.store;
import edu.cooper.ece366.model.User;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;

public interface UserDao {
    // data access object
    @SqlQuery("select id, name, location from users u where u.id = :id ")

    @RegisterRowMapper(CoopedInJdbi.UserRowMapper.class)
    User getUser(@Bind("id") String id);

    @SqlUpdate("insert into users(id, name, location) values (:id, :name, :location)")
    void insertUser(
            @Bind("id") String id,
            @Bind("name") String name,
            @Bind("location") String location);
}
