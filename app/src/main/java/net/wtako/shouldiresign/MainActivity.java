package net.wtako.shouldiresign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Snackbar snackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void startQuestionsActivity(View view) {
        Intent intent = new Intent(this, QuestionsActivity.class);
        startActivity(intent);
    }

    public void onFabClick(View view) {
        if (snackBar != null) {
            snackBar.dismiss();
            snackBar = null;
            return;
        }
        snackBar = Snackbar.make(view, R.string.app_info, Snackbar.LENGTH_INDEFINITE);
        TextView textView = (TextView) snackBar.getView().findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(5);  // show multiple line
        snackBar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}
