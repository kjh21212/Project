package com.example.hello.project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< Updated upstream
=======
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.net.Uri;
>>>>>>> Stashed changes

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;
    private Context mContext = null;

    // ListViewAdapter의 생성자
    public ListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }
    // Adapter에 사용되는 데이터의 개수를 리턴.
    @Override
    public int getCount(){
        return listViewItemList.size() ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position).getTitle() ;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴.
    @Override
    public long getItemId(int position) {
        return position ;
    }


    public void clear() {
        // clear the data
        listViewItemList.clear();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //final int pos = position;
        //final Context context = parent.getContext();
        ViewHolder holder;
        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_list_view_item,null);

            holder.iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
            holder.titleTextView  = (TextView) convertView.findViewById(R.id.textView1) ;
            holder.descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

<<<<<<< Updated upstream
            convertView.setTag(holder);

=======
            holder.callBtn = (ImageButton) convertView.findViewById(R.id.callbutton);
            holder.callBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent intent =
                            new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getNumber(position)));
                    mContext.startActivity(intent);
                }

            });
            convertView.setTag(holder);
>>>>>>> Stashed changes
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        holder.iconImageView.setImageDrawable(listViewItem.iconDrawable);
        holder.titleTextView.setText(listViewItem.titleStr);
        holder.descTextView.setText(listViewItem.descStr);

        return convertView;

    }
    public static class ViewHolder {
        @SuppressWarnings("unchecked")
        ImageView iconImageView;
        TextView titleTextView;
        TextView descTextView;
    }
    // 아이템 데이터 추가를 위한 함수.
    public void addItem(Drawable icon, String title, String desc) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        listViewItemList.add(item);
    }
}
