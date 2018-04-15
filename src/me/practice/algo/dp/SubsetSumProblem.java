package me.practice.algo.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubsetSumProblem {
	private static int returnVal = 0;

	public static int dp(int[] arr, int total, int idx, Map<String, Integer> mem) {
		String key = String.valueOf(total) + ":" + String.valueOf(idx);

		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		if (idx < 0)
			return 0;
		if (total == 0)
			return 1;
		if (total < 0)
			return 0;
		else if (arr[idx] > total) {
			returnVal = dp(arr, total, idx - 1, mem);
		} else {
			returnVal = dp(arr, total - arr[idx], idx - 1, mem) + dp(arr, total, idx - 1, mem);
		}
		System.out.println(key + " : " + returnVal);
		mem.put(key, returnVal);

		return returnVal;
	}

	public static int countNoOfSubSets(int[] arr, int total) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < total) {
				int s = total - arr[i];
				if (set.contains(s)) {
					count++;
				}
				set.add(s);
				set.add(sum(arr, i));
			} else if (arr[i] == total) {
				count++;
			}
		}
		return count;
	}

	private static int sum(int[] arr, int i) {
		int sum = 0;
		while (i >= 0) {
			sum += arr[i];
			i--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 10 };
		int total = 16;
		int idx = arr.length - 1;
		Map<String, Integer> mem = new HashMap<>();
		int val = dp(arr, total, idx, mem);
		System.out.println(val);
		val = countNoOfSubSets(arr, total);
	}
}