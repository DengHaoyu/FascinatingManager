package science.denghaoyu.fascinatingmanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import science.denghaoyu.fascinatingmanager.R;
import science.denghaoyu.fascinatingmanager.datastore.Settings;

/**
 * Created by dhy on 6/27/18.
 */

public class SettingFragment extends Fragment{
    public SettingFragment(){}
    Settings settings = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment,container,false);
        final EditText et = (EditText)view.findViewById(R.id.rows_in_each_selection_settingfragment);//maybe bugs
        et.setText(settings.getRowSelect());
        Button but  = (Button)view.findViewById(R.id.settingfragment_submit);
        but.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SettingFragment.this.settings.setRowSelect(Integer.getInteger(et.getText().toString()));
                SettingFragment.this.settings.save();
            }
        });
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Settings> sets = DataSupport.findAll(Settings.class);
        if(!sets.isEmpty()){//not empty
            this.settings = sets.get(0);
        }else{
            //do nothing
        }
    }
}