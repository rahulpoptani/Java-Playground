package com.learning.springplayground.MokitoDemo;

public class MokitoDemo01 {
    private DataService dataService;

    public MokitoDemo01(DataService dataService) {
        this.dataService = dataService;
    }

    int findGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for (int value : data) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;

    }
}


