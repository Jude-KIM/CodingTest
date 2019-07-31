package jude.kakao.com.elevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public void start() {
        try {
            readInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scheduler scheduler = new Scheduler(new Elevator(MAX_LEVEL, CAPACITY, api));
        for (Request request : requests) {
            scheduler.submit(request);
        }
        scheduler.startFIFO();
        tvContent.setText(scheduler.getResult());
        writeFile(scheduler.getResult());
    }

    private void readInput() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.input10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = reader.readLine();
        int i =0;
        while(line != null) {
            String[] temp = line.split(",");
//            Request request = new Request(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
            Request request = new Request(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), i++);
            if(request.getOrig() != request.getDest()) {
                requests.add(request);
            }
            line = reader.readLine();
        }
        is.close();
    }
}
