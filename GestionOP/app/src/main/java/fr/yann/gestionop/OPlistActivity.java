package fr.yann.gestionop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import fr.yann.gestionop.adapter.OPAdapter;

public class OPlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_op);

        ListView opListView = findViewById(R.id.list_op);
        opListView.setAdapter(new OPAdapter(this,ConnexionActivity.getOpList()));

        opListView.setOnTouchListener(new ListView.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        opListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent otherActivity = new Intent(getApplicationContext(), OPActivity.class);
                otherActivity.putExtra("OP",position);
                startActivity(otherActivity);
            }
        });

    }
}
