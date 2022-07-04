package com.bdd.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {
    public static void main(String args[]){
        getExpectedDats("06/30/2022");
    }

    public String getExpectedDays(String actualDate){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        int res =0;
        try {
            Date dateApres = new Date();
            Date dateAvant= sdf.parse(actualDate);
            long diff = dateApres.getTime() - dateAvant.getTime();
            res = (int) (diff / (1000*60*60*24));
            System.out.println("Number of days between the two dates is: "+res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(res);
    }
}
