package lk.dev.mealslk.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import lk.dev.mealslk.R;
import lk.dev.mealslk.models.ItemSquareModel;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ItemSquareAdapter extends RecyclerView.Adapter<ItemSquareAdapter.CustomViewHolder> {

    private Context mContext;
    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<String> itemImages = new ArrayList<>();

    public ItemSquareAdapter(Context context, ArrayList<String> items, ArrayList<String> images) {
        this.mContext = context;
        this.itemNames = items;
        this.itemImages = images;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_sqaure, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(itemImages.get(position))
                .into(holder.itemImage);

        holder.itemTitle.setText(itemNames.get(position));

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + itemNames.get(position));
                Toast.makeText(mContext, itemNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemImages.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemTitle;

        public CustomViewHolder(View view) {
            super(view);
            itemImage = view.findViewById(R.id.item_image_sq);
            itemTitle = view.findViewById(R.id.item_title);
        }
    }

}
