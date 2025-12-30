package com.example.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);

        String[] foodList = {"Fulki", "Pani Puri", "Chaumin", "MOMO", "PIZZA", "Samosa"};
        String[] foodPriceList ={"200", "300", "400", "500", "600", "700"};

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new FoodAdapter(foodList,foodPriceList));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private static class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
        private final String[]foodList;
        private final String[] foodPriceList;

        FoodAdapter(String[] foodList, String[] foodPriceList){
            this.foodList=foodList;
            this.foodPriceList=foodPriceList;
        }
        @NonNull
        @Override
        public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_food, parent, false);
            return new FoodViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(@NonNull FoodViewHolder holder, int position){
            holder.foodNameTextView.setText(foodList[position]);
            holder.foodPriceTextView.setText(foodPriceList[position]);
        }
        @Override
        public int getItemCount(){
            return foodList.length;
        }
        static class FoodViewHolder extends RecyclerView.ViewHolder{
            TextView foodNameTextView;
            TextView foodPriceTextView;

            FoodViewHolder(@NonNull View itemView){
                super(itemView);
                foodNameTextView=itemView.findViewById(R.id.textViewfoodName);
                foodPriceTextView=itemView.findViewById(R.id.textViewfoodPrice);
            }
        }
    }
}