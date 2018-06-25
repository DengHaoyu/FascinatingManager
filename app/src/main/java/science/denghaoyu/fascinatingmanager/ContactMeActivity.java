package science.denghaoyu.fascinatingmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class ContactMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_me);
        WebView webView = (WebView)findViewById(R.id.contactme_webview);
        webView.loadUrl("file:///android_asset/fmcontactMe.html");
    }

}
