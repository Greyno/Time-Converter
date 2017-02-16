package reynoldstitko.gillian;

import java.util.ArrayList;

/**
 * Created by gillianreynolds-titko on 2/15/17.
 */
public class Controller {

    private Display display = new Display();
    public TimeParser timeParser = new TimeParser();
    private String timeType = "";
    private String standardTimeType;
    private String militaryTimeType;


    public void askUserForTimeType() throws StringParseError{
        timeType = display.askUserForTime("Choose standard (S) or military time (M) (0100-2400): ");
        if(timeType.toUpperCase().equals("S")){
            askUserForStandardTimeInput();
        } else {
            askUserForMilitaryTimeInput();
        }
    }

    public void askUserForStandardTimeInput() throws StringParseError{
        standardTimeType = display.askUserForTime("What standard time do you want to convert? ");
        ArrayList<String> result = timeParser.parseStandardTime(standardTimeType);
        timeParser.standardTimeTranslatedToWords(result);
    }

    public void askUserForMilitaryTimeInput() throws StringParseError{
        standardTimeType = display.askUserForTime("What military time do you want to convert? ");
        ArrayList<String> result = timeParser.parseMilitaryTime(standardTimeType);
        timeParser.militaryTimeTranslatedToWords(result);
    }

}
