package mobile.project1.com.classregis;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mobile.project1.com.classregis.adapters.InstructorListAdapter;

public class SelectInstructor extends AppCompatActivity {

    private RecyclerView rvItems;
    private InstructorListAdapter instructorListAdapter;
    private boolean isDropClass = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_classes);

        Bundle extras = getIntent().getExtras();
        String subject = extras.getString("selSubject");

        if(extras.containsKey("isDropClass")){
            isDropClass = extras.getBoolean("isDropClass");
        }
        setActionBar(subject);
        defineControls();
        rvItems.setLayoutManager(new LinearLayoutManager(SelectInstructor.this));
        rvItems.setAdapter(instructorListAdapter = new InstructorListAdapter(SelectInstructor.this,isDropClass));
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

    private void defineControls() {
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
    }
}