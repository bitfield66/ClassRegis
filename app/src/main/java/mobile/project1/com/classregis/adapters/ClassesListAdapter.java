package mobile.project1.com.classregis.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mobile.project1.com.classregis.ClassesListActivity;
import mobile.project1.com.classregis.R;
import mobile.project1.com.classregis.SelectInstructor;

public class ClassesListAdapter extends RecyclerView.Adapter<ClassesListAdapter.ClassesItemViewHolder> {

    private static final String subjects[] = {"123","1234","12345"};
    private Context mContext;

    public ClassesListAdapter(Context mContext){
        this.mContext = mContext;
    }
    @Override
    public ClassesItemViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.classes_list_item_cell, viewGroup, false);
        final ClassesItemViewHolder classesItemViewHolder = new ClassesItemViewHolder(v);
        classesItemViewHolder.btnViewSections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion  = (int) classesItemViewHolder.btnViewSections.getTag();
                Intent intent  = new Intent(mContext, SelectInstructor.class);
                intent.putExtra("selSubject",subjects[postion]);
                ((AppCompatActivity)mContext).startActivityForResult(intent, ClassesListActivity.CLASS__REQUEST_CODE);
            }
        });
        return classesItemViewHolder;
    }

    @Override
    public void onBindViewHolder(ClassesItemViewHolder personViewHolder, int position) {
        personViewHolder.tvSubId.setText("Item " + position);
        personViewHolder.tvSubName.setText(subjects[position]+"");
        personViewHolder.btnViewSections.setTag(position);
    }

    @Override
    public int getItemCount() {
        return subjects.length;
    }

    public static class ClassesItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubId, tvSubName;
        Button btnViewSections;

        ClassesItemViewHolder(View itemView) {
            super(itemView);
            tvSubId = (TextView) itemView.findViewById(R.id.tvSubId);
            tvSubName = (TextView) itemView.findViewById(R.id.tvSubName);
            btnViewSections = (Button) itemView.findViewById(R.id.btnViewSections);
        }
    }
}
