package com.ninnanovila.materialdesign;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

public class ReceiptRecyclerViewAdapter extends RecyclerView.Adapter<ReceiptRecyclerViewAdapter.ReceiptViewHolder> {

    private Receipt[] receipts;
    private Activity activity;
    List<String> checked = new ArrayList<>();

    public ReceiptRecyclerViewAdapter(Receipt[] receipts, Activity activity) {
        this.receipts = receipts;
        this.activity = activity;
    }

    public List<String> getChecked() {
        return checked;
    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receipt, parent, false);
        return new ReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReceiptViewHolder holder, final int position) {
        final Receipt receipt = receipts[position];
        holder.nameReceipt.setText(receipt.getTitle());
        holder.ingredientsReceipt.setText(receipt.getIngredients());
        if (!receipt.getImageUrl().equals("")){
            Glide.with(activity)
                    .load(receipt.getImageUrl())
                    .centerCrop()
                    .into(holder.imageReceipt);
        }else{
            holder.imageReceipt.setImageResource(R.drawable.ic_broken_image);
        }
        holder.itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemCard.setChecked(!holder.itemCard.isChecked());
                addToChecked(receipt.getTitle(), holder.itemCard.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return receipts.length;
    }

    private void addToChecked(String input, Boolean check){
        if (check){
            Toast.makeText(activity, "Input : "+input, Toast.LENGTH_LONG).show();
            checked.add(input);
        }else {
            Toast.makeText(activity, "Delete : "+input, Toast.LENGTH_LONG).show();
            checked.remove(input);
        }
    }

    static class ReceiptViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageReceipt;
        private TextView nameReceipt;
        private TextView ingredientsReceipt;
        private MaterialCardView itemCard;

        public ReceiptViewHolder(@NonNull View itemView) {
            super(itemView);
            imageReceipt = itemView.findViewById(R.id.image_receipt);
            nameReceipt = itemView.findViewById(R.id.name_receipt);
            ingredientsReceipt = itemView.findViewById(R.id.ingredients_receipt);
            itemCard = itemView.findViewById(R.id.item_card);
        }
    }
}
