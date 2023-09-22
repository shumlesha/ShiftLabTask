package com.example.shiftlabtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntervalProcessor {
    private static IntervalsRepository intervalRepository = null;

    @Autowired
    public IntervalProcessor(IntervalsRepository intervalRepository) {
        IntervalProcessor.intervalRepository = intervalRepository;
    }

    public static void processIntevals(List<CustomInterval> intervals) {
        int n = intervals.size();
        List<CustomInterval> result = new ArrayList<>();
        intervals.sort(new IntervalsComparator());

        for (int i = 0; i < n; i++) {
            if (result.isEmpty() || (result.get(result.size() - 1).getIntervalEnd()).compareTo(intervals.get(i).getIntervalBegin()) < 0) {
                result.add(intervals.get(i));
            } else {
                int tempvalue = (result.get(result.size() - 1).getIntervalEnd()).compareTo(intervals.get(i).getIntervalEnd());
                if (tempvalue < 0) {
                    result.get(result.size() - 1).setIntervalEnd(intervals.get(i).getIntervalEnd());
                } else {
                    result.get(result.size() - 1).setIntervalEnd(result.get(result.size() - 1).getIntervalEnd());
                }

            }
        }
        intervalRepository.saveAll(result);

    }
    public static CustomInterval getmin (String kind) {
        return intervalRepository.findminimalrange(kind);
    }
}







































