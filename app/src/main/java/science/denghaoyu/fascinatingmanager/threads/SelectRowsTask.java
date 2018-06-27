package science.denghaoyu.fascinatingmanager.threads;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import science.denghaoyu.fascinatingmanager.application.Range;

/**
 * Created by dhy on 6/27/18.
 */

public class SelectRowsTask extends AsyncTask <Range,RecyclerView,List<String>>{
    @Override
    protected List<String> doInBackground(Range... ranges) {
//        String url = ""
//        Connection connection = DriverManager.getConnection();
        return null;
    }
}
