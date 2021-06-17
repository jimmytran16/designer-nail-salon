package com.web.designernails.Util;

public class Conversions {
      // function to convert Military time to Standard time
      public static String convertMilitaryToStandardTime(String time) {
    	
    	try {
            // reformat the date to respective 
            time = cleanUpDateToCorrectFormat(time);
            System.out.println("The time " + time);
            // get the hour of the time
            String splitTime[] = time.split(":");
            int HOUR = Integer.valueOf(splitTime[0]);

            // check if the time is in military, if greater than 12, then it is a mil time
            // give it the right standard time
            if (HOUR > 12) {
                String refineHour;
                switch (HOUR) {
                    case 13:
                        refineHour = "1";
                        break;
                    case 14:
                        refineHour = "2";
                        break;
                    case 15:
                        refineHour = "3";
                        break;
                    case 16:
                        refineHour = "4";
                        break;
                    case 17:
                        refineHour = "5";
                        break;
                    case 18:
                        refineHour = "6";
                        break;
                    case 19:
                        refineHour = "7";
                        break;
                    default:
                        refineHour = String.valueOf(HOUR);
                        break;
                }
                return new String(refineHour + ":" + splitTime[1] + "PM"); // return the standard time
            }
            return time  + ((HOUR==12) ? "PM" : "AM"); // return the time if the time is not military
    	}catch(Exception e) {
    		return "" + e;
    	}   	
    }

    // 
    private static String cleanUpDateToCorrectFormat(String date) {
        return date.split(" ")[0];
    }
}