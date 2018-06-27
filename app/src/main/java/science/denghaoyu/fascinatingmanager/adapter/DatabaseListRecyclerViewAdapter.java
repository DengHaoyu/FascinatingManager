package science.denghaoyu.fascinatingmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import science.denghaoyu.fascinatingmanager.R;

/**
 * Created by dhy on 18-3-24.
 */

public class DatabaseListRecyclerViewAdapter extends RecyclerView.Adapter<DatabaseListRecyclerViewAdapter.Holder> {
    private List<String> databaseNames = null;
    public DatabaseListRecyclerViewAdapter(List<String> databases){
        this.databaseNames = databases;
    }
    static class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recyclerview_database_list_table_name);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("DLRVA",databaseNames.size()+"   2");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_database_list,parent,false);
        Holder vh = new Holder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.d("DLRVA",databaseNames.size()+"");
        ((Holder)holder).textView.setText(databaseNames.get(position));
    }

    @Override
    public int getItemCount() {
        return databaseNames.size();
    }
}
