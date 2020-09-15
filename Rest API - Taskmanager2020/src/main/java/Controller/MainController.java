package Controller;

import Task.TaskConnection;
import Task.TaskController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@SpringBootApplication
public class MainController {
    public static void main(String[] args){
        SpringApplication.run(MainController.class, args);
    }
}

@RestController
@RequestMapping("/api")
class Task {

    @GetMapping("/tasks")
    public static String taskResult() throws SQLException {
        return TaskController.listTasks();
    }
}
