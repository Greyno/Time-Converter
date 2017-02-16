package reynoldstitko.gillian;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gillianreynolds-titko on 2/13/17.
 */
public class TimeParser  {

    private ArrayList<String> timeStrings = new ArrayList<>();
    private String timeOfDay="";

    public ArrayList<String> parseStandardTime(String inputTime) throws StringParseError {

        //String matcherText = "([0-9][0-9])([:])([0-9])([0-9])(([pP]|[aA])[mM])"; //match 01:23PpM to [01, :, 2, 3, PM]
        String matcherText = "([0-9][0-9])([:])([0-9][0-9])(([pP]|[aA])[mM])"; //match 01:23PpM to [01, :, 23, PM]
        //String matcherText = "([0-9*][0-9])([:])([0-9][0-9])(([pP]|[aA])[mM])";
        Pattern p = Pattern.compile(matcherText);
        //do first w/o a try/catch block
        try{
            Matcher m = p.matcher(inputTime); //attempt to match the entire input sequence against the pattern
            if(m.find()){
                timeStrings.add(m.group(1)); //Group 1 returns hours
                //timeStrings.add(m.group(2)); //Group 2 returns the : separator - not really needed
                timeStrings.add(m.group(3)); //Group 3 returns the minutes
                timeStrings.add(m.group(4)); //Group 4 returns the AM/PM
            }  else
                throw new StringParseError();
        } catch (StringParseError e) {
            System.out.println("Improper input string");
        }
        return timeStrings; //returning [01, 25, PM]
    }

    public ArrayList<String> parseMilitaryTime(String inputTime) throws StringParseError {

        String matcherText = "([0-9][0-9])([0-9][0-9])"; //match 2400
        Pattern p = Pattern.compile(matcherText);
        //do first w/o a try/catch block
        try{
            Matcher m = p.matcher(inputTime); //attempt to match the entire input sequence against the pattern
            if(m.find()){
                timeStrings.add(m.group(1)); //Group 1 returns hours
                timeStrings.add(m.group(2)); //Group 2 returns the minutes
            }  else
                throw new StringParseError();
        } catch (StringParseError e) {
            System.out.println("Improper input string");
        }
        return timeStrings; //returning [12,00]
    }

    public String translateHours(ArrayList<String> hourToTranslate) {
        String returnValue =  hourToTranslate.get(0);
        String outputText = "";
        int numberVersion = Integer.parseInt(returnValue);
        if(numberVersion > 12){
            Integer returnNumber = numberVersion - 12;
            outputText = Integer.toString(returnNumber);
            outputText = translateStringText(outputText);
            timeOfDay = "PM";
            return outputText;
        } else {
            outputText = translateStringText(hourToTranslate.get(0));
            timeOfDay = "AM";
            return outputText;
        }
    }

//    @Override
//    public String translateHours(ArrayList<String> hourToTranslate) {
//        hourToTranslate.get(0);
//        String outputText = translateStringText(hourToTranslate.get(0)); //capture the hour component of the regex (group 1)
//        return outputText;
//    }

    public String translateStringText(String timeToTranslate) {
        String outputText = "";
        switch (timeToTranslate) {
            case "00": outputText = ""; break;
            case "01":
            case "1":
                outputText = "one"; break;
            case "02":
            case "2":
                outputText = "two"; break;
            case "03":
            case "3":
                outputText = "three"; break;
            case "04":
            case "4":
                outputText = "four"; break;
            case "05":
            case "5":
                outputText = "five"; break;
            case "06":
            case "6":
                outputText =  "six"; break;
            case "07":
            case "7":
                outputText = "seven"; break;
            case "08":
            case "8":
                outputText = "eight"; break;
            case "09":
            case "9":
                outputText = "nine"; break;
            case "10":
                outputText =  "ten"; break;
            case "11":
                outputText =  "eleven"; break;
            case "12":
                outputText =  "twelve"; break;
            case "13":
                outputText =  "thirteen"; break;
            case "14":
                outputText =  "fourteen"; break;
            case "15":
                outputText =  "fifteen"; break;
            case "16":
                outputText =  "sixteen"; break;
            case "17":
                outputText =  "seventeen"; break;
            case "18":
                outputText =  "eighteen"; break;
            case "19":
                outputText =  "nineteen"; break;
            default:
                return timeToTranslate;
        } return outputText;
    }


    public String translateMinutes(ArrayList<String> minutesToTranslate) { //incoming array of form [01, 23, PM]
        String outputText = "";

        char firstMinuteComponent = minutesToTranslate.get(1).charAt(0); //Capture group 2 from RegEx
        char secondMinuteComponent = minutesToTranslate.get(1).charAt(1); //Capture group 2 from RegEx

        switch (firstMinuteComponent){
            case '0':
                outputText = Character.toString(firstMinuteComponent) + Character.toString(secondMinuteComponent);
                outputText = "o-"+translateStringText(outputText);
                return outputText;
            case '1':
                outputText = Character.toString(firstMinuteComponent) + Character.toString(secondMinuteComponent);
                outputText = translateStringText(outputText);
                return outputText;
            case '2':
                if(translateStringText(Character.toString(secondMinuteComponent)).equals("0")) {
                    outputText = "twenty";
                } else outputText = "twenty" + " "+ translateStringText(Character.toString(secondMinuteComponent));
                return outputText;
            case '3':
                if(translateStringText(Character.toString(secondMinuteComponent)).equals("0")) {
                    outputText = "thirty";
                } else outputText = "thirty" + " "+ translateStringText(Character.toString(secondMinuteComponent));
                return outputText;
            case '4': if(translateStringText(Character.toString(secondMinuteComponent)).equals("0")) {
                outputText = "forty";
            } else outputText = "forty" + " "+ translateStringText(Character.toString(secondMinuteComponent));
                return outputText;
            case '5': if(translateStringText(Character.toString(secondMinuteComponent)).equals("0")) {
                outputText = "fifty";
            } else outputText = "fifty" + " "+ translateStringText(Character.toString(secondMinuteComponent));
                return outputText;
            default: break;
        }
        return outputText;
    }

    public String convertTimeOfDay(ArrayList <String> timeToTranslate){
        timeOfDay = timeToTranslate.get(2).toUpperCase();
        if(timeOfDay.equals("PM")) {
            return "PM";
        } else return "AM";
    }


    public void standardTimeTranslatedToWords(ArrayList<String> timeToTranslate){
        String hourInWords = translateHours(timeToTranslate);
        String minutesInWords = translateMinutes(timeToTranslate);
        String timeOfDayInWords = convertTimeOfDay(timeToTranslate);
        System.out.print("The time is " + hourInWords + " " + minutesInWords + " " + timeOfDayInWords);
    }

    public void militaryTimeTranslatedToWords(ArrayList<String> timeToTranslate){
        String hourInWords = translateHours(timeToTranslate);
        String minutesInWords = translateMinutes(timeToTranslate);
        System.out.print("The time is " + hourInWords + " " + minutesInWords + " " + timeOfDay);
    }
}
