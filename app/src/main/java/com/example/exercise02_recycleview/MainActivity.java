package com.example.exercise02_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rcUser)
    RecyclerView rcUser;

    ArrayList<UserFacebook> mUserFacebookArrayList;

    AdapterUserFacebook adapterUserFacebook;

    //    data img Avatar User
    Integer[] listAvataUsers = {R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user7,
            R.drawable.user8,
            R.drawable.user9,
            R.drawable.user10,
            R.drawable.user11,
            R.drawable.user12,
            R.drawable.user13,
            R.drawable.user20,
            R.drawable.user15,
            R.drawable.user16,
            R.drawable.user19,
            R.drawable.user20,
            R.drawable.user8,
            R.drawable.user4,
    };

    Integer[] listImgContent = {R.drawable.content1,
            R.drawable.content2,
            R.drawable.content3,
            R.drawable.content4,
            R.drawable.content5,
            R.drawable.content6,
            R.drawable.content7,
            R.drawable.content8,
            R.drawable.content9,
            R.drawable.content10,
            R.drawable.content11,
            R.drawable.content12,
            R.drawable.content13,
            R.drawable.content14,
            R.drawable.content15,
            R.drawable.content16,
            R.drawable.content17,
            R.drawable.content18,
            R.drawable.content19,
            R.drawable.content20
    };

//    data img Content FB

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initView() {
        adapterUserFacebook = new AdapterUserFacebook(getApplicationContext(), mUserFacebookArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcUser.setLayoutManager(linearLayoutManager);
        rcUser.setAdapter(adapterUserFacebook);
    }

    private void initData() {
        mUserFacebookArrayList = new ArrayList<>();
        Date currenDate = new Date();
        SimpleDateFormat timeSimpleDateFormat = new SimpleDateFormat("HH:mm");
        String time = timeSimpleDateFormat.format(currenDate);

        for (int i = 0; i < listAvataUsers.length; i++) {
            UserFacebook userFacebook = new UserFacebook();
            userFacebook.setAvataUser(listAvataUsers[i]);
            userFacebook.setNameUser("Name User " + i);
            userFacebook.setTime(time);
            userFacebook.setDescription("Description for user " + i);
            userFacebook.setImageContent(listImgContent[i]);
            mUserFacebookArrayList.add(userFacebook);
        }
    }

}