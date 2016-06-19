package mobile.project1.com.classregis.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mobile.project1.com.classregis.ClassesListActivity;
import mobile.project1.com.classregis.R;
import mobile.project1.com.classregis.common.Preference;

public class InstructorListAdapter extends RecyclerView.Adapter<InstructorListAdapter.InstructorItemViewHolder> {

    private Context mContext;
    private Preference preference;
    private boolean isRegistered = false,isDropClass=false;
    private String instructorList [] = {"Ins 1","Ins 2","Ins 3","Ins 4","Ins 5","Ins 6"};
    private String stateinstructorList [];
    public InstructorListAdapter(Context mContext,boolean isDropClass){
        this.mContext = mContext;
        preference = new Preference(mContext);
        int position = preference.getIntFromPreference(Preference.GET_CLASS_POSTION,-1);
        if(position>=0)
            isRegistered = true;
        this.isDropClass = isDropClass;
        if(isDropClass){
            stateinstructorList = new String[1];
            stateinstructorList[0] = instructorList[position];
        }else{
            stateinstructorList = instructorList;
        }
    }
    @Override
    public InstructorItemViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.instructor_list_item_cell, viewGroup, false);
        final InstructorItemViewHolder instructorItemViewHolder = new InstructorItemViewHolder(v);
        instructorItemViewHolder.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preference.saveIntInPreference(Preference.GET_CLASS_POSTION,(int)instructorItemViewHolder.btnRegister.getTag());
                preference.commitPreference();;
                ((AppCompatActivity)mContext).setResult(Activity.RESULT_OK);
                ((AppCompatActivity)mContext).finish();

            }
        });
        return instructorItemViewHolder;
    }

    @Override
    public void onBindViewHolder(InstructorItemViewHolder instructorItemViewHolder, int position) {
        instructorItemViewHolder.tvInstructorName.setText(stateinstructorList[position]);
        instructorItemViewHolder.tvDays.setText("Days " + position);
        instructorItemViewHolder.tvTime.setText("Time " + position);
        instructorItemViewHolder.btnRegister.setTag(position);
        if(isRegistered){
            instructorItemViewHolder.btnRegister.setClickable(false);
            instructorItemViewHolder.btnRegister.setEnabled(false);
        }else{
            instructorItemViewHolder.btnRegister.setClickable(true);
            instructorItemViewHolder.btnRegister.setEnabled(true);
        }

        if(isDropClass){
            instructorItemViewHolder.btnRegister.setVisibility(View.GONE);
        }else{
            instructorItemViewHolder.btnRegister.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return stateinstructorList.length;
    }

    public static class InstructorItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvInstructorName, tvDays,tvTime;
        Button btnRegister;

        InstructorItemViewHolder(View itemView) {
            super(itemView);
            tvInstructorName = (TextView) itemView.findViewById(R.id.tvInstructorName);
            tvDays = (TextView) itemView.findViewById(R.id.tvDays);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            btnRegister = (Button) itemView.findViewById(R.id.btnRegister);
        }
    }
}
