package Task;

//import org.json.JSONArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TaskController {

    public static String listTasks() throws SQLException, JSONException {
        JSONArray json = new JSONArray();
        ResultSet resultSet = TaskConnection.listOfTasks();
        ResultSetMetaData metadata = resultSet.getMetaData();
        int numColumns = metadata.getColumnCount();

        while(resultSet.next())
        {
            JSONObject obj = new JSONObject();
            for (int i = 1; i <= numColumns; ++i)
            {
                String column_name = metadata.getColumnName(i);
                obj.put(column_name, resultSet.getObject(column_name));
            }
            json.put(obj);
        }
        return json.toString();
    }
}
