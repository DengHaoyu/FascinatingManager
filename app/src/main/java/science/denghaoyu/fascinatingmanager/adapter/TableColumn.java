package science.denghaoyu.fascinatingmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dhy on 6/26/18.
 */


public class TableColumn extends RecyclerView.Adapter<TableColumn.ColumnHolder> {

    static class ColumnHolder extends RecyclerView.ViewHolder{
        public ColumnHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ColumnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ColumnHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
