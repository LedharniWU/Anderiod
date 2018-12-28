import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by guest on 2018/11/29.
 */

public class TitleAdapter extends BaseAdapter{

    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<TitleList> titleLists;

    public TitleAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTitleList(ArrayList<TitleList> titleLists){
        this.titleLists = titleLists;
    }

    @Override
    public int getCount() {
        return titleLists.size();
    }

    @Override
    public Object getItem(int position) {
        return titleLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return titleLists.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.title_list_layout,parent,false);

        ((TextView)convertView.findViewById(R.id.title)).setText(titleLists.get(position).getId());

        return convertView;
    }
}
