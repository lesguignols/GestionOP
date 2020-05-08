package fr.sphimx.gestionop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import fr.sphimx.gestionop.adapter.MenuAdapter;
import fr.sphimx.gestionop.adapter.NoticeAdapter;
import fr.sphimx.gestionop.models.Adherent;
import fr.sphimx.gestionop.models.Menu;
import fr.sphimx.gestionop.models.MenuSold;
import fr.sphimx.gestionop.models.Notice;
import fr.sphimx.gestionop.models.OP;

public class MainActivity extends AppCompatActivity {

    private ImageView poster_op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);

        List<OP> opList = new ArrayList<>();
        List<Menu> menus = new ArrayList<>();
        List<Notice> notices = new ArrayList<>();
        List<Adherent> adherents = new ArrayList<>();

        menus.add(new Menu(1, "1 crêpe avec garniture au choix", 0.50, false,false));
        menus.add(new Menu(2, "3 crêpe avec garniture au choix", 1.00, false,false));

        adherents.add(new Adherent("147852369","DONNAINT", "Yann",
                "image0","",1,1,true,true,true));
        notices.add(new Notice(1,5, adherents.get(0), "Très bonne ambiance, tout le monde était investi"));

        OP newOP = new OP(1, "OP Crêpe", "06/05/2020", "crepe", menus,
                new ArrayList<MenuSold>(), 0.0, 0.0, notices,
                "OP Crêpe du 06/05/2020 fait par Yann");

        TextView name_op = findViewById(R.id.name_op);
        TextView date_op = findViewById(R.id.date_op);
        TextView description_op = findViewById(R.id.description_op);
        ListView menusListView = findViewById(R.id.menu_op);
        TextView mark_op = findViewById(R.id.mark_op);
        ListView notice_op = findViewById(R.id.notice_op);
        TextView op_spent = findViewById(R.id.op_spent);
        TextView op_income = findViewById(R.id.op_income);

        name_op.setText(newOP.getName());
        date_op.setText(newOP.getDate());
        description_op.setText(newOP.getDescription());
        menusListView.setAdapter(new MenuAdapter(this,menus));
        mark_op.setText(newOP.getGeneral_mark() + " / 5");
        notice_op.setAdapter(new NoticeAdapter(this, notices));
        op_spent.setText(" " + newOP.getSpent().toString() + "€");
        op_income.setText(" " + newOP.getIncome().toString() + "€");

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
    }
}
