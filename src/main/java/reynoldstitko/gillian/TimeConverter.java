package reynoldstitko.gillian;

import com.sun.javafx.css.CssError;

import java.util.ArrayList;

/**
 * Created by gillianreynolds-titko on 2/13/17.
 */
abstract class TimeConverter {
    public abstract ArrayList<String> parseStandardTime(String inputTime) throws StringParseError;
    public abstract String translateHours(ArrayList<String> hoursToTranslate);
    public abstract String translateMinutes(ArrayList<String> minutesToTranslate);
    public abstract void standardTimeTranslatedToWords(ArrayList<String> timeToTranslate);
}
