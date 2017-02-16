package reynoldstitko.gillian;

import java.util.ArrayList;

/**
 * Created by gillianreynolds-titko on 2/15/17.
 */
public class Controller {

    public TimeParser timeParser = new TimeParser();
    private Display display = new Display();
    private String timeType = "";
    private String timeInput = "";


    public void askUserForTimeType() throws StringParseError{
        timeType = display.askUserForTime("Choose standard (S) or military time (M) (0100-2400): ");
        if(timeType.toUpperCase().equals("S")){
            askUserForStandardTimeInput();
        } else {
            askUserForMilitaryTimeInput();
        }
    }

    public void askUserForStandardTimeInput() throws StringParseError{
        timeInput = display.askUserForTime("What standard time do you want to convert? ");
        ArrayList<String> result = timeParser.parseStandardTime(timeInput);
        timeParser.standardTimeTranslatedToWords(result);
    }

    public void askUserForMilitaryTimeInput() throws StringParseError{
        timeInput = display.askUserForTime("What military time do you want to convert? ");
        ArrayList<String> result = timeParser.parseMilitaryTime(timeInput);
        timeParser.militaryTimeTranslatedToWords(result);
    }

}
