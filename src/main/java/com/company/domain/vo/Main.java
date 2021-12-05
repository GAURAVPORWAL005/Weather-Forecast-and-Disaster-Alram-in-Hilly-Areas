package com.company.domain.vo;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.company.domain.tech.extra.Condition;
import com.company.domain.tech.extra.Current;
import com.company.domain.tech.extra.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Enter the name of the place you want the data of :");
        Scanner scanner = new Scanner(System.in);
        String LOCATION = scanner.nextLine().trim();

        final String API_KEY = "56a1d24bcadb448897890636211910";
        var url = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + LOCATION + "&aqi=yes";

        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Api is working properly with status code: " + response.statusCode());
        // System.out.println(response.body());


        // jackson


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Root rootObj = objectMapper.readValue((response.body()), Root.class);
            //Print info directly


            String etc = "";
            //works infinitely until user do not enter "7" to exit the system
            System.out.printf("\n\n%4s*************************************************************\n", etc);
            System.out.printf("%4s*%59s*\n", etc, etc);
            System.out.printf("%4s*---------!! WEATHER FORECAST AND DISASTER ALARM !!---------*\n", etc);
            System.out.printf("%4s*%59s*\n", etc, etc);
            System.out.printf("%4s*************************************************************\n", etc);
            System.out.println("\n");


            System.out.println("   =====================================================");


            System.out.println("       ####### Current Forecasting Location #######");

            System.out.println("   =====================================================");
            System.out.println("\n");


            System.out.println("  * Location Name : " + rootObj.getLocation().getName());
            System.out.println("  * Location Region : " + rootObj.getLocation().getRegion());
            System.out.println("  * Location Country : " + rootObj.getLocation().getCountry());
            System.out.println("  * Location latitude : " + rootObj.getLocation().getLat());
            System.out.println("  * Location longitude : " + rootObj.getLocation().getLon());
            System.out.println("  * Location local time : " + rootObj.getLocation().getLocaltime());
            System.out.println("\n");


            //parsing nested list
            System.out.println("   =====================================================");

            System.out.println("       ####### Current Weather #######");

            System.out.println("   =====================================================");
            System.out.println("\n");

            System.out.println("  * Is Day : " + rootObj.getCurrent().getIs_day());
            System.out.println("  * Humidity : " + rootObj.getCurrent().getHumidity() + " %");
            System.out.println("  * Rainfall in mm : " + rootObj.getCurrent().getPrecip_mm() + " mm");
            System.out.println("  * Rainfall in inch : " + rootObj.getCurrent().getPrecip_in() + " inch");
            System.out.println("  * Cloud : " + rootObj.getCurrent().getCloud());


            //  System.out.println("Wind Speed in MPH : " + rootObj.getCurrent().getWind_mph() + " M/h");
            System.out.println("  * Wind speed in KPH : " + rootObj.getCurrent().getWind_kph() + " Km/h");
            //  System.out.println("Wind Degree : " + rootObj.getCurrent().getWind_degree());
            System.out.println("  * Wind Direction : " + rootObj.getCurrent().getWind_dir());
            System.out.println("  * Pressure in pascal : " + rootObj.getCurrent().getPressure_mb() + " mbar");
            System.out.println("  * Feels like in celsius : " + rootObj.getCurrent().getFeelslike_c() + "°C");
            System.out.println("  * Feels like Fahrenheit : " + rootObj.getCurrent().getFeelslike_f() + "°F");
            System.out.println("  * Vis in km " + rootObj.getCurrent().getVis_km());
            //  System.out.println("Vis in Miles : " + rootObj.getCurrent().getVis_miles());
            System.out.println("  * UV of the Place : " + rootObj.getCurrent().getUv());
            System.out.println("  * Gust in KPH : " + rootObj.getCurrent().getGust_kph() + " Km/h");
            //  System.out.println("Gust in MPH : " + rootObj.getCurrent().getGust_mph());
            System.out.println("  * Temperature in celsius : " + rootObj.getCurrent().getTemp_c() + "°C");
            System.out.println("  * Temperature in fahrenheit : " + rootObj.getCurrent().getTemp_f() + "°F");
            System.out.println("  * Last Updated : " + rootObj.getCurrent().getLast_updated());
            // System.out.println("Last Updated : " + rootObj.getCurrent().getLast_updated_epoch());
            System.out.println("\n");


            System.out.println("   =====================================================");

            System.out.println("       ####### Condition of Weather #######");

            System.out.println("   =====================================================");
            System.out.println("\n");


            // System.out.println("Temperature : " + rootObj.getCurrent().getCondition().getIcon());
            System.out.println("  * Condition of Place : " + rootObj.getCurrent().getCondition().getText() + " Weather");
            System.out.println("  * Code : " + rootObj.getCurrent().getCondition().getCode());
            System.out.println("\n");


            System.out.println("   =====================================================");

            System.out.println("       #######  Air Quality of Location #######");

            System.out.println("   =====================================================");
            System.out.println("\n");


            System.out.println("  * Co : " + rootObj.getCurrent().getAir_quality().getCo() + " %");
            System.out.println("  * No2 : " + rootObj.getCurrent().getAir_quality().getNo2() + " %");
            System.out.println("  * o3 : " + rootObj.getCurrent().getAir_quality().getO3() + " %");
            System.out.println("  * So2 : " + rootObj.getCurrent().getAir_quality().getSo2() + " %");
            //  System.out.println("pm10 : " + rootObj.getCurrent().getAir_quality().getPm10());
            // System.out.println("pm2_5 : " + rootObj.getCurrent().getAir_quality().getPm2_5());
            System.out.println("  * US EPA Index : " + rootObj.getCurrent().getAir_quality().getUsEpaIndex());
            //System.out.println("gb defra index : " + rootObj.getCurrent().getAir_quality().getGbDefraIndex());

            if (rootObj.getCurrent().getHumidity() < 80 && rootObj.getCurrent().getPrecip_mm() < 70 && rootObj.getCurrent().getWind_kph() < 13) {
//                        System.out.println("====================================");
//                        System.out.println(LOCATION  + " is SAFE to travel" );
//                        System.out.println("====================================");

                System.out.printf("\n\n%4s*************************************************************\n", etc);
                System.out.printf("%4s*%59s*\n", etc, etc);
                System.out.printf("%4s*-----------------!! " + LOCATION + " is SAFE to Travel!!--------------*\n", etc);
                System.out.printf("%4s*%59s*\n", etc, etc);
                System.out.printf("%4s*************************************************************\n", etc);

            } else {
//                    System.out.println("====================================");
//                    System.out.println("Danger " + LOCATION  +  " is not SAFE to travel:");
//                    System.out.println("====================================");

                System.out.printf("\n\n%4s*************************************************************\n", etc);
                System.out.printf("%4s*%59s*\n", etc, etc);
                System.out.printf("%4s*---------------!! " + LOCATION + " is not SAFE to travel!!-------------*\n", etc);
                System.out.printf("%4s*%59s*\n", etc, etc);
                System.out.printf("%4s*************************************************************\n", etc);


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


