package me.practice.algo.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements ISort {

	@Override
	public void sort(List<Integer> list) {
		int[] arr = this.toArray(list);
		this.sort(arr, 0, arr.length-1);
		list = this.toList(arr);
	}
	
	private void sort(int[] arr, int start, int end) {
		if(start < end) {
			int pIndex = partitionIndex(arr, start, end);
			
			this.sort(arr, start, pIndex-1);
			this.sort(arr, pIndex+1, end);
		}
	}
	
	private List<Integer> toList(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(Integer i : arr) {
			list.add(i);
		}
		return list;
	}
	
	public int partitionIndex(int[] arr, int start, int end) {
		int pIndex = start;
		int pivot = arr[end];
		
		for(int i = start; i < end; i++) {
			if(arr[i] <= pivot && i != pIndex) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}
		swap(arr, pIndex, end);
		return pIndex;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private int[] toArray(List<Integer> list) {
		int[] arr = null;
		if(list == null) {
			arr = new int[0];
		} else {
			arr = new int[list.size()];
			int count = 0;
			for(int i : list) {
				arr[count++] = i;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		ISort sortingAlgo = new QuickSort();
		sortingAlgo.sort(list);
		printList(list);
	}
	
	private static final void printList(List<Integer> list) {
		for(Integer i : list)
			System.out.println(i);
	}
}
