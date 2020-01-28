package com.example.user.remember_me;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.remember_me.ModeloVO.TaskVO;

import java.util.List;

/**
 * Created by arthonsystechnologiesllp on 10/03/17.
 */

public class CustomAdapter extends BaseAdapter {

    Activity activity;
    List<TaskVO> tasks;
    LayoutInflater inflater;

    //short to create constructer using command+n for mac & Alt+Insert for window


    public CustomAdapter(Activity activity) {
        this.activity = activity;
    }

    public CustomAdapter(Activity activity, List<TaskVO> users) {
        this.activity   = activity;
        this.tasks      = tasks;

        inflater        = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null){

            view = inflater.inflate(R.layout.list_view_item, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = (TextView)view.findViewById(R.id.tv_user_name);
            holder.ckCheckBox = (CheckBox) view.findViewById(R.id.iv_check_box);
            holder.ivDelete = (ImageView) view.findViewById(R.id.iv_Delete);
            holder.ivEdit = (ImageView) view.findViewById(R.id.iv_Edit);
            view.setTag(holder);
        }else
            holder = (ViewHolder)view.getTag();

        TaskVO model = tasks.get(i);

        holder.tvUserName.setText(model.getname());

        if (model.getisDone())
            holder.ckCheckBox.setChecked(true);

        else
            holder.ckCheckBox.setChecked(false);

        return view;

    }

    public void updateRecords(List<TaskVO> users){
        this.tasks = tasks;

        notifyDataSetChanged();
    }

    class ViewHolder{

        TextView tvUserName;
        CheckBox ckCheckBox;
        ImageView ivEdit;
        ImageView ivDelete;

    }
}