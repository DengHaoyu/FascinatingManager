package science.denghaoyu.fascinatingmanager.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import science.denghaoyu.fascinatingmanager.FMApplication;
import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;

/**
 * Created by dhy on 18-2-14.
 */

public class TestConnectionTask extends AsyncTask<ConnectionItem,Void,Boolean> {
    private static final String TAG = "TestConnectionTask";
    @Override
    protected Boolean doInBackground(ConnectionItem... connectionItems) {
        String url = "jdbc:mysql://"+connectionItems[0].getAddress()+":"+connectionItems[0].getPort()+"/information_schema";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection(url,connectionItems[0].getUser(),connectionItems[0].getPassword());
            if(connection.isValid(10000)){
                return true;
            }else{
                return false;
            }
        } catch (InstantiationException e) {
            Log.e(TAG,e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG,e.getMessage());
        } catch (ClassNotFoundException e) {//exceptions above should be solved in develop period of time
            Log.e(TAG,e.getMessage());
        } catch (SQLException e) {
            return false;
        }
        return false;
    }
}
