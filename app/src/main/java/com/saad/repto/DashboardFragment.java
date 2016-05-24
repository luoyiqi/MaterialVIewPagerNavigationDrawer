package com.saad.repto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.saad.repto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saad on 5/24/16.
 */

public class DashboardFragment extends Fragment {

    NewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //   return inflater.inflate(R.layout.sent_layout,null);
        View view = inflater.inflate(R.layout.dashboard_layout, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        List<String> list = new ArrayList<String>();
        for (int i = 0; i < VersionModel.data.length; i++) {
            list.add(VersionModel.data[i]);
        }


        adapter = new NewAdapter(list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}




