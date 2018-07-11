package Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rootdevs.ashish.mech2it.R;


import java.util.ArrayList;

import Model.Feed;

/**
 * Created by rishabh on 26-02-2016.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    ArrayList<Feed>feedItems;
    Context context;
    public FeedAdapter(Context context, ArrayList<Feed>feedItems){
        this.feedItems=feedItems;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Feed current=feedItems.get(position);
        holder.Title.setText(current.getTitle());
        holder.Description.setText(current.getDescription());
        holder.Date.setText(current.getPubDate());

    }



    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title,Description,Date, link;
        ImageView Thumbnail;
        CardView cv;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title= (TextView) itemView.findViewById(R.id.txtTitle);
            Description= (TextView) itemView.findViewById(R.id.txtcontent);
            Date= (TextView) itemView.findViewById(R.id.publishdate);
            link = (TextView)itemView.findViewById(R.id.linktext);
            cv = (CardView)itemView.findViewById(R.id.recipecard);
        }
    }
}