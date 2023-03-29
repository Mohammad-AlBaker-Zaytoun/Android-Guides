package <PackageName>;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter {
    private final ArrayList<OBJECT> HData;
    private View.OnClickListener listener;


    public Adapter(ArrayList<OBJECT> HData) {
        this.HData = HData;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView TextViewExample;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewExample = itemView.findViewById(R.id.TextViewExample);
            itemView.setTag(this);
            itemView.setOnClickListener(listener);
        }

        public TextView getGdetails() {
            return TextViewExample;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.<XML FILE THAT HAVE BUTTON OR TEXT LIST EXAMPLE>, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ExampleViewHolder cvh = (ExampleViewHolder) holder;
        cvh.getGdetails().setText(HData.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return HData.size();
    }

    public void setOnItemClickListener(View.OnClickListener l) {
        listener = l;
    }
}
