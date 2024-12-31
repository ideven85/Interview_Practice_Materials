package com.cleo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelingSalesman {

	static int[][] distances = {
			{0, 10, 15, 20},
			{10, 0, 35, 25},
			{15, 35, 0, 30},
			{20, 25, 30, 0}
	};

	static int numCities = distances.length;

	public static List<Integer> solveTSP() {
		int[] cities = new int[numCities];
		for (int i = 0; i < numCities; i++) {
			cities[i] = i;
		}

		List<Integer> optimalOrder = new ArrayList<>();
		int[] minDistance = {Integer.MAX_VALUE};

		permute(cities, 0, minDistance, optimalOrder);

		return optimalOrder;
	}

	private static void permute(int[] cities, int start, int[] minDistance, List<Integer> optimalOrder) {
		if (start == numCities - 1) {
			int currentDistance = calculateTotalDistance(cities);
			if (currentDistance < minDistance[0]) {
				minDistance[0] = currentDistance;
				optimalOrder.clear();
				optimalOrder.addAll(Arrays.asList(Arrays.stream(cities).boxed().toArray(Integer[]::new)));
			}
		} else {
			for (int i = start; i < numCities; i++) {
				swap(cities, start, i);
				permute(cities, start + 1, minDistance, optimalOrder);
				swap(cities, start, i);  // backtrack
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int calculateTotalDistance(int[] order) {
		int totalDistance = 0;
		for (int i = 0; i < numCities - 1; i++) {
			totalDistance += distances[order[i]][order[i + 1]];
		}
		totalDistance += distances[order[numCities - 1]][order[0]];  // Return to the starting city
		return totalDistance;
	}

	public static void main(String[] args) {
		List<Integer> optimalOrder = solveTSP();
		System.out.println("Optimal Order: " + optimalOrder);
		System.out.println("Minimum Distance: " + calculateTotalDistance(optimalOrder.stream().mapToInt(i -> i).toArray()));
	}
}
