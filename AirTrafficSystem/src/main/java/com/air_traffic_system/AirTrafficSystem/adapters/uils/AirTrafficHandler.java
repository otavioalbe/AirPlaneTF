package com.air_traffic_system.AirTrafficSystem.adapters.uils;

import java.util.Calendar;
import java.util.Date;

public abstract class AirTrafficHandler {
  public static boolean isSameDay(Date date1, Date date2) {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date1);

    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(date2);
    
    return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) && 
      calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) && 
      calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
  }

  public static int getHourOfDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return calendar.get(Calendar.HOUR);
  }

  public static Date addHour(Date date, int hours) {
    Calendar calendar = Calendar.getInstance();
    
    calendar.setTime(date);
    calendar.add(Calendar.HOUR_OF_DAY, hours);
    
    return calendar.getTime();
  }

  public static boolean checkTimeInterval(int hourOfDay, int startHour, int hours) {
    return hourOfDay > startHour && hourOfDay < startHour + hours;
  }

  public static double calculateDistance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {
    final int R = 6371;

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
      + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
      * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  
    return R * c;
  }
}
