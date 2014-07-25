package recyclerviewdemo.vashisthg.com.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by vashisthg on 25/07/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String LOGTAG = "RECYCLER_VIEW";

    private List<Data> mDataList;

    public RecyclerViewAdapter() {
        mDataList = new ArrayList<Data>();
    }

    public void setDataList(List<Data> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Data data = mDataList.get(position);
        viewHolder.title.setText(data.getTitle());
        viewHolder.message.setText(data.getMessage());
    }

    @Override
    public int getItemCount() {
        Log.d(LOGTAG, "item count: " + mDataList.size());
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.item_title) TextView title;
        @InjectView(R.id.item_message) TextView message;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
