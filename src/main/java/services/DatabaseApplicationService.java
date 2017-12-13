package services;

import models.Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseApplicationService extends DatabaseDataService<Application> {

    public DatabaseApplicationService(String url, DatabaseConnector connector) {
        super(url, connector);
    }

    @Override
    List<String> getCreateTableQueries() {
        List<String> queries = new ArrayList<String>();
        queries.add("CREATE TABLE product (product_id varchar(8) NOT NULL, name text NOT NULL, price double NOT NULL, quantity int(11) NOT NULL, PRIMARY KEY (product_id))");
        return queries;
    }

    public ArrayList<Application> getAll() {

        try {
            connect();
            String query = "select * from product";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
            }

            close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void update(Application data) {
        try {
            connect();

            String query = "";
            Statement statement = conn.createStatement();
            statement.execute(query);

            close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Application data) {
        try {
            connect();
            String query = "";
            Statement statement = conn.createStatement();
            statement.execute(query);
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
