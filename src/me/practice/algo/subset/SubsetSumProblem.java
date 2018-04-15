package me.practice.algo.subset;

import java.util.HashMap;
import java.util.Map;

public class SubsetSumProblem {
	public int count(int[] arr, int T) {
		Map<String, Integer> mem = new HashMap<>();
		return this.count(arr, T, arr.length - 1, mem);
	}

	private int returnVal = 0;

	private int count(int[] arr, int T, int i, Map<String, Integer> mem) {
		String key = T + ":" + i;
		if (mem.containsKey(key))
			return mem.get(key);
		if (T == 0)
			return 1;
		else if (i < 0 || T < 0)
			return 0;
		else if (T < arr[i])
			returnVal = count(arr, T, i - 1, mem);
		else {
			returnVal = count(arr, T, i - 1, mem) + count(arr, T - arr[i], i - 1, mem);
		}
		mem.put(key, returnVal);
		return returnVal;
	}
}
