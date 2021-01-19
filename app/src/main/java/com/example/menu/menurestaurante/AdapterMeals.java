package com.example.menu.menurestaurante;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.ui.MainActivity;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class AdapterMeals extends RecyclerView.Adapter<AdapterMeals.MealsViewHolder>{

//    Context context;
    ArrayList<Meals>meals;
    OnItemClickListener  listener;
    public AdapterMeals(ArrayList<Meals> meals,OnItemClickListener listener) {
        this.meals = meals;
//        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_custom_item,null,false);
        //MealsViewHolder mealsViewHolder = new MealsViewHolder(view);

        /*final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.meal_custom_item, parent, false);*/
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_custom_item,parent,false);
        // match_parent won't work for RecyclerView (sigh)
        final ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = parent.getWidth();
        //lp.height = parent.getHeight();
        v.setLayoutParams(lp);
//        MealsViewHolder viewHolder = new MealsViewHolder(v);
//        return viewHolder;
        return new MealsViewHolder(v);
       // return mealsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
        Meals meal = meals.get(position);
        holder.bind(meal);
//        holder.img_meal.setImageResource(meal.getImg_meal());
//        holder.Name_Meal.setText(meal.getName_Meal());
//        holder.components.setText(meal.getComponents());
//        holder.price.setText(meal.getPrice()+"");
////        Context context = holder.itemView.getContext();

             holder.plus.setOnClickListener(new View.OnClickListener() {
                 double price_meal=meal.getPrice();
                 int price_count =1;
                 double Price_all=0.0;
                 @Override
                 public void onClick(View v) {
                     int count_meal = Integer.parseInt(holder.et_count.getText().toString());
                     int sum = count_meal+=price_count;
                     holder.et_count.setText(sum+"");
                     if (count_meal >= 1) {
                         // double price_meal=Double.parseDouble(price.getText().toString());
                         Price_all =sum* price_meal;
                         holder.price.setText(Price_all + "");
                     }
                 }
             });


             holder.minus.setOnClickListener(new View.OnClickListener() {
                 double price_meal=meal.getPrice();
                 int price_count =1;
                 double Price_all=0.0;
                 @Override
                 public void onClick(View v) {
                     int count_meal = Integer.parseInt(holder.et_count.getText().toString());
                     if(count_meal>1) {
                         int mins = count_meal - price_count;
                         holder.et_count.setText(mins + "");
                         if (count_meal >= 1) {
                             // double price_meal=Double.parseDouble(price.getText().toString());
                             Price_all = mins * price_meal;
                             holder.price.setText(Price_all + "");
                         }
                     }
                 }
             });

//   Meals meals = new Meals();
//             holder.btn_tobuy.setOnClickListener(new View.OnClickListener() {
//
//                 @Override
//                 public void onClick(View v) {
//                    //shared preferances
////                    Intent intent_tobuy=new Intent(context,FragmentShoping.class);
////                            intent_tobuy.putExtra("name", String.valueOf(holder.Name_Meal));
////                            intent_tobuy.putExtra("price", String.valueOf(holder.price));
////                     context.startActivity(intent_tobuy);
////                     String name_meal=holder.Name_Meal.getText().toString();
////                     SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
////                     SharedPreferences.Editor myEdit = sharedPreferences.edit();
////                     myEdit.putString("name", name_meal);
//                   FragmentShoping fragmentShoping = new FragmentShoping();
//                     Bundle bundle = new Bundle();
//                     bundle.putString("name",meals.getName_Meal());
//                     fragmentShoping.setArguments(bundle);
//                     Log.i("BUNDLE", bundle.toString());
//
//                 }
//             });

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }



    class MealsViewHolder extends  RecyclerView.ViewHolder{
        TextView Name_Meal,components,price;
        ImageView img_meal;
        EditText et_count;
        Button btn_tobuy,minus,plus;
        Meals meals;
        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            Name_Meal=itemView.findViewById(R.id.item_tv_namemeal);
            components=itemView.findViewById(R.id.item_tv_components);
            price=itemView.findViewById(R.id.item_tv_price);
            img_meal=itemView.findViewById(R.id.item_iv_meal);
            btn_tobuy=itemView.findViewById(R.id.item_btn_tobuy);
            minus=itemView.findViewById(R.id.item_btn_minus);
            plus=itemView.findViewById(R.id.item_btn_plus);
            et_count=itemView.findViewById(R.id.item_et_count);
            btn_tobuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(meals);
                }
            });

        }
        void bind(Meals meals){
            this.meals=meals;
            img_meal.setImageResource(meals.getImg_meal());
            Name_Meal.setText(meals.getName_Meal());
            components.setText(meals.getComponents());
            price.setText(meals.getPrice()+"");
            et_count.setKeyListener(null);
        }
    }
}
