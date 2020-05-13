package fr.yann.gestionop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import fr.yann.gestionop.R;
import fr.yann.gestionop.models.OP;

public class OPAdapter extends BaseAdapter {

    private Context context;
    private List<OP> ops;
    private LayoutInflater inflater;

    public OPAdapter(Context context, List<OP> ops) {
        this.context = context;
        this.ops = ops;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return ops.size();
    }

    @Override
    public OP getItem(int position) {
        return ops.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_op, null);

        OP currentOP = getItem(position);

        ImageView img_op = convertView.findViewById(R.id.img_op);
        int resID = context.getResources().getIdentifier(currentOP.getPhoto(), "drawable", context.getPackageName());
        img_op.setImageResource(resID);



        return convertView;
    }
}
