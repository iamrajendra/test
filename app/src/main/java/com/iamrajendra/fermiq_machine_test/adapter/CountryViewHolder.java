package com.iamrajendra.fermiq_machine_test.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iamrajendra.fermiq_machine_test.R;
import com.iamrajendra.fermiq_machine_test.model.Country;
import com.iamrajendra.fermiq_machine_test.model.OnClickRow;

class CountryViewHolder  extends RecyclerView.ViewHolder {
    private TextView textView;
    private ImageView imageView;
    private OnClickRow onClickRow;
    private Country country;
    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title);
        imageView = itemView.findViewById(R.id.image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickRow!=null){
                    onClickRow.onClick(country);
                }
            }
        });
    }

    public void bind(Country country, OnClickRow onClickRow) {
        textView.setText(country.getName());
       this. onClickRow=onClickRow;
        this.country = country;
        Glide.with(itemView.getContext()).load(country.getImage()).into(imageView);
      /*  Picasso.get().
                load(country.getImage())
//                load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_image_red_24dp)
                .resize(100,100).into(imageView);*/
    }
}
