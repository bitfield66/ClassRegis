package mobile.project1.com.classregis;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saiteja on 6/7/2016.
 */
public class ChooseTermCourseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private  Spinner termSpinner,subSpinner;
    private Button btnSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_course);
        defineControls();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int termPosition  = termSpinner.getSelectedItemPosition();
                int subPosition   = subSpinner.getSelectedItemPosition();

                if(termPosition == 0){
                    Toast.makeText(ChooseTermCourseActivity.this,"Please Select Term",Toast.LENGTH_LONG).show();
                }
                else if(subPosition == 0){
                    Toast.makeText(ChooseTermCourseActivity.this,"Please Select Subject",Toast.LENGTH_LONG).show();
                }else{

                    Intent intent = new Intent(ChooseTermCourseActivity.this,ClassesListActivity.class);
                    intent.putExtra("subject",(String)subSpinner.getSelectedItem());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void defineControls(){

        termSpinner  = (Spinner) findViewById(R.id.termSpinner);
        subSpinner  = (Spinner) findViewById(R.id.subSpinner);
        btnSearch  = (Button) findViewById(R.id.btnSearch);
        termSpinner.setOnItemSelectedListener(this);
        subSpinner.setOnItemSelectedListener(this);
        populateData();
    }

    private void populateData(){
        List<String> terms = new ArrayList<String>();
        terms.add("Select Term");
        terms.add("Spring2016");
        terms.add("Fall2016");
        terms.add("Summer2016");

        List<String> subjects = new ArrayList<String>();
        subjects.add("Select Subject");
        subjects.add("BTE-Business Teacher Ed");
        subjects.add("CFD-Child & Family Development");
        subjects.add("CMGT-Construction Managemnt");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, terms);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        termSpinner.setAdapter(dataAdapter);

        ArrayAdapter<String> subAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjects);
        subAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subSpinner.setAdapter(subAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(view.getId() == R.id.termSpinner){
            subSpinner.setSelection(0);
        }

    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}


