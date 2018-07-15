package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rootdevs.ashish.mech2it.R;
import com.rootdevs.ashish.mech2it.loadl_link;


import java.util.ArrayList;

import Interface.ItemClickListener;
import Model.Feed;

import static android.content.ContentValues.TAG;

/**
 * Created by rishabh on 26-02-2016.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    ArrayList<Feed>feedItems;
    Context context;
    private ItemClickListener itemClickListener;
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
        holder.link.setText(current.getLink());

    }





    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            String passlink = link.getText().toString();
            Log.v(TAG, "inhere in item click listener "+passlink);
            Context c = v.getContext();
            Intent link = new Intent(c, loadl_link.class);
            link.putExtra("link",passlink);
            c.startActivity(link);

        }
    }
}