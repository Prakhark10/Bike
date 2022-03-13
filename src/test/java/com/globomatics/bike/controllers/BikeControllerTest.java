package com.globomatics.bike.controllers;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BikeControllerTest extends TestCase {

    @Mock
    BikeRepository bikeRepository;

    @InjectMocks
    BikeController bikeController;

    @Test
    public void testList() {
        List<Bike> bikeList = new ArrayList<>();
        Bike bike = new Bike();
        bike.setModel("Hero");
        bikeList.add(bike);
        when(bikeRepository.findAll()).thenReturn(bikeList);
        List<Bike> bikes = bikeController.list();
        assertEquals(bikes.get(0).getModel(), "Hero");
    }
}