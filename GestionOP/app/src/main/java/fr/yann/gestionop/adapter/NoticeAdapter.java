package fr.yann.gestionop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.yann.gestionop.R;
import fr.yann.gestionop.models.Notice;

public class NoticeAdapter extends BaseAdapter {

    private Context context;
    private List<Notice> notices;
    private LayoutInflater inflater;

    public NoticeAdapter(Context context, List<Notice> notices){
        this.context = context;
        this.notices = notices;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return notices.size();
    }

    @Override
    public Notice getItem(int position) {
        return notices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_notice, null);

        Notice currentNotice = getItem(position);

        String name_member = currentNotice.getMember().getName();
        String firstname_member = currentNotice.getMember().getFirstName();
        String mark = Integer.toString(currentNotice.getMark());
        String description = currentNotice.getDesccription();

        TextView name_member_notice = convertView.findViewById(R.id.name_member_notice);
        TextView firstName_member_notice = convertView.findViewById(R.id.firstName_member_notice);
        TextView rate_notice = convertView.findViewById(R.id.rate_notice);
        TextView description_notice = convertView.findViewById(R.id.description_notice);

        name_member_notice.setText(name_member);
        firstName_member_notice.setText(firstname_member);
        rate_notice.setText(mark);
        description_notice.setText(description);

        return convertView;
    }
}
