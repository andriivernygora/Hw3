package com.geekhub.vernygora.homework3;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.AsyncTask;
import androidx.recyclerview.widget.RecyclerView;

public class CalcPrimesTask extends AsyncTask<Void, String, List<Integer>> {

    Activity activity;

    public CalcPrimesTask(Activity mainActivity) {
        activity = mainActivity;
    }

    @Override
    protected List<Integer> doInBackground(Void... params) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= Integer.MAX_VALUE ; i++) {
            int maxCalc = (int)Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 2; j <= maxCalc ; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
                publishProgress( "Prime number " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
        return primeList;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        RecyclerView recyclerView = activity.findViewById(R.id.rvPrime);
        List<String> list = new ArrayList<>();
        list.add(values[0]);
        PrimeAdapter primeAdapter = new PrimeAdapter(activity, list);
        recyclerView.setAdapter(primeAdapter);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(List<Integer> result) {
        super.onPostExecute(result);
    }
}
