package jude.kakao.com.codingtest.elevator;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jude.kakao.com.codingtest.R;
import jude.kakao.com.codingtest.model.Request;
import jude.kakao.com.codingtest.model.Scheduler;

public class ElevatorActivity extends AppCompatActivity {

    private String Tag = "Elevator";
    private List<Request> requests = new ArrayList<>();
    final int MAX_LEVEL = 100;
    final int CAPACITY = 8;
    final int ELAPSE = 1;
    public static int TIME = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        requestPermissions(permissions, 100);
        TextView tvContent = findViewById(R.id.tv_content);
        try {
            readInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scheduler scheduler = new Scheduler(new Elevator(MAX_LEVEL, CAPACITY, ELAPSE));
        for (Request request : requests) {
            scheduler.submit(request);
        }
        scheduler.start();
        tvContent.setText(scheduler.getResult());
        writeFile(scheduler.getResult());
    }

    private void writeFile(String result) {
        String filename = "down_peak_1.txt";
        Log.e("elevator", getFilesDir().getAbsolutePath());
        File file = new File(Environment.getExternalStorageDirectory(), filename);
        String fileContents = result;
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readInput() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.input);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = reader.readLine();
        int i =0;
        while(line != null) {
            String[] temp = line.split(",");
            Request request = new Request(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
            if(request.getOrig() != request.getDest()) {
                requests.add(request);
            }
            line = reader.readLine();
        }
        is.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
