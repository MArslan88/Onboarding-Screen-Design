package com.mhdarslan.onboardingscreendesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter (Context context){
        this.context = context;
    }

    // Array
    public int[] slide_images = {
      R.drawable.group10,
      R.drawable.group11,
      R.drawable.group12
    };

    public String[] slide_headings = {
      "EAT",
      "SLEEP",
      "CODE"
    };

    public String[] slide_descs = {
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Id fugiat quas eligendi, quam quae eaque",
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Id fugiat quas eligendi, quam quae eaque",
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Id fugiat quas eligendi, quam quae eaque",
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = view.findViewById(R.id.slideImage);
        TextView slideHeading = view.findViewById(R.id.slideHeading);
        TextView slideDescription = view.findViewById(R.id.slideDesc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    // it will stop the view pager when its on the last page
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
