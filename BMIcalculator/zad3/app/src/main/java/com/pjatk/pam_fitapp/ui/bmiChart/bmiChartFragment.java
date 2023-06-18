package com.pjatk.pam_fitapp.ui.bmiChart;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.pjatk.pam_fitapp.R;

import java.util.ArrayList;
import java.util.List;

public class bmiChartFragment extends Fragment {
    private LineChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_bmichart, container, false);

        mChart = view.findViewById(R.id.chartBmi);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 19.5f));
        entries.add(new Entry(1, 18.5f));
        entries.add(new Entry(2, 19.7f));
        entries.add(new Entry(3, 19.4f));
        entries.add(new Entry(4, 20.2f));
        entries.add(new Entry(5, 20.6f));

        LineDataSet dataSet = new LineDataSet(entries, "BMI chart");
        dataSet.setColor(Color.GREEN);
        dataSet.setLineWidth(3f);
        dataSet.setCircleRadius(3.5f);
        LineData lineData = new LineData(dataSet);
        mChart.setData(lineData);

        Description desc = new Description();
        desc.setText("Zmiany BMI");
        mChart.setDescription(desc);

        mChart.invalidate();

        return view;
    }
}

