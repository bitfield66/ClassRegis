package mobile.project1.com.classregis;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saiteja on 6/7/2016.
 */
public class ChooseOptionActivity extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);
        Button b1=(Button)findViewById(R.id.add);
        Button b2=(Button)findViewById(R.id.drop);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseOptionActivity.this,ChooseTermCourseActivity.class);
                startActivity(i);
            }
        });
    }
}
