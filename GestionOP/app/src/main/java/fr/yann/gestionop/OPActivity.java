package fr.yann.gestionop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import fr.yann.gestionop.adapter.MenuAdapter;
import fr.yann.gestionop.adapter.MenuSoldAdapter;
import fr.yann.gestionop.adapter.NoticeAdapter;
import fr.yann.gestionop.models.OP;

public class OPActivity extends AppCompatActivity {

    private ImageView poster_op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);

        ImageView poster_op = findViewById(R.id.poster_op);
        TextView name_op = findViewById(R.id.name_op);
        TextView date_op = findViewById(R.id.date_op);
        TextView description_op = findViewById(R.id.description_op);
        ListView menusListView = findViewById(R.id.menu_op);
        TextView mark_op = findViewById(R.id.mark_op);
        ListView notice_op = findViewById(R.id.notice_op);
        TextView op_spent = findViewById(R.id.op_spent);
        TextView op_income = findViewById(R.id.op_income);
        ListView menussold_op = findViewById(R.id.menussold_op);

        final Button menu_op_button = findViewById(R.id.menu_op_button);
        final Button notice_op_button = findViewById(R.id.notice_op_button);
        final Button menusold_op_button = findViewById(R.id.menusold_op_button);

        FloatingActionButton cancel_button_op = findViewById(R.id.cancel_button_op);

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){

            int position = (int) bundle.get("OP");
            OP currentOP = ConnexionActivity.getOpList().get(position);

            int resID = getResources().getIdentifier(currentOP.getPhoto(), "drawable", getPackageName());
            poster_op.setImageResource(resID);

            name_op.setText(currentOP.getName());
            date_op.setText(currentOP.getDate());
            description_op.setText(currentOP.getDescription());
            menusListView.setAdapter(new MenuAdapter(this,currentOP.getMenus()));
            mark_op.setText(currentOP.getGeneral_mark() + " / 5");
            notice_op.setAdapter(new NoticeAdapter(this, currentOP.getNotices()));
            op_spent.setText(" " + currentOP.getSpent().toString() + "€");
            op_income.setText(" " + currentOP.getIncome().toString() + "€");
            menussold_op.setAdapter(new MenuSoldAdapter(this,currentOP.getMenuSolds()));

            menusListView.setOnTouchListener(new ListView.OnTouchListener(){
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

            notice_op.setOnTouchListener(new ListView.OnTouchListener(){
                @SuppressLint("ClickableViewAccessibility")
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

            menussold_op.setOnTouchListener(new ListView.OnTouchListener(){
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

            menu_op_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button notice_op_button = findViewById(R.id.notice_op_button);
                    Button menusold_op_button = findViewById(R.id.menusold_op_button);

                    RelativeLayout rl_menu_op = findViewById(R.id.rl_menu_op);
                    RelativeLayout rl_notice_op = findViewById(R.id.rl_notice_op);
                    RelativeLayout rl_menusold_op = findViewById(R.id.rl_menusold_op);

                    menu_op_button.setEnabled(false);
                    rl_menu_op.setVisibility(View.VISIBLE);

                    notice_op_button.setEnabled(true);
                    rl_notice_op.setVisibility(View.INVISIBLE);

                    menusold_op_button.setEnabled(true);
                    rl_menusold_op.setVisibility(View.INVISIBLE);
                }
            });

            notice_op_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button menu_op_button = findViewById(R.id.menu_op_button);
                    Button menusold_op_button = findViewById(R.id.menusold_op_button);

                    RelativeLayout rl_menu_op = findViewById(R.id.rl_menu_op);
                    RelativeLayout rl_notice_op = findViewById(R.id.rl_notice_op);
                    RelativeLayout rl_menusold_op = findViewById(R.id.rl_menusold_op);

                    menu_op_button.setEnabled(true);
                    rl_menu_op.setVisibility(View.INVISIBLE);

                    notice_op_button.setEnabled(false);
                    rl_notice_op.setVisibility(View.VISIBLE);

                    menusold_op_button.setEnabled(true);
                    rl_menusold_op.setVisibility(View.INVISIBLE);
                }
            });

            menusold_op_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button notice_op_button = findViewById(R.id.notice_op_button);
                    Button menu_op_button = findViewById(R.id.menu_op_button);

                    RelativeLayout rl_menu_op = findViewById(R.id.rl_menu_op);
                    RelativeLayout rl_notice_op = findViewById(R.id.rl_notice_op);
                    RelativeLayout rl_menusold_op = findViewById(R.id.rl_menusold_op);

                    menu_op_button.setEnabled(true);
                    rl_menu_op.setVisibility(View.INVISIBLE);

                    notice_op_button.setEnabled(true);
                    rl_notice_op.setVisibility(View.INVISIBLE);

                    menusold_op_button.setEnabled(false);
                    rl_menusold_op.setVisibility(View.VISIBLE);
                }
            });

            cancel_button_op.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
