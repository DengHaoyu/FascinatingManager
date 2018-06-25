package science.denghaoyu.fascinatingmanager.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.concurrent.ExecutionException;

import science.denghaoyu.fascinatingmanager.FMApplication;
import science.denghaoyu.fascinatingmanager.R;
import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;
import science.denghaoyu.fascinatingmanager.threads.TestConnectionTask;

public class AddConnectionFragment extends Fragment {
    private EditText name,comment,address,user,password,port;
    private Button test,comfirm;
    private TextView firstLetter;
    public AddConnectionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_connection, container, false);
        init(view);
        return view;
    }
    private void init(View view){

        port = (EditText)view.findViewById(R.id.add_connection_port);
        name = (EditText)view.findViewById(R.id.add_connection_name);
        comment = (EditText)view.findViewById(R.id.add_connection_comment);
        address = (EditText)view.findViewById(R.id.add_connection_address);
        user = (EditText)view.findViewById(R.id.add_connection_user);
        password = (EditText)view.findViewById(R.id.add_connection_password);
        test = (Button)view.findViewById(R.id.add_connection_test);
        comfirm  = (Button)view.findViewById(R.id.add_connection_confirm);
        firstLetter = (TextView)view.findViewById(R.id.add_connection_head_letter);
        name.addTextChangedListener(new FirstLetter());
        test.setOnClickListener(new TestListener());
        comfirm.setOnClickListener(new
                AddListener());
    }
    private ConnectionItem getConnection(){
        ConnectionItem item = new ConnectionItem();
        item.setConnectionName(name.getText().toString());
        item.setAddress(address.getText().toString());
        item.setComment(comment.getText().toString());
        item.setUser(user.getText().toString());
        item.setPort(Integer.parseInt(port.getText().toString()));
        item.setPassword(password.getText().toString());
        if(item.getConnectionName().charAt(0)<=127)//ascii
            item.setFirstLetter(item.getConnectionName().charAt(0)+"");
        else
            item.setConnectionName(item.getConnectionName().charAt(0)+""+item.getConnectionName().charAt(1));
        return item;
    }
    private class TestListener implements View.OnClickListener{
        private final String TAG = "ACF.TestListener";
        @Override
        public void onClick(View v) {
            if(AddConnectionFragment.this.name.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "Name Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.user.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "User Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.address.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "Address Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.port.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "port Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.password.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "Password Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            ConnectionItem item = getConnection();
            TestConnectionTask task = new TestConnectionTask();
            task.execute(item);
            try {
                if(task.get().booleanValue()){
                    Toast.makeText(FMApplication.getContext(),"Congratulations!The Connection is valid!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FMApplication.getContext(),"Unfortunately,the connection is invalid:-(",Toast.LENGTH_SHORT).show();
                }
            } catch (InterruptedException e) {
                Toast.makeText(FMApplication.getContext(),"Exception occurred at AddConnectionFragment\n Please report on github,sorry for this",Toast.LENGTH_SHORT);
                Log.e(TAG,e.getMessage());
            } catch (ExecutionException e) {
                Toast.makeText(FMApplication.getContext(),"Exception occurred at AddConnectionFragment\nPlease report on github, sorry for this",Toast.LENGTH_SHORT);
                Log.e(TAG,e.getMessage());
            }
        }
    }
    private class AddListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(AddConnectionFragment.this.name.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "Name Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.user.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "User Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.address.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "Address Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.port.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "port Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            if(AddConnectionFragment.this.password.getText().toString().equals("")) {
                Toast.makeText(AddConnectionFragment.this.getContext(), "Password Can't be empty", Toast.LENGTH_SHORT).show();
                return ;
            }
            ConnectionItem item = getConnection();
            item.save();
            Toast.makeText(FMApplication.getContext(),"Save finished",Toast.LENGTH_SHORT).show();
//            getActivity().onBackPressed();
        }
    }
    private class FirstLetter implements TextWatcher{
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
        @Override
        public void afterTextChanged(Editable s) {
            if(!s.toString().equals("")){
                if(s.toString().charAt(0)<=127)//ascii set
                    AddConnectionFragment.this.firstLetter.setText(s.toString().charAt(0));
                else if(s.toString().length()>=2){
                    AddConnectionFragment.this.firstLetter.setText(s.toString().charAt(0));
                }else{
                    AddConnectionFragment.this.firstLetter.setText("N/A");
                }
            }
        }
    }
}
