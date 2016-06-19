package mobile.project1.com.classregis;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mobile.project1.com.classregis.common.Preference;

/**
 * Created by Saiteja on 6/7/2016.
 */
public class ChooseOptionActivity extends AppCompatActivity {
    private Button b1,b2;
    private Preference preference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);
        preference = new Preference(ChooseOptionActivity.this);
        Button b1=(Button)findViewById(R.id.add);
        Button b2=(Button)findViewById(R.id.drop);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseOptionActivity.this,ChooseTermCourseActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = preference.getIntFromPreference(Preference.GET_CLASS_POSTION,-1);
                if(position>0){
                    Intent i = new Intent(ChooseOptionActivity.this,SelectInstructor.class);
                    i.putExtra("isDropClass",true);
                    startActivityForResult(i,ClassesListActivity.CLASS__REQUEST_CODE);
                }else{
                    Toast.makeText(ChooseOptionActivity.this,"Please Add Classes to Drop.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
