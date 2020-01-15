package com.company.funky.funkyapplication;

//import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.app.ActionBar;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Log.d(TAG, "onCreate: execute");

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        Button button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.actionStart(MainActivity.this, "Hello", "Android");
            }
        });

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListViewActivity.actionStart(MainActivity.this);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerViewActivity.actionStart(MainActivity.this);
            }
        });


        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleFragmentActivity.actionStart(MainActivity.this);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item :
                Toast.makeText(this,"You Click Add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item :
                Toast.makeText(this,"You Click Remove", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
