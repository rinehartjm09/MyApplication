package com.jrinehartspokane.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.jrinehartspokane.myapplication.R.id.txtWebContent;

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

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://caasera.azurewebsites.net/api/1.0/student";
        // Request string from url
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("BMI:", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ToastIt("That didn't work!!!");
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                String credentials = username + ":" + password;
                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                Log.i("BMI", auth);
                headers.put("Authorization", auth);
                return headers;
            }
        };
        queue.add(jsonRequest);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ToastIt(adapter.getItem(position).toString() + ": " + position + " id: " + id);
    }
}
