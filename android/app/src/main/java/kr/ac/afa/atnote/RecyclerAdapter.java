package kr.ac.afa.atnote;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Recycler_item> items;
    int item_layout;
    public RecyclerAdapter(Context context, List<Recycler_item> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,null);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recycler_item item=items.get(position);

        holder.image.setImageURI(Uri.parse(item.getImage()));
        holder.place_name.setText(item.getPlace_name());
        holder.place_address.setText(item.getPlace_address());
        holder.place_number.setText(item.getPlace_number());
        holder.place_explain.setText(item.getPlace_explain());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,item.getPlace_name(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView place_name;
        TextView place_address;
        TextView place_number;
        TextView place_explain;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.image);
            place_name =(TextView)itemView.findViewById(R.id.title);
            place_address = (TextView)itemView.findViewById(R.id.place_address);
            place_number = (TextView)itemView.findViewById(R.id.place_number);
            place_explain = (TextView)itemView.findViewById(R.id.place_explain);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
        }
    }
}