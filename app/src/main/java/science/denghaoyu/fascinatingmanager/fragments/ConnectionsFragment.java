package science.denghaoyu.fascinatingmanager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

import science.denghaoyu.fascinatingmanager.R;
import science.denghaoyu.fascinatingmanager.adapter.ConnectionsRecyclerAdapter;
import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;


public class ConnectionsFragment extends Fragment {
    private ArrayList<ConnectionItem> items ;
    public ConnectionsFragment(){
        this.items = (ArrayList<ConnectionItem>)DataSupport.findAll(ConnectionItem.class);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connections, container, false);;
        RecyclerView recyclerView = view.findViewById(R.id.fragment_connections_connections);
        recyclerView.setAdapter(new ConnectionsRecyclerAdapter(this.items));
        return view;
    }

}
