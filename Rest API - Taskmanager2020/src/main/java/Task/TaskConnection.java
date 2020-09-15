package Task;

import DBConnection.ConDB;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskConnection {

    public static Connection connection;
    public static PreparedStatement getTasks;

    public static ResultSet listOfTasks() throws SQLException {

        connection = ConDB.getConnection();
        connection.setAutoCommit(false);
        getTasks = connection.prepareStatement("SELECT * FROM public.\"Task\"");

        System.out.println("Query Executed on Task table");

        return getTasks.executeQuery();
    }
}
