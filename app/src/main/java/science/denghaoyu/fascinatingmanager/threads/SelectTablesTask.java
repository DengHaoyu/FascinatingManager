package science.denghaoyu.fascinatingmanager.threads;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;

/**
 * Created by dhy on 18-3-24.
 */

//TODO this class is used to select all tables from database

public class SelectTablesTask extends AsyncTask<ConnectionItem,Void,List<String>> {
    private int offset;
    private int length;
    @Override
    protected List<String> doInBackground(ConnectionItem... connectionItems) {
        ConnectionItem item = connectionItems[0];
        String url = "jdbc:mysql:" +
                "//"+item.getAddress()+":"+item.getPort()+"/SCHEMATA";
        try {
            Connection connection = DriverManager.getConnection(url,item.getUser(),item.getPassword());
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select SCHEMA_NAME from table SCHEMATE where " +
                    "LIMIT "+length+" OFFSET "+offset+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
