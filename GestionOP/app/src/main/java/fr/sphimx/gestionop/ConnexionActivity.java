package fr.sphimx.gestionop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fr.sphimx.gestionop.models.Adherent;
import fr.sphimx.gestionop.models.Menu;
import fr.sphimx.gestionop.models.MenuSold;
import fr.sphimx.gestionop.models.Notice;
import fr.sphimx.gestionop.models.OP;

public class ConnexionActivity extends AppCompatActivity {

    private static List<OP> opList = new ArrayList<>();
    private static List<Menu> menus = new ArrayList<>();
    private static List<Notice> notices = new ArrayList<>();
    private static List<Adherent> adherents = new ArrayList<>();
    private static List<MenuSold> menuSolds = new ArrayList<>();
    private static Adherent currentAdherent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        init();

        final EditText id_connexion = findViewById(R.id.id_connexion);
        final EditText password_connexion = findViewById(R.id.password_connexion);
        Button connexion_button = findViewById(R.id.connexion_button);
        Button exit_connexion = findViewById(R.id.exit_connexion);

        connexion_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean connexion = false;
                String id = id_connexion.getText().toString();
                String password = password_connexion.getText().toString();
                String name = "";
                String code = "";
                String secret = "";
                for (Adherent adherent: adherents){
                    name = adherent.getName();
                    code = Integer.toString(adherent.getCode());
                    secret = Integer.toString(adherent.getSecret_code());
                    if (id.equals(name) && (password.equals(code) || password.equals(secret))){
                        connexion = true;
                        currentAdherent = adherent;
                    }
                }
                if (connexion) {
                    Intent otherActivity = new Intent(getApplicationContext(), OPlistActivity.class);
                    startActivity(otherActivity);
                }
            }
        });

        exit_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init(){
        menus.add(new Menu(1, "1 crêpe avec garniture au choix", 0.50, false,false));
        menus.add(new Menu(2, "3 crêpe avec garniture au choix", 1.00, false,false));
        menus.add(new Menu(3, "1 burger", 1.00, false,false));

        menuSolds.add(new MenuSold(menus.get(0),1,null,null));
        menuSolds.add(new MenuSold(menus.get(1),2,null,null));

        adherents.add(new Adherent("147852369","DONNAINT", "Yann",
                "ic_person_black_24_do","",1,1,true,true,true));
        notices.add(new Notice(1,5, adherents.get(0), "Très bonne ambiance, tout le monde était investi"));

        List<Menu> mop1 = new ArrayList<>();
        mop1.add(menus.get(0));
        mop1.add(menus.get(1));

        List<Menu> mop2 = new ArrayList<>();
        mop2.add(menus.get(2));

        opList.add(new OP(1, "OP Crêpe", "06/05/2020", "crepe", mop1,
                menuSolds, 0.0, 0.0, notices,
                "OP Crêpe du 06/05/2020 fait par Yann"));
        opList.add(new OP(2, "OP Burger", "07/05/2020", "burger", mop2,
                new ArrayList<MenuSold>(), 0.0, 0.0, new ArrayList<Notice>(),
                "OP Burger du 07/05/2020 fait par Yann"));
    }

    public static List<OP> getOpList() {
        return opList;
    }

    public static List<Menu> getMenus() {
        return menus;
    }

    public static List<Notice> getNotices() {
        return notices;
    }

    public static List<Adherent> getAdherents() {
        return adherents;
    }

    public static List<MenuSold> getMenuSolds() {
        return menuSolds;
    }

    public static void addOpList(OP newOP){
        opList.add(newOP);
    }

    public static void addMenu(Menu newMenu){
        menus.add(newMenu);
    }

    public static void addNotice(Notice newNotice){
        notices.add(newNotice);
    }

    public static void addAdherent(Adherent newAdherent){
        adherents.add(newAdherent);
    }

    public static void addMenusold(MenuSold newMenuSold){
        menuSolds.add(newMenuSold);
    }

    public static Adherent getCurrentAdherent(){
        return currentAdherent;
    }
}
