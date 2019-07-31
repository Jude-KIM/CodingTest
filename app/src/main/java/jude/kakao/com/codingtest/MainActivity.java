package jude.kakao.com.codingtest;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import jude.kakao.com.codingtest.exam.Appetites;
import jude.kakao.com.codingtest.exam.BlockGame;
import jude.kakao.com.codingtest.exam.Candidates;
import jude.kakao.com.codingtest.elevator.ElevatorActivity;

public class MainActivity extends AppCompatActivity {


    private MainAdapter adapter;
    private EasyRecyclerView rv;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        requestPermissions(permissions, 100);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "" +
                        "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        adapter = new MainAdapter(this);
        data = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.class_name)));
        rv = findViewById(R.id.rv);
        adapter.addAll(data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.addItemDecoration(new SimpleDividerItemDecoration(this));
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String name = data.get(position);
//                ToastUtils.show(MainActivity.this, name, ToastUtils.LENGTH_SHORT);
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Appetites.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Candidates.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, BlockGame.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, ElevatorActivity.class));
                        break;
                }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
