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

    /** =)=/(=)·Q
     * Se crea una copia del ArrayList que se tiene en DependencyRepository
     * para tener una copia local en el Adapter que se pueda modificar sin cambiar los datos originales
     * @param context
     */
    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependency, new ArrayList<Dependency>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view=convertView;
        return  convertView;

    }
    class DependencyHolder{
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;

    }
}
