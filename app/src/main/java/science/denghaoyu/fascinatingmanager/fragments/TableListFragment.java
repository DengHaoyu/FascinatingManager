package science.denghaoyu.fascinatingmanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import science.denghaoyu.fascinatingmanager.R;
import science.denghaoyu.fascinatingmanager.adapter.TableListRecyclerViewAdapter;
import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;
import science.denghaoyu.fascinatingmanager.threads.SelectTablesTask;

/**
 * Created by dhy on 18-3-24.
 */
//to show tables in activity ManageDatabaseActivity
public class TableListFragment extends Fragment {
    private ConnectionItem connection;
    public TableListFragment(){}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connection = (ConnectionItem) getArguments().getSerializable("Connection");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_table_list,container,false);
        SelectTablesTask task = new SelectTablesTask();
        List<String> tables = null;//TODO if exception(s) caught, more error will occur, for example
        //nullpointerexception in the next few lines of code
        //TODO BUG IS HERE
        task.execute(connection);
        try {
            tables = (List<String>) task.get();
        } catch (InterruptedException e) {
            Log.e("TableListFragment","error occurred when executing AsyncTask : "+e.toString());
            Toast.makeText(getActivity().getApplicationContext(),"Sorry exceptions occurred , please try again or report to the developer",Toast.LENGTH_LONG);
        } catch (ExecutionException e) {
            Log.e("TableListFragment","error occurred when executing AsyncTask : "+e.toString());
            Toast.makeText(getActivity().getApplicationContext(),"Sorry exceptions occurred , please try again or report to the developer",Toast.LENGTH_LONG);
        }
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.manage_database_tables_list_recyclerview);
        TableListRecyclerViewAdapter adapter;
        if(!tables.isEmpty()) {
            adapter = new TableListRecyclerViewAdapter(tables);
        }else{
            TextView tv = (TextView)view.findViewById(R.id.fragment_table_list_no_table_found);
            tv.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        return view;
    }
}
