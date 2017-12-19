package a.talenting.com.talenting.controller.message;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import a.talenting.com.talenting.R;
import a.talenting.com.talenting.common.ActivityResultManager;
import a.talenting.com.talenting.custom.adapter.ListRecyclerViewAdapter;
import a.talenting.com.talenting.custom.domain.detailItem.IDetailItem;
import a.talenting.com.talenting.custom.domain.detailItem.MsgPreviewItem;

/**
 * Created by user on 2017-12-18.
 */

public class MessageListView extends FrameLayout {

    private Activity activity;
    private ActivityResultManager manager;
    private RecyclerView recyclerView;
    private ListRecyclerViewAdapter adapter;
    private String sampleImage = "https://firebasestorage.googleapis.com/v0/b/locationsharechat.appspot.com/o/profile%2FAvXoH1Ar9PQXDBXYBk6yrUFpfA22.jpg?alt=media&token=c1d5fa82-b535-4d97-af88-75043642f019";

    public MessageListView(Activity activity, ActivityResultManager manager) {
        super(activity);
        this.activity = activity;
        this.manager = manager;

        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        init();
    }

    private void init(){
        View v = LayoutInflater.from(this.getContext()).inflate(R.layout.view_message_list, null, false);
        this.addView(v);

        recyclerView = v.findViewById(R.id.recyclerView);
        adapter = new ListRecyclerViewAdapter(true);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

    }

    public void setSampleData(){
        List<IDetailItem> items = new ArrayList<>();

        MsgPreviewItem item;
        for(int i = 0; i < 10; i++){
            item = new MsgPreviewItem();
            item.name=i+"";
            item.content=i+"번째 메시지";
            item.imageUrl = sampleImage;
            item.lastTime = i+"분전";
            item.useBottomLine=true;

            item.setOnClickListener(j -> {
                Intent intent = new Intent(this.getContext(), MessageActivity.class);
                this.getContext().startActivity(intent);
            });

            items.add(item);
        }

        adapter.addDataAndRefresh(items);
    }

}