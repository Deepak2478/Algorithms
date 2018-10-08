package com.deep.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {

	  public static void main(String[] args) {
	    Integer[] weightArr = new Integer[] { 10, 20, 30 };
	    Integer[] profitArr = new Integer[] { 60, 100, 20 };
	    String[] items = new String[] { "A", "B", "C" };
	    int maxWt = 50;
	    int n = weightArr.length;
	    Map<String, Integer> profitWithItems = new HashMap<>();
	    Map<String, Integer> profits = new HashMap<>();
	    Map<String, Integer> weightWithItems = new HashMap<>();
	    Map<String, Integer> weights = new HashMap<>();
	    Map<String, String> optimumSolution = new HashMap<>();
	    for (int i = 0; i < n; i++) {
	      weights.put(items[i], weightArr[i]);
	      profits.put(items[i], profitArr[i]);
	    }
	    optimumItems(weights, profits, profitWithItems, weightWithItems, optimumSolution,
	        items, maxWt);
	    System.out.println(profitWithItems);
	  }

	  private static void optimumItems(Map<String, Integer> weights,
	      Map<String, Integer> profits, Map<String, Integer> profitWithItems,
	      Map<String, Integer> weightWithItems, Map<String, String> optimumSolution,
	      String[] consideredItems, Integer maxWt) {
	    if (profitWithItems.get(strOut(consideredItems)) != null) {
	      return;
	    }
	    if (consideredItems.length == 1) {
	      if (weights.get(consideredItems[0]) <= maxWt) {
	        profitWithItems
	            .put(strOut(consideredItems), profits.get(strOut(consideredItems)));
	        weightWithItems
	            .put(strOut(consideredItems), weights.get(strOut(consideredItems)));
	        optimumSolution.put(strOut(consideredItems), strOut(consideredItems));
	      } else {
	        profitWithItems.put(strOut(consideredItems), -1);
	        weightWithItems.put(strOut(consideredItems), -1);
	        optimumSolution.put(strOut(consideredItems), "");
	      }
	      return;
	    }
	    int thisProfit = -1, thisWeight = -1;
	    String thisSoln = "";
	    for (int i = 0; i < consideredItems.length; i++) {
	      String[] newItems = new String[consideredItems.length - 1];
	      String[] leftOutItem = new String[1];
	      int x = 0;
	      inner:
	      for (int j = 0; j < consideredItems.length; j++) {
	        if (i == j) {
	          leftOutItem[0] = consideredItems[j];
	          continue inner;
	        }
	        newItems[x++] = consideredItems[j];
	      }
	      optimumItems(weights, profits, profitWithItems, weightWithItems, optimumSolution,
	          leftOutItem, maxWt);
	      optimumItems(weights, profits, profitWithItems, weightWithItems, optimumSolution,
	          newItems, maxWt);
	      Integer profit = null, weight = null;
	      String optSol = null;
	      Integer wtOfNewItems = weightWithItems.get(strOut(newItems)), wtOfLeftOutItems =
	          weightWithItems.get(strOut(leftOutItem));
	      // if the items are considerable, then only consider them for calculating maxProfit
	      if (profitWithItems.get(strOut(leftOutItem)) == -1
	          && profitWithItems.get(strOut(newItems)) == -1) {
	        profit = -1;
	        weight = -1;
	        optSol = "";
	      } else if (profitWithItems.get(strOut(leftOutItem)) == -1) {
	        profit = profitWithItems.get(strOut(newItems));
	        weight = weightWithItems.get(strOut(newItems));
	        optSol = strOut(newItems);
	      } else if (profitWithItems.get(strOut(newItems)) == -1) {
	        profit = profitWithItems.get(strOut(leftOutItem));
	        weight = weightWithItems.get(strOut(leftOutItem));
	        optSol = strOut(leftOutItem);
	      } else {
	        if (wtOfLeftOutItems + wtOfNewItems <= maxWt) {
	          profit = profitWithItems.get(strOut(newItems)) + profitWithItems
	              .get(strOut(leftOutItem));
	          weight = wtOfLeftOutItems + wtOfNewItems;
	          optSol = strOut(consideredItems);
	        } else if (profitWithItems.get(strOut(newItems)) > profitWithItems
	            .get(strOut(leftOutItem))) {
	          profit = profitWithItems.get(strOut(newItems));
	          weight = weightWithItems.get(strOut(newItems));
	          optSol = strOut(newItems);
	        } else {
	          profit = profitWithItems.get(strOut(leftOutItem));
	          weight = weightWithItems.get(strOut(leftOutItem));
	          optSol = strOut(leftOutItem);
	        }
	      }
	      if (profit > thisProfit) {
	        thisProfit = profit;
	        thisWeight = weight;
	        thisSoln = optSol;
	      }
	    }
	    weightWithItems.put(strOut(consideredItems), thisWeight);
	    profitWithItems.put(strOut(consideredItems), thisProfit);
	    optimumSolution.put(strOut(consideredItems), thisSoln);
	  }

	  private static String strOut(String[] str) {
	    StringBuilder s = new StringBuilder(str.length);
	    for (String x : str) {
	      s.append(x);
	    }
	    return s.toString();
	  }

}
