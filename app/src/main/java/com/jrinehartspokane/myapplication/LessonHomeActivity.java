package com.jrinehartspokane.myapplication;

//import android.support.annotation.IdRes;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Base64;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ExpandableListView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.EmptyStackException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.jrinehartspokane.myapplication.R.id.txtWebContent;


import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;


public class LessonHomeActivity extends BaseActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

//    expListView = (ExpandableListView) findViewById(R.id.lvLessons);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_home);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvLessons);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
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

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        //Create Jackson Object Mapper instance
//            ObjectMapper objectMapper = new ObjectMapper();
        //convert json string to object
//        List<String> lesson = new ArrayList<String>();
//        try {
//            List temp = studentInfo.getCurrentSubscription().getAvailableLessons();
//            int count = temp.size();
//            for (int i = 1; i < count; i++) {
//                String currentLessons = studentInfo.getCurrentSubscription().getCurrentLesson().getTitle();
//                lesson.add(currentLessons);
//            }
//        } catch (EmptyStackException e) {
//            e.printStackTrace();
//        }
//
//            final ArrayAdapter<String> adapter =
//                    new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, lesson);
//
//            expListView.setAdapter(adapter);
//            expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    ToastIt(adapter.getItem(position).toString() + ": " + position + " id: " + id);
//                }
//
//            });
        listDataHeader = new ArrayList<String>();
        List<String> studentAssignments = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data

//        try {
        List currentLesson = studentInfo.getCurrentSubscription().getAvailableLessons();
        int count = currentLesson.size();
        for (int i = 1; i < count; i++) {
            String currentLessons = studentInfo.getCurrentSubscription().getCurrentLesson().getTitle();
            listDataHeader.add(currentLessons);
            List currentAssignments = studentInfo.getCurrentSubscription().getCurrentLesson().getStudentAssignments();
            int count1 = currentAssignments.size();
            for (int j = 1; j <= count1; j++) {
                String currentAssignment = studentInfo.getCurrentSubscription().getCurrentLesson().getStudentAssignments().toString();
                studentAssignments.add(currentAssignment);
            }
        }
        listDataChild.put(listDataHeader.get(0), studentAssignments); // Header, Child data

//        } catch (EmptyStackException e) {
//            e.printStackTrace();
//        }

//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");

        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");

//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");

//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
    }


//    ExpandableListView lessons;
//    ArrayAdapter<CharSequence> adapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson_home);
//        lessons = (ExpandableListView) findViewById(R.id.lvLessons);
////        adapter = ArrayAdapter.createFromResource(this,
////                R.array.countries_list, android.R.layout.simple_list_item_1);
////        lessons.setAdapter(adapter);
//
//        List<String> lesson = new ArrayList<String>();
//        try {
//            List temp = studentInfo.getCurrentSubscription().getAvailableLessons();
//            int count = temp.size();
//            for (int i = 1; i < count; i++) {
//                String currentLessons = studentInfo.getCurrentSubscription().getCurrentLesson().getTitle();
//                lesson.add(currentLessons);
//            }
//        } catch (EmptyStackException e) {
//            e.printStackTrace();
//        }
//
////        studentInfo.getCurrentSubscription().getAvailableLessons();
////        lessons.setOnItemClickListener(this);
//
////        RequestQueue queue = Volley.newRequestQueue(this);
////        String url = "https://caasera.azurewebsites.net/api/1.0/student";
////        // Request string from url
////        JsonObjectRequest jsonRequest = new JsonObjectRequest(
////                url,
////                null,
////                new Response.Listener<JSONObject>() {
////                    @Override
////                    public void onResponse(JSONObject response) {
////                        Log.i("BMI:", response.toString());
//////                    response.get("currentSubscription").get("currentLesson").get("studentAssignments").get(0).get("title");
////
//////                        List<String> items = new ArrayList<String>();
//////                        try {
//////
//////                            JSONArray temp = ((JSONArray) ((JSONObject) ((JSONObject) response.get("currentSubscription")).get("currentLesson")).get("studentAssignments"));
//////                            int count = temp.length();
//////                            for (int i = 0; i < count; i++) {
//////                                items.add((String) ((JSONObject) temp.get(i)).get("title"));
//////                            }
//////                        } catch (JSONException e) {
//////                            e.printStackTrace();
//////                        }
////
//////                        //Create Jackson Object Mapper instance
//////                        ObjectMapper objectMapper = new ObjectMapper();
//////                        //convert json string to object
//////                        try{
//////                            studentInfo = objectMapper.readValue(response.toString(), StudentInfo.class);
//////                            Log.i("BMI", studentInfo.getFirstName());
//////                            Log.i("BMI",studentInfo.getCurrentSubscription().getCurrentLesson().getTitle());
//////                        } catch (IOException e){
//////                            e.printStackTrace();
//////                        }
////
//                        final ArrayAdapter<String> adapter =
//                                new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, lesson);
//
//                        lessons.setAdapter(adapter);
////                        lessons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////                            @Override
////                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                                ToastIt(adapter.getItem(position).toString() + ": " + position + " id: " + id);
////                            }
////
////                        });
////                    }
////                },
////                new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        ToastIt("That didn't work!!!");
////                    }
////                }) {
////            @Override
////            public Map<String, String> getHeaders() throws AuthFailureError {
////                Map<String, String> headers = new HashMap<String, String>();
////                String credentials = username + ":" + password;
////                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
////                Log.i("BMI", auth);
////                headers.put("Authorization", auth);
////                return headers;
////            }
////        };
////        queue.add(jsonRequest);
//
//    }


}
