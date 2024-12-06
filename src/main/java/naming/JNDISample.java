package naming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;

public class JNDISample {

    @Test
    void initcontext() {
        try {
            // given
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/dataSource");

            String sql = "SELECT id, name FROM users";

            // when
            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql)
            ) {
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
