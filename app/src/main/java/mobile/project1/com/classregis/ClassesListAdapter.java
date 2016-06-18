package mobile.project1.com.classregis;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anil.Jain on 4/30/2016.
 */
public class ClassesListAdapter extends RecyclerView.Adapter<ClassesListAdapter.ClassesItemViewHolder> {

    @Override
    public ClassesItemViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.classes_list_item_cell, viewGroup, false);
        ClassesItemViewHolder classesItemViewHolder = new ClassesItemViewHolder(v);
        classesItemViewHolder.btnViewSections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return classesItemViewHolder;
    }

    @Override
    public void onBindViewHolder(ClassesItemViewHolder personViewHolder, int position) {
        personViewHolder.tvSubId.setText("Item " + position);
        personViewHolder.tvSubName.setText("Item " + position);
    }

    @Override
    public int getItemCount() {
        return 30;
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
