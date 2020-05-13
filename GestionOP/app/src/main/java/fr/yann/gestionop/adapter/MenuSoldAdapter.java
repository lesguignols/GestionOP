package fr.sphimx.gestionop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import fr.sphimx.gestionop.R;
import fr.sphimx.gestionop.models.MenuSold;

public class MenuSoldAdapter extends BaseAdapter {

    private Context context;
    private List<MenuSold> menuSolds;
    private LayoutInflater inflater;

    public MenuSoldAdapter(Context context, List<MenuSold> menuSolds){
        this.context = context;
        this.menuSolds = menuSolds;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menuSolds.size();
    }

    @Override
    public MenuSold getItem(int position) {
        return menuSolds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_menusold, null);

        MenuSold currentMenusold = getItem(position);

        TextView description_menusold = convertView.findViewById(R.id.description_menusold);
        description_menusold.setText(currentMenusold.getDescription());

        if(!currentMenusold.isCan()){
            RelativeLayout rl_drink_menusold = convertView.findViewById(R.id.rl_drink_menusold);
            rl_drink_menusold.removeAllViews();
            //description_menusold.setBottom(100);
        } else {
            TextView drink_menusold = convertView.findViewById(R.id.drink_menusold);
            drink_menusold.setText(currentMenusold.getDrink().getName());
        }

        if (!currentMenusold.isAdherent()){
            RelativeLayout rl_adherent_menusold = convertView.findViewById(R.id.rl_adherent_menusold);
            rl_adherent_menusold.removeAllViews();
            //description_menusold.setBottom(100);
        } else {
            TextView name_adherent_menusold = convertView.findViewById(R.id.name_adherent_menusold);
            name_adherent_menusold.setText(currentMenusold.getPerson().getName());

            TextView firstName_adherent_menusold = convertView.findViewById(R.id.firstName_adherent_menusold);
            firstName_adherent_menusold.setText(currentMenusold.getPerson().getFirstName());
        }

        if(!currentMenusold.isCan() && !currentMenusold.isAdherent()){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(20, 20,20,40);
            convertView.setLayoutParams(lp);
        }

        return convertView;
    }
}
