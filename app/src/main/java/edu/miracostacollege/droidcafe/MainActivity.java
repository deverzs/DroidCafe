package edu.miracostacollege.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = MainActivity.class.getName() + ".extra.MESSAGE";
    String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
       switch(id){
           case R.id.action_contact:
                intent = new Intent(MainActivity.this, OrderActivity.class);
               intent.putExtra(EXTRA_MESSAGE, getString(R.string.action_contact_message));
               startActivity(intent);
               return true;
           case R.id.action_favorite:
               intent = new Intent(MainActivity.this, OrderActivity.class);
               intent.putExtra(EXTRA_MESSAGE, getString(R.string.action_favorites_message));
               startActivity(intent);
               return true;
           case R.id.action_order:
               intent = new Intent(MainActivity.this, OrderActivity.class);
               intent.putExtra(EXTRA_MESSAGE, getString(R.string.action_order_message));
               startActivity(intent);
               return true;
           case R.id.action_status:
               intent = new Intent(MainActivity.this, OrderActivity.class);
               intent.putExtra(EXTRA_MESSAGE, getString(R.string.action_status_message));
               startActivity(intent);
               return true;
       }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void orderedFroyo(View view){
        mOrderMessage = getString(R.string.froyo_order_mssg);
        displayToast(getString(R.string.froyo_order_mssg));
    }

    public void orderedDonut(View view){
        mOrderMessage = getString(R.string.donut_order_mssg);
        displayToast(getString(R.string.donut_order_mssg));
    }

    public void orderedIceCream(View view){
        mOrderMessage = getString(R.string.ice_cream_order_mssg);
        displayToast(getString(R.string.ice_cream_order_mssg));
    }
}
