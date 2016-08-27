package com.example.ashutosh.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 28/7/16.
 */
public class DummyFragment extends Fragment {


    RecyclerView recyclerView;

    Person p;
    int start,end;
    View view;

    DummyFragment(Person person,int i, int j){
        this.p = person;
        this.start = i;
        this.end = j;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dummy_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RCAdapter adapterLog = new RCAdapter(p,start,end);

        recyclerView = (RecyclerView) view.findViewById(R.id.RCVIEW);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterLog);
    }

    static class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCViewHolder> {

        Person person;
        int start,end;

        /*String info[] = {person.getName(), person.getLastname(), person.getPhoneNumber(), person.getEmail(), person.getDob(),
                person.getCompany(), person.getTitle(), person.getIM(), person.getWebsite(), person.getOfficeAddress(),
                person.getNickname(), person.getBriefintro(), person.getFb(), person.getTwitter(), person.getInstagram()};
*/
        String titles[] = {"First Name", "Last Name", "Phone Number", "Email", "DOB", "Company", "Title", "IM", "Website", "Office Address", "Nickname", "Brief Intro", "Facebook", "Twitter", "Instagram"};

        public class RCViewHolder extends RecyclerView.ViewHolder {

            public TextView title, info;

            public RCViewHolder(View itemView) {
                super(itemView);

                title = (TextView) itemView.findViewById(R.id.cvTitle);
                info = (TextView) itemView.findViewById(R.id.cvInfo);
            }
        }

        RCAdapter(Person person, int s, int e){
            this.person = person;
            this.start = s;
            this.end = e;
        }

        @Override
        public RCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
            return new RCViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RCViewHolder holder, int position) {
            for (int i = start; i <= end; i++) {
                holder.title.setText(titles[i]);
  //              holder.info.setText(info[i]);
            }
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }

    }

}
