package com.jrinehartspokane.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TabHost;
import android.widget.Toast;

public class LessonHomeActivity extends BaseActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_home);
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Lesson");
        spec.setContent(R.id.lessons);
        spec.setIndicator("Lesson");
        host.addTab(spec);

        spec = host.newTabSpec("Exercises");
        spec.setContent(R.id.exercises);
        spec.setIndicator("Exercises");
        host.addTab(spec);

        spec = host.newTabSpec("Feedback");
        spec.setContent(R.id.feedback);
        spec.setIndicator("Feedback");
        host.addTab(spec);

        expListView = (ExpandableListView) findViewById(R.id.lvLessons);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);


        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                return false;
            }
        });

        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        List<String> studentAssignments = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        List currentLesson = studentInfo.getCurrentSubscription().getAvailableLessons();
        int count = currentLesson.size();
        for (int i = 1; i < count; i++) {
            String currentLessons = studentInfo.getCurrentSubscription().getCurrentLesson().getTitle();
            listDataHeader.add(currentLessons);
            List currentAssignments = studentInfo.getCurrentSubscription().getCurrentLesson().getStudentAssignments();
            int count1 = currentAssignments.size();
            for (int j = 0; j < count1; j++) {
//                for (int k = 0; k < count1; k++) {
                String currentAssignment = studentInfo.getCurrentSubscription().getCurrentLesson().getStudentAssignments().get(j).getTitle();
                studentAssignments.add(currentAssignment);
//                }
            }
        }
        listDataChild.put(listDataHeader.get(0), studentAssignments); // Header, Child data
    }
}
