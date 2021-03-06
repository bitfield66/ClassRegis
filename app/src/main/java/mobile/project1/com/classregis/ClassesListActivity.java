package mobile.project1.com.classregis;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mobile.project1.com.classregis.adapters.ClassesListAdapter;

public class ClassesListActivity extends AppCompatActivity {

    private RecyclerView rvItems;
    private ClassesListAdapter classesListAdapter;
    public static int CLASS__REQUEST_CODE=500;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_classes);

        Bundle extras = getIntent().getExtras();
        String subject = extras.getString("subject");
        setActionBar(subject);
        defineControls();
        rvItems.setLayoutManager(new LinearLayoutManager(ClassesListActivity.this));
        rvItems.setAdapter(classesListAdapter = new ClassesListAdapter(ClassesListActivity.this));
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void setActionBar(String subject) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(subject);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CLASS__REQUEST_CODE && resultCode == Activity.RESULT_OK){
            finish();
        }
    }

    private void defineControls() {
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
    }
}