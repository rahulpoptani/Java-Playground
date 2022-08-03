package com.learning.springplayground.MokitoDemo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MokitoDemo01Test {

    @Test
    public void testFindGreatestFromAllData() {
        DataService dataServicemock = mock(DataService.class);
        when(dataServicemock.retrieveAllData()).thenReturn(new int[] {24,15,3});

        MokitoDemo01 businessLogic = new MokitoDemo01(dataServicemock);

        int result = businessLogic.findGreatestFromAllData();
        assertEquals(24, result);
    }


    @Test
    public void testFindGreatestWith1elementFromAllData() {
        DataService dataServicemock = mock(DataService.class);
        when(dataServicemock.retrieveAllData()).thenReturn(new int[] {15});

        MokitoDemo01 businessLogic = new MokitoDemo01(dataServicemock);

        int result = businessLogic.findGreatestFromAllData();
        assertEquals(15, result);
    }

}