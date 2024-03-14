package com.openclassrooms.realestatemanager;

import static org.junit.Assert.assertEquals;

import com.openclassrooms.realestatemanager.utils.Utils;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsTest {


    @Test
    public void checkConvertDollarToEuro_correct(){
        int numberToConvert = 455;
        String numberToConvertAsString = Integer.toString(numberToConvert);
        assertEquals( numberToConvertAsString , Utils.convertDollarToEuro(500));


    }

    @Test
    public void checkConvertEuroToDollar_correct(){
        int numberToConvert = 540;
        String numberToConvertAsString = Integer.toString(numberToConvert);
        assertEquals( numberToConvertAsString , Utils.convertEuroToDollar(500));

    }

    @Test
    public void getTodayDateTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String actualDate = Utils.getTodayDate();
        assertEquals(dateFormat.format(new Date()), actualDate);
    }

}