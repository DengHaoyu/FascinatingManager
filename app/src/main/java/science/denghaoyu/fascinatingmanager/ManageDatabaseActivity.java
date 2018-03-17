package science.denghaoyu.fascinatingmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;

public class ManageDatabaseActivity extends AppCompatActivity {
    private ConnectionItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_database);
        Intent intent = getIntent();
        item = (ConnectionItem)intent.getSerializableExtra("ConnectionItem");

    }
}
