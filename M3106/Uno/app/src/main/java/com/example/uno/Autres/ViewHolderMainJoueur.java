package com.example.uno.Autres;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uno.R;

public class ViewHolderMainJoueur extends RecyclerView.ViewHolder {
    public ImageView view;

    public ViewHolderMainJoueur(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.backgroundCarte);
    }
}
