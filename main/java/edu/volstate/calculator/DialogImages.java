package edu.volstate.calculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

public class DialogImages extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // using builder to generate our menu view
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View menuView = inflater.inflate(R.layout.activity_images, null);

        // setting title
        builder.setView(menuView).setMessage("Images");

        // adding button and handling button
        Button buttonClose;
        buttonClose = menuView.findViewById(R.id.buttonClose);
        ImageView leftImage;
        leftImage = menuView.findViewById(R.id.imageView);
        ImageView rightImage;
        rightImage = menuView.findViewById(R.id.imageView2);
        rightImage.setImageResource(R.drawable.calculator2);
        leftImage.setImageResource(R.drawable.calculator1);

        buttonClose.setOnClickListener(view -> dismiss());
        return builder.create();
    }

}
