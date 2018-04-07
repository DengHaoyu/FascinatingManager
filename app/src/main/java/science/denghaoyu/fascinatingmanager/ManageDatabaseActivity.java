package science.denghaoyu.fascinatingmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;

public class ManageDatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    private ConnectionItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_database);
        Intent intent = getIntent();
        item = (ConnectionItem)intent.getSerializableExtra("ConnectionItem");

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.manage_database_imageview_table:

                break;
        }
    }

    private void table(){

    }
}
