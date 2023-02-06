module com.example.last_team_projects {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.last_team_projects to javafx.fxml;
    exports com.example.last_team_projects;
}