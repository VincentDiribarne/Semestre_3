package com.example.uno.Autres;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

public class ViewHolderMainJoueur extends RecyclerView.ViewHolder {
    public View view;

    public ViewHolderMainJoueur(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.backgroundCarte);
    }
}
