package com.srpay.in.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.srpay.in.Base.BaseRecycleViewFragment;
import com.srpay.in.Base.BaseViewModel;
import com.srpay.in.R;
import com.srpay.in.UI.Fragments.Home.HomeFragment;
import com.srpay.in.UI.Fragments.Home.HomeOptionModel;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

import javax.inject.Inject;


/**
 * Created by Patrick Ivarsson on 7/17/17.
 */
public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHolder> {

    private int ITEM_COUNT = 0;
    private int Layout_ID;
    private BaseRecycleViewFragment baseRecyclerFragment;
    private RecyleAdapterListener recyleAdapterListener;
    private ArrayList<HomeOptionModel> DataList;

    public CustomRecycleAdapter(HomeFragment context) {
        recyleAdapterListener=(RecyleAdapterListener)context;
    }

    public CustomRecycleAdapter(Fragment context) {
        recyleAdapterListener=(RecyleAdapterListener)context;
    }

    public CustomRecycleAdapter() {
        //this.recyleAdapterListener=recyleAdapterListener;
    }

    public void setListener(RecyleAdapterListener recyleAdapterListener)
    {
        this.recyleAdapterListener=recyleAdapterListener;
    }

    public void setDataList(ArrayList<HomeOptionModel> DataList)
    {
        this.DataList = DataList;
    }

    public void setLayoutID(int layout_ID)
    {
        Layout_ID=layout_ID;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CustomViewHolder(inflater.inflate(Layout_ID, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        HomeOptionModel HOM = DataList.get(position);
        holder.tvOption.setText(HOM.getOptionName());
        if(HOM.getOptionIcon()!=0)
            holder.OptionIcon.setImageResource(HOM.getOptionIcon());
        else if(!HOM.getOptionImage().isEmpty())
            holder.OptionIcon.setImageResource(0);

        PushDownAnim.setOnTouchPushDownAnim( holder.itemView )
                .setOnClickListener( View->{
                    recyleAdapterListener.onItemClick(CustomRecycleAdapter.this,DataList.get(position));
                } );
    }

    @Override
    public int getItemCount() { return DataList.size(); }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvOption;
        ImageView OptionIcon;
        public CustomViewHolder(View itemView) {
            super(itemView);
            tvOption=itemView.findViewById(R.id.tvOption);
            OptionIcon=itemView.findViewById(R.id.icon);
        }
    }

    public interface RecyleAdapterListener
    {
        void onItemClick(CustomRecycleAdapter CRA,HomeOptionModel HOM);
    }
}
