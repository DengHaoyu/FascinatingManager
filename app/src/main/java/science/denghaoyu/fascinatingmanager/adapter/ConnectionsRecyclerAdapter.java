package science.denghaoyu.fascinatingmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import science.denghaoyu.fascinatingmanager.R;
import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;

/**
 * Created by dhy on 18-2-4.
 */

public class ConnectionsRecyclerAdapter extends RecyclerView.Adapter<ConnectionsRecyclerAdapter.Holder> {
    private ArrayList<ConnectionItem> connections;
    class Holder extends RecyclerView.ViewHolder{
        TextView firstLetter;
        TextView name;
        TextView comment;
        CheckBox checkBox;
        public Holder(View view) {
            super(view);
            this.firstLetter = (TextView)view.findViewById(R.id.recycleview_item_connections_firstletter);
            this.name = (TextView)view.findViewById(R.id.recycleview_item_connections_name);
            this.comment = (TextView)view.findViewById(R.id.recycleview_item_connections_comment);
            this.checkBox = (CheckBox)view.findViewById(R.id.recycleview_item_connections_checkBox);
        }
    }
    public ConnectionsRecyclerAdapter(ArrayList<ConnectionItem> items){
        this.connections = items;
    }
    @Override

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_connections,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ConnectionItem item = this.connections.get(position);
        holder.firstLetter.setText(item.getFirstLetter()+"");
        holder.name.setText(item.getConnectionName());
        holder.comment.setText(item.getComment());
    }

    @Override
    public int getItemCount() {
        Log.d("ASD",this.connections.size()+" ");
        return this.connections.size();

    }



}
