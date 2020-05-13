package fr.yann.gestionop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.yann.gestionop.R;
import fr.yann.gestionop.models.Menu;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private List<Menu> menuList;
    private LayoutInflater inflater;

    public MenuAdapter(Context context, List<Menu> menuList){
        this.context = context;
        this.menuList = menuList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Menu getItem(int position) {
        return menuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_menu, null);

        Menu currentMenu = getItem(position);
        String description = currentMenu.getDescription();
        String price = currentMenu.getPrice().toString();
        String can = "Non";
        String adherent = "Non";
        if (currentMenu.isAdherent()){
            adherent = "Oui";
        }
        if (currentMenu.isCan()){
            can = "Oui";
        }

        TextView menu_description = convertView.findViewById(R.id.menu_description);
        TextView menu_price = convertView.findViewById(R.id.menu_price);
        TextView menu_drink = convertView.findViewById(R.id.menu_drink);
        TextView menu_adherent = convertView.findViewById(R.id.menu_adherent);

        menu_description.setText(description);
        menu_price.setText(price + "€");
        menu_drink.setText(can);
        menu_adherent.setText(adherent);

        return convertView;
    }
}
