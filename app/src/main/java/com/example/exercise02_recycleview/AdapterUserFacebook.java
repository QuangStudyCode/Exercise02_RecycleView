package com.example.exercise02_recycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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

    private void showIcons(Button btnLike) {
        PopupMenu popupMenu = new PopupMenu(context, btnLike);
        popupMenu.getMenuInflater().inflate(R.menu.icons_choice, popupMenu.getMenu());

        // Đặt biểu tượng cho mỗi mục
        for (int i = 0; i < popupMenu.getMenu().size(); i++) {
            MenuItem item = popupMenu.getMenu().getItem(i);
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            TooltipCompat.setTooltipText(item.getActionView(), item.getTitle());
            switch (item.getItemId()) {
                case R.id.icLike:
                    item.setIcon(R.drawable.like);
                    break;
                case R.id.icHeart:
                    item.setIcon(R.drawable.love);
                    break;
                case R.id.icCare:
                    item.setIcon(R.drawable.care);
                    break;
                // Đặt biểu tượng cho các mục lựa chọn khác nếu cần
            }
        }

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.icLike:
                        Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.icHeart:
                        Toast.makeText(context, "Tym", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.icCare:
                        Toast.makeText(context, "Care", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });

        popupMenu.show();
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
