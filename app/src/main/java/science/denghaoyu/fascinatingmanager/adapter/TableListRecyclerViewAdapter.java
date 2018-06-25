package science.denghaoyu.fascinatingmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
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

public class TableListRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<String> tableNames = null;
    public TableListRecyclerViewAdapter(List<String> tables){
        this.tableNames = tables;
    }
    private static class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recyclerview_table_list_table_name);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_table_list,parent,false);
        Holder vh = new Holder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).textView.setText(tableNames.get(position));
    }

    @Override
    public int getItemCount() {
        return tableNames.size();
    }
}
