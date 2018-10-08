package com.deep.search.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OverlapingIntervals {

	ArrayList<Interval> findOverlap(ArrayList<Interval> intervals){
		
		Collections.sort(intervals, new Comparator() {
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				Interval i1 = (Interval)o1;
				Interval i2 = (Interval)o2;
				return i1.start - i2.start;
			}
		});
		ArrayList<Interval> overlapedintervals  = new ArrayList<Interval>();
		Interval firstInterval = intervals.get(0);
		int start = firstInterval.start;
		int end = firstInterval.end;
		for(int i=1; i< intervals.size();i++){
			Interval currentInterval = intervals.get(i);
			if(currentInterval.start <= end)
			{
				end = Math.max(end,currentInterval.end);
			}
			else{
				overlapedintervals.add(currentInterval);
			}
		}
		overlapedintervals.add(new Interval(start,end));
		return overlapedintervals;
	}
}
