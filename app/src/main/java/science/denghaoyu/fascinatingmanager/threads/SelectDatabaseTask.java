package science.denghaoyu.fascinatingmanager.threads;

import android.os.AsyncTask;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;
import science.denghaoyu.fascinatingmanager.datastore.Settings;

/**
 * Created by dhy on 18-3-24.
 */

//TODO this class is used to select all tables from database

public class SelectDatabaseTask extends AsyncTask<ConnectionItem,Void,List<String>> {
    @Override
    protected List<String> doInBackground(ConnectionItem... connectionItems) {
        ConnectionItem item = connectionItems[0];
        String url = "jdbc:mysql:" +
                "//"+item.getAddress()+":"+item.getPort()+"/information_schema";
        ArrayList<String> strings = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url,item.getUser(),item.getPassword());
            if(!connection.isValid(DataSupport.findAll(Settings.class).get(0).getTimeOut())){
                return strings;
            }
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select SCHEMA_NAME from  SCHEMATA ;");
            while(resultSet.next()){
                strings.add(resultSet.getString("SCHEMA_NAME"));
            }
        } catch (SQLException e) {
            Log.e("STT",e.toString());
        }
        return strings;
    }
}
