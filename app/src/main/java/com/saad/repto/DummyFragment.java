package com.androidbelieve.repto;

/**
 * Created by saad on 5/22/16.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.saad.repto.R;
import com.saad.repto.SimpleRecyclerAdapter;
import com.saad.repto.VersionModel;
import com.saad.repto.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DummyFragment extends Fragment {


        int color;
        SimpleRecyclerAdapter adapter;

        public DummyFragment() {
        }

        @SuppressLint("ValidFragment")
        public DummyFragment(int color) {
            this.color = color;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.dummy_fragment, container, false);

            final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
            frameLayout.setBackgroundColor(color);
            //TextView text=(TextView) view.findViewById(R.id.listitem_name);

            final GestureDetector mGestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

            final ViewPager viewPager = (ViewPager)view. findViewById(R.id.tabanim_viewpager);
           setupViewPager(viewPager);

            TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabanim_tabs);
            tabLayout.setupWithViewPager(viewPager);

            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                    viewPager.setCurrentItem(tab.getPosition());

                    switch (tab.getPosition()) {
                        case 0:
                            Toast.makeText(getActivity(), "sd", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "sd2", Toast.LENGTH_SHORT).show();

                            break;
                        case 2:
                            Toast.makeText(getActivity(), "sd3", Toast.LENGTH_SHORT).show();

                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });




            recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                    View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                    if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                      //  Drawer.closeDrawers();
                        Toast.makeText(getActivity().getApplicationContext(), "saad" + " is selected!", Toast.LENGTH_SHORT).show();

                        return true;

                    }


                    return false;
                }

                @Override
                public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });



          /*  recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    //  Movie movie = movieList.get(position);

                    Intent intent=new Intent(getActivity(),TabVideoActivity.class);
                    startActivity(intent);

                    //  Toast.makeText(getActivity().getApplicationContext(), "saad" + " is selected!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
*/
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < VersionModel.data.length; i++) {
                list.add(VersionModel.data[i]);
            }




            adapter = new SimpleRecyclerAdapter(list);
            recyclerView.setAdapter(adapter);




            return view;
        }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.accent_material_light)), "Curriculum");
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.ripple_material_light)), "Description");
        adapter.addFrag(new DummyFragment(getResources().getColor(R.color.button_material_dark)), "Comments");
        viewPager.setAdapter(adapter);
    }


}

/*interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, ClickListener clickListener1) {
        clickListener = clickListener1;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }*/

