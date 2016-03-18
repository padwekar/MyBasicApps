package healthsignz.com.recyclerview;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataHolder> {

    List<Integer> dataList = new ArrayList<Integer>();
    public RecyclerViewAdapter(List<Integer> dataList) {
        this.dataList =dataList;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = View.inflate(parent.getContext(),R.layout.row_items,parent);

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_items,parent,false);
        DataHolder holder = new DataHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        holder.vSubTitle.setText(dataList.get(position)+"SubTitle");
        holder.vTitle.setText(dataList.get(position) + "Title");
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        protected TextView vTitle;
        protected TextView vSubTitle;
        public DataHolder(View itemView) {
            super(itemView);
            vTitle = (TextView)itemView.findViewById(R.id.item_title);
            vSubTitle = (TextView)itemView.findViewById(R.id.item_sub_title);
        }
    }
}