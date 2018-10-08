package com.deep.search.sort;

import java.util.ArrayList;

public class CircusProblem<E> {
	ArrayList<E> items;
	ArrayList<E> lastFoundSeq;
	ArrayList<E> maxSeq;
	
	ArrayList<E> seqMaxWidthLength(ArrayList<E> seq1, ArrayList<E> seq2){
		return seq1.size() > seq2.size()? seq1:seq2;
	}
	
	int fillNextSeq(int startFrom, ArrayList<E> seq){
		int firstUnfitItem = startFrom;
		if(startFrom < items.size()){
			for(int i=0; i<items.size();i++){
				/*if(i==0 || (items.get(i - 1) < items.get(i))){
					seq.add(items.get(i));
				}*/
			}
		}
		return firstUnfitItem;
	}

}
