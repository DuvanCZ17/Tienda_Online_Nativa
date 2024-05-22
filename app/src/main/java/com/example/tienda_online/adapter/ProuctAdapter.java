package com.example.tienda_online.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda_online.R;
import com.example.tienda_online.model.Product;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ProuctAdapter extends FirestoreRecyclerAdapter<Product, ProuctAdapter.ViewHolder> {
    public ProuctAdapter(@NonNull FirestoreRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Product product) {
        viewHolder.productName.setText(product.getProductName());
        viewHolder.description.setText(product.getDescription());
        viewHolder.availableUnits.setText(product.getAvailableUnits());
        viewHolder.price.setText(product.getPrice());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_single, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productName, description,  availableUnits ,price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            description = itemView.findViewById(R.id.description);
            availableUnits = itemView.findViewById(R.id.availableUnits);
            price = itemView.findViewById(R.id.price);
        }
    }
}
