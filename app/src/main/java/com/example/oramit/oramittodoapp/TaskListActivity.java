package com.example.oramit.oramittodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    public void addTask(View view){
        Intent intent=new Intent(this,CreateTaskActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button add_task=(Button) findViewById(R.id.add_task_button);

        ArrayList<ItemDetails> image_details = CreateList();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaceAdapter(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ItemDetails obj_itemDetails = (ItemDetails) o;
                Toast.makeText(TaskListActivity.this, "You have chosen : " + " " + obj_itemDetails.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private ArrayList<ItemDetails> CreateList(){
        ArrayList<ItemDetails> new_list = new ArrayList<ItemDetails>();
        ItemDetails item_details = new ItemDetails();
        item_details.setName("Buy Pizza");
        item_details.setItemDescription("Spicy Chiken Pizza");
        new_list.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Wash the car");
        item_details.setItemDescription("Herzl Street");
        new_list.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Organize meetings next week");
        item_details.setItemDescription("put on schedule");
        new_list.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Buy mom a gift");
        item_details.setItemDescription("Perfume");
        new_list.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Order TV technician");
        item_details.setItemDescription("HOT");
        new_list.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Fix the phone");
        item_details.setItemDescription("04-85944788");
        new_list.add(item_details);

        return new_list;
    }


}
