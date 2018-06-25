package science.denghaoyu.fascinatingmanager;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;
import science.denghaoyu.fascinatingmanager.fragments.TableListFragment;

public class ManageDatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    private ConnectionItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_database);
        Intent intent = getIntent();
        item = (ConnectionItem)intent.getSerializableExtra("ConnectionItem");
        ImageView table_img = (ImageView)findViewById(R.id.manage_database_imageview_table);
        TextView table_tv = (TextView)findViewById(R.id.manage_database_textview_tables);
        table_img.setOnClickListener(this);
        table_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.manage_database_imageview_table:
                table();
                break;
            case R.id.manage_database_textview_tables:
                table();
                break;
        }
    }

    private void table(){
        Fragment table = new TableListFragment();
        Bundle args = new Bundle();
        args.putSerializable("Connection",item);
        table.setArguments(args);
        addFragment(table);

    }
    private void addFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.manage_database_tables_list_layout,fragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
//        transaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    }
}
