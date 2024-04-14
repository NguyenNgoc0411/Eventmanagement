package com.example.myapplication.AddressAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Object.AddressOrganization;
import com.example.myapplication.R;

import java.util.List;

public class AddressAdapter extends ArrayAdapter<AddressOrganization> {

    public AddressAdapter(@NonNull Context context, int resource, @NonNull List<AddressOrganization> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fill_event,parent,false);

        }


        return super.getView(position, convertView, parent);
    }
}
