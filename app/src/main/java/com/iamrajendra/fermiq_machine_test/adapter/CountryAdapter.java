package com.iamrajendra.fermiq_machine_test.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamrajendra.fermiq_machine_test.R;
import com.iamrajendra.fermiq_machine_test.model.Country;
import com.iamrajendra.fermiq_machine_test.model.OnClickRow;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    List<Country> countries;
    private OnClickRow onClickRow;

    public void setOnClickRow(OnClickRow onClickRow) {
        this.onClickRow = onClickRow;
    }

    public CountryAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position),onClickRow);

    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.recycler_view_item;
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
