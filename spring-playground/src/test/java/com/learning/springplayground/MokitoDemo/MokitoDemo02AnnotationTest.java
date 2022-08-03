package com.learning.springplayground.MokitoDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MokitoDemo02AnnotationTest {

    @Mock
    DataService dataServicemock;
    @InjectMocks
    MokitoDemo01 businessLogic;

    @Test
    public void testFindGreatestFromAllData() {
        when(dataServicemock.retrieveAllData()).thenReturn(new int[] {24,15,3});
        assertEquals(24, businessLogic.findGreatestFromAllData());
    }


    @Test
    public void testFindGreatestWith1elementFromAllData() {
        when(dataServicemock.retrieveAllData()).thenReturn(new int[] {15});
        assertEquals(15, businessLogic.findGreatestFromAllData());
    }

    @Test
    public void testFindGreatestWith0elementFromAllData() {
        when(dataServicemock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessLogic.findGreatestFromAllData());
    }

}