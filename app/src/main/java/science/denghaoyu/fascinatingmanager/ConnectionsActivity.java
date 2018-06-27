package science.denghaoyu.fascinatingmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import science.denghaoyu.fascinatingmanager.application.GlobalVariables;
import science.denghaoyu.fascinatingmanager.fragments.AddConnectionFragment;
import science.denghaoyu.fascinatingmanager.fragments.ConnectionsFragment;

import static science.denghaoyu.fascinatingmanager.R.id.content_connections_layout;

public class ConnectionsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int selectedItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Fragment fragment = GlobalVariables.fragments.get("ConnectionsFragment");
        if(fragment==null){
            fragment = new ConnectionsFragment();
            GlobalVariables.fragments.put("ConnectionFragment",fragment);
        }
        addFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//create menu view
        getMenuInflater().inflate(R.menu.connections, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//which item of menu is selected
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            //TODO
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {//drawer
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id==R.id.drawer_action_about){
            Intent intent = new Intent(this,AboutMeActivity.class);
            startActivity(intent);
        }else if(id==R.id.drawer_action_addConnection){
            Fragment fragment = GlobalVariables.fragments.get("AddConnectionFragment");
            if(fragment == null){
                fragment = new AddConnectionFragment();
                GlobalVariables.fragments.put("AddConnectionFragment",fragment);
            }
            addFragment(fragment);
        }else if(id == R.id.drawer_action_contact_me){
            Intent intent = new Intent(this,ContactMeActivity.class);
            startActivity(intent);
        }else if(id == R.id.drawer_action_connections){
            Fragment fragment = GlobalVariables.fragments.get("ConnectionsFragment");
            if(fragment==null){
                fragment = new ConnectionsFragment();
                GlobalVariables.fragments.put("ConnectionFragment",fragment);
            }
            addFragment(fragment);
        }
        //TODo
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void addFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_connections_layout,fragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();

//        transaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    }
}
