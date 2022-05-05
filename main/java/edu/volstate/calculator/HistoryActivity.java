package edu.volstate.calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<String> calcHistory = new ArrayList<>();

    //overriding onCreate and setting layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button returnButton = findViewById(R.id.buttonReturn);


        // getting data from intent on main activity
        Bundle bundle = getIntent().getExtras();
        calcHistory = bundle.getStringArrayList("history");

        for (int i = 0; i < calcHistory.size(); i++) {
            Log.d("History Page", calcHistory.get(i));
        }

        // initializing recycler view rows
        RecyclerView recyclerView = findViewById(R.id.history_recycler_row);
        // instantiating adapter
        HistoryRecyclerAdapter adapter = new HistoryRecyclerAdapter(this, calcHistory);
        // attaching view and adapter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        returnButton.setOnClickListener(view -> finish());
    }
}