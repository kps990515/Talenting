package a.talenting.com.talenting.controller.hosting;

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
import a.talenting.com.talenting.controller.event.EventActivity;
import a.talenting.com.talenting.custom.AddressSearchTextView;
import a.talenting.com.talenting.custom.adapter.ListRecyclerViewAdapter;
import a.talenting.com.talenting.custom.adapter.MultiListRecyclerViewAdapter;
import a.talenting.com.talenting.custom.domain.detailItem.ImageContentItem;
import a.talenting.com.talenting.custom.domain.detailItem.RecyclerItem;

/**
 * Created by daeho on 2017. 12. 5..
 */

public class HostingListView extends FrameLayout {
    private Activity activity;
    private ActivityResultManager manager;

    private RecyclerView recyclerView;
    private ListRecyclerViewAdapter adapter;
    private MultiListRecyclerViewAdapter adapterTemp;
    private AddressSearchTextView tvAddressSearch;
    private String sampleImage = "https://firebasestorage.googleapis.com/v0/b/locationsharechat.appspot.com/o/profile%2FAvXoH1Ar9PQXDBXYBk6yrUFpfA22.jpg?alt=media&token=c1d5fa82-b535-4d97-af88-75043642f019";

    public HostingListView(Activity activity, ActivityResultManager manager) {
        super(activity);
        this.activity = activity;
        this.manager = manager;

        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        init();
    }

    private void init(){
        View v = LayoutInflater.from(this.getContext()).inflate(R.layout.view_hosting_list, null, false);
        this.addView(v);

        recyclerView = v.findViewById(R.id.recyclerView);

        adapter = new ListRecyclerViewAdapter(true);
        adapterTemp = new MultiListRecyclerViewAdapter();

        //recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapterTemp);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        tvAddressSearch = v.findViewById(R.id.tvAddressSearch);
        tvAddressSearch.setParentActivity(activity, manager);
    }

    public void setSampleData(){
        List<ImageContentItem> items = new ArrayList<>();

        ImageContentItem item;
        for(int i = 0; i < 10; i++){
            item = new ImageContentItem(false);
            item.imageUrl = sampleImage;
            item.title = "title" + i;
            item.content = "content" + i;

            item.setOnClickListener(j -> {
                Intent intent = new Intent(this.getContext(), HostingActivity.class);
                this.getContext().startActivity(intent);
            });

            items.add(item);
        }

        adapter.addDataAndRefresh(items);
    }

    public void setSampleDataTemp(){
        List<RecyclerItem> itemsTemp = new ArrayList<>();

        for(int j = 0; j < 5; j++) {
            List<ImageContentItem> items = new ArrayList<>();

            ImageContentItem item;
            for (int i = 0; i < 10; i++) {
                item = new ImageContentItem(false);
                item.imageUrl = sampleImage;
                item.title = "title" + i;
                item.content = "content" + i;

                item.setOnClickListener(k -> {
                    Intent intent = new Intent(this.getContext(), EventActivity.class);
                    this.getContext().startActivity(intent);
                });

                items.add(item);
            }

            itemsTemp.add(new RecyclerItem("Title" + j, items));
        }

        adapterTemp.addDataAndRefresh(itemsTemp);
    }

    public void addData(ImageContentItem item){
        adapter.addDataAndRefresh(item);
    }

    public void addData(List<ImageContentItem> items){
        adapter.addDataAndRefresh(items);
    }
}