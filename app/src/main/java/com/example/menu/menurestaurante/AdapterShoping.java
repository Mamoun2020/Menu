package com.example.menu.menurestaurante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;

import java.util.ArrayList;

public class AdapterShoping  extends RecyclerView.Adapter<AdapterShoping.MealsViewHolder>{
    ArrayList<ShopingMeals> meals;
    Context context;
    public AdapterShoping(Context context, ArrayList<ShopingMeals> meals) {
        this.meals = meals;
        this.context=context;
    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.shop_custom_item, parent, false);
        final ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = parent.getWidth();
        v.setLayoutParams(lp);
        MealsViewHolder viewHolder = new MealsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
        ShopingMeals meal = meals.get(position);
        holder.img_meal.setImageResource(meal.getImg_meal());
        holder.Name_Meal.setText(meal.getName_Meal());
        holder.count.setText(meal.
                getCount()+"");
        holder.price.setText(meal.getPrice()+"");
        Context context = holder.itemView.getContext();
    }


    @Override
    public int getItemCount() {
        return meals.size();
    }
    class MealsViewHolder extends RecyclerView.ViewHolder {
        TextView Name_Meal,price,count;
        ImageView img_meal;

        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            img_meal=itemView.findViewById(R.id.item_iv_shopmeal);
            Name_Meal=itemView.findViewById(R.id.item_tv_shopnamemeal);
            count=itemView.findViewById(R.id.item_tv_shopcount);
            price=itemView.findViewById(R.id.item_tv_shopprice);
        }
    }
}
