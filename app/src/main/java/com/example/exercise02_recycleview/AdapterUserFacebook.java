package com.example.exercise02_recycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Handler;

public class AdapterUserFacebook extends RecyclerView.Adapter<AdapterUserFacebook.ViewHolder> {

    private Context context;
    private ArrayList<UserFacebook> mUserFacebookArrayList;

    public AdapterUserFacebook(Context context, ArrayList<UserFacebook> mUserFacebookArrayList) {
        this.context = context;
        this.mUserFacebookArrayList = mUserFacebookArrayList;
    }

    @NonNull
    @Override
    public AdapterUserFacebook.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_user_facebook, parent, false);
        return new ViewHolder(view);
    }

    //    attach data
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull AdapterUserFacebook.ViewHolder holder, int position) {
        UserFacebook userFacebook = mUserFacebookArrayList.get(position);

        if (userFacebook == null) {
            return;
        }

        holder.imgAvatarUser.setImageResource(userFacebook.getAvataUser());
        holder.tvNameUserFB.setText(userFacebook.getNameUser());
        holder.tvDescriptionUserFB.setText(userFacebook.getDescription());

        holder.tvTimeStampFB.setText(userFacebook.getTime());
        holder.imgContentFB.setImageResource(userFacebook.getImageContent());

        holder.btnLike.setOnClickListener(view -> {
            if (isIconChanged) {
                holder.btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.like, 0, 0, 0);
            } else {
                holder.btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_like, 0, 0, 0);
            }
            isIconChanged = !isIconChanged;
        });

        holder.btnLike.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showIcons(holder.btnLike);
                return true;
            }
        });
    }

    private PopupWindow popupWindow;


    @SuppressLint("MissingInflatedId")
    private void showIcons(Button btnLike) {
        View popView = LayoutInflater.from(context).inflate(R.layout.popup_icons, null);
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);

        ImageView imgLike, imgLove, imgCare, imgHaha, imgWow, imgSad, imgAngry;
        imgLike = popView.findViewById(R.id.icLikePU);
        imgLove = popView.findViewById(R.id.icLovePU);
        imgCare = popView.findViewById(R.id.icCarePU);
        imgHaha = popView.findViewById(R.id.icHavaPU);
        imgWow = popView.findViewById(R.id.icWowPU);
        imgSad = popView.findViewById(R.id.icSadPU);
        imgAngry = popView.findViewById(R.id.icAngryPU);

        Rect rect = new Rect();
        btnLike.getGlobalVisibleRect(rect);
        int x = rect.right - 100; // Tọa độ x của view cha
        int y = rect.top - popupWindow.getHeight() - 80;// Tọa độ y của view cha trừ đi chiều cao của PopupWindow


        imgLike.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.like, 0, 0, 0);
            btnLike.setText(" Like");
            popupWindow.dismiss();
        });
        imgLove.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.love, 0, 0, 0);
            btnLike.setText(" Love");
            popupWindow.dismiss();
        });
        imgHaha.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.haha, 0, 0, 0);
            btnLike.setText(" Haha");
            popupWindow.dismiss();
        });

        imgCare.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.care, 0, 0, 0);
            btnLike.setText(" Care");
            popupWindow.dismiss();
        });

        imgWow.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.wow, 0, 0, 0);
            btnLike.setText(" Wow");
            popupWindow.dismiss();
        });

        imgSad.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.sad, 0, 0, 0);
            btnLike.setText(" Sad");
            popupWindow.dismiss();
        });

        imgAngry.setOnClickListener(view -> {
            btnLike.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.angry, 0, 0, 0);
            btnLike.setText(" Angry");
            popupWindow.dismiss();
        });
        popupWindow.showAtLocation(btnLike, 0, x, y);
    }

    private boolean isIconChanged = false;

    @Override
    public int getItemCount() {
        return mUserFacebookArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatarUser;

        TextView tvNameUserFB;

        TextView tvTimeStampFB;

        TextView tvDescriptionUserFB;

        ImageView imgContentFB;

        Button btnLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatarUser = itemView.findViewById(R.id.imgAvatarUser);
            tvNameUserFB = itemView.findViewById(R.id.tvNameUserFB);
            tvTimeStampFB = itemView.findViewById(R.id.tvTimeStampFB);
            tvDescriptionUserFB = itemView.findViewById(R.id.tvDescriptionUserFB);
            imgContentFB = itemView.findViewById(R.id.imgContentFB);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
