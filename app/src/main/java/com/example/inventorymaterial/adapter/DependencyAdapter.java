package com.example.inventorymaterial.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventorymaterial.R;import com.example.inventorymaterial.data.db.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapter extends ArrayAdapter<Dependency> {

    public DependencyAdapter(@NonNull Context context) {
        //super(context, R.layout.item_dependency, new ArrayList<>(DependencyRepository.getInstance().getDependencies())); // para mostrar los datos de innitializate
        //sort(new Dependency.DependencyOrderByShortName());
        //dependencies = new ArrayList<>(DependencyRepository.getInstance().getDependencies());// Para tener un array list distinto del que sea ha hecho sort
        super(context,R.layout.item_dependency,new ArrayList<Dependency>());// para mostrar la lista vacia al principio
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder = new DependencyHolder();


            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            dependencyHolder.txvSortName = (TextView) view.findViewById(R.id.txvShortName);

            view.setTag(dependencyHolder);
        } else {
            dependencyHolder = (DependencyHolder) view.getTag();
        }


        dependencyHolder.icon.setLetter(getItem(position).getSortName().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvSortName.setText(getItem(position).getSortName());
        return view;
    }

    public DependencyAdapter orderByShortName(){
        sort(new Dependency.DependencyOrderByShortName());
        return this;
    }

    class DependencyHolder {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvSortName;
    }
}
