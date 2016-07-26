package com.android.app.technicalassesment.view.adapters;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class BindingAdapters {

    @BindingAdapter({"bind:imageUrl","bind:placeHolder", "bind:error"})
    public static void loadImage(ImageView view, String url,Drawable placeHolder, Drawable error) {
        Picasso.with(view.getContext()).load(url).placeholder(placeHolder).error(error).into(view);
    }

}
