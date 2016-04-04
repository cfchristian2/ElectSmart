package com.electsmart.electsmart.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Activities.CandidateActivity;
import com.electsmart.electsmart.Activities.ElectionActivity;
import com.electsmart.electsmart.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by brand on 3/15/2016.
 */
public class ElectionAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> openPositions; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Candidate>> candidates;

    public ElectionAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<Candidate>> listChildData) {
        this._context = context;
        this.openPositions = listDataHeader;
        this.candidates = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.candidates.get(this.openPositions.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = ((Candidate) getChild(groupPosition, childPosition)).getName();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            System.out.println("Attempt to get listview_row");
            convertView = infalInflater.inflate(R.layout.election_view_candidate_listview_row, null);
        }

        convertView.findViewById(R.id.candidates).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context, CandidateActivity.class);
                Candidate c = candidates.get(getGroup(groupPosition)).get(childPosition);
                if(c != null) {
                    intent.putExtra("candidate", c);
                    _context.startActivity(intent);
                }
            }
        });

        TextView candidateName = (TextView) convertView
                .findViewById(R.id.candidateName);

        candidateName.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.candidates.get(this.openPositions.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.openPositions.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.openPositions.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            System.out.println("Attempt to get group");
            convertView = infalInflater.inflate(R.layout.election_view_open_position_group, null);
        }

        TextView openPosition = (TextView) convertView
                .findViewById(R.id.openPosition);
        openPosition.setTypeface(null, Typeface.BOLD);
        openPosition.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}