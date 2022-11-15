package com.example.bitcoinprice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitcoinprice.R;
import com.example.bitcoinprice.entity.Country;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    List<Country> countries;

    public CountryListAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.ViewHolder holder, int position) {
        Country country = this.countries.get(position);
        holder.textCode.setText(("Code : "+country.getCode()));
        holder.textSymbol.setText(("Symbol : "+country.getSymbol()));
        holder.textRate.setText(("Rate : "+country.getRate()));
        holder.textDescription.setText(("Description : "+country.getDescription()));

    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textCode, textSymbol, textRate, textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCode = itemView.findViewById(R.id.textCode);
            textSymbol = itemView.findViewById(R.id.textSymbol);
            textRate = itemView.findViewById(R.id.textRate);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}
