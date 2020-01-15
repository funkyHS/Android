package com.company.funky.funkyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_layout);

//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(this);
//        replaceFragment(new RightFragment());

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button: {
                replaceFragment(new AnotherRightFragment());
            }
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.right_layout, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SimpleFragmentActivity.class);
        context.startActivity(intent);
    }
}
