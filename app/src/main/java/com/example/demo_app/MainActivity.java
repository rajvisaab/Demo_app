package com.example.demo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shuhart.stickyheader.StickyHeaderItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridLayoutManager gridLayoutManager;
    ArrayList<String> list = new ArrayList<>();




    private ArrayList<Section> sectionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.item_list);

        sectionArrayList = new ArrayList<>();
        initList();


        SectionAdapter adapter = new SectionAdapter(this, sectionArrayList);
        gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(sectionArrayList.get(position).isHeader()) {
                   return 2;
                }else{
                    if (position % 2 == 0 || position % 3 >= 1) {
                        return 1;
                    } else {

                        return 2;
                    }
                }

            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);


        for (int i = 0; i < 5; i++) {
            list.add("Item " + i);
        }



        recyclerView.setAdapter(adapter);
        StickyHeaderItemDecorator decorator = new StickyHeaderItemDecorator(adapter);
        decorator.attachToRecyclerView(recyclerView);

    }

    private void initList() {

        int pos = 0;
        for (int headerPosition = 0; headerPosition<5; headerPosition++){
            HeaderModel vehicleModel = new HeaderModel(headerPosition);

            vehicleModel.setheader("Section"+(headerPosition+1));
            sectionArrayList.add(vehicleModel);

            pos = sectionArrayList.size()-1;

            ChildModel childModel = null;
            for (int childPosition = 1; childPosition <= 5; childPosition++){
                childModel = new ChildModel(pos);

                childModel.setChild("Item "+ childPosition);
                sectionArrayList.add(childModel);
               // childdone = childdone + 1;
            }
        }


    }

}