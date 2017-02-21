package com.jrinehartspokane.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LessonHomeActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    ListView lessons;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_home);
        lessons = (ListView) findViewById(R.id.lvLessons);
        adapter = ArrayAdapter.createFromResource(this, R.array.countries_list, android.R.layout.simple_list_item_1);
        lessons.setAdapter(adapter);
        lessons.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ToastIt(adapter.getItem(position).toString() + ": " + position + " id: " + id);
    }
}
