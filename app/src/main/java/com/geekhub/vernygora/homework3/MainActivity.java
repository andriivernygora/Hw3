package com.geekhub.vernygora.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<CalcPrimesTask> taskList;
    List<Integer> primeList;
    Button btnStart, btnStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskList = new ArrayList<CalcPrimesTask>();
        primeList = new ArrayList<>();

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.rvPrime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                CalcPrimesTask task = new CalcPrimesTask(this);
                taskList.add(task);
                task.execute();
                Toast.makeText(getApplicationContext(), "New run queued.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnStop:
                for (CalcPrimesTask taskList : taskList) {
                    taskList.cancel(true);
                }
                Toast.makeText(getApplicationContext(), "All runs cancelled.", Toast.LENGTH_SHORT).show();
        }
    }
}

