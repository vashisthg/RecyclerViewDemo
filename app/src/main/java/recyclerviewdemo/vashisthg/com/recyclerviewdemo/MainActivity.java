package recyclerviewdemo.vashisthg.com.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.recycler_view) RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdapter();
        mAdapter.setDataList(getMockData());
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Data> getMockData() {
        List<Data> dataList = new ArrayList<Data>();
        for(int i = 0; i < 10; i++) {
            Data data = new Data();
            data.setTitle("Title " + i);
            data.setMessage("message " + i);
            dataList.add(data);
        }
        return dataList;
    }
}
