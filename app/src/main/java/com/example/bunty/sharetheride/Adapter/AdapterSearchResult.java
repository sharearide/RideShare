package com.example.bunty.sharetheride.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bunty.sharetheride.R;

/**
 * Created by bunty on 10/5/2015.
 */
public class AdapterSearchResult extends RecyclerView.Adapter<AdapterSearchResult.ViewHolderSearch> {
    private LayoutInflater layoutInflater;
    Context context;
    public AdapterSearchResult(FragmentActivity activity) {

        layoutInflater = LayoutInflater.from(activity);
        this.context = activity;

    }

    @Override
    public ViewHolderSearch onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.each_user_view, parent, false);
        ViewHolderSearch viewHolderSearch = new ViewHolderSearch(view);
        return viewHolderSearch;

    }

    @Override
    public void onBindViewHolder(ViewHolderSearch holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 3;
    }


    class ViewHolderSearch extends RecyclerView.ViewHolder {

TextView Uname,Uwork,Useat,Ucar,Ufare,Utime,Usource,Udestination;
        public ViewHolderSearch(View itemView) {

            super(itemView);
            CardView cv = (CardView) itemView.findViewById(R.id.cv);
            Uname = (TextView) itemView.findViewById(R.id.Uname);
            Uwork=  (TextView) itemView.findViewById(R.id.UWork);
            Useat = (TextView) itemView.findViewById(R.id.No_Of_Seats);
            Ucar=  (TextView) itemView.findViewById(R.id.Ucar);
            Ufare = (TextView) itemView.findViewById(R.id.UFare);
            Utime=  (TextView) itemView.findViewById(R.id.UTime);
            Usource = (TextView) itemView.findViewById(R.id.Usource);
            Udestination=  (TextView) itemView.findViewById(R.id.Udestination);
        }



    }

}
