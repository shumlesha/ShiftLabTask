package com.example.shiftlabtask;

import java.util.Comparator;

public class IntervalsComparator implements Comparator<CustomInterval> {
    @Override
    public int compare(CustomInterval first, CustomInterval second) {
        return (first.getIntervalBegin()).compareTo(second.getIntervalBegin());
    }
}