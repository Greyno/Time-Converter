package reynoldstitko.gillian;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;

/**
 * Created by gillianreynolds-titko on 2/13/17.
 */
public class TimeParserTest {

    TimeParser timeParser = new TimeParser();

    @Test
    public void translateHoursTest() {
        ArrayList<String> input = new ArrayList<>();
        input.add("13");
        input.add("23");
        String expected = "one";
        String actual = timeParser.translateHours(input);
        assertEquals("Expected the times to be equal", expected, actual);
        //returns string;
    }

    @Test //test any regex component
    public void translateTextTest(){
        ArrayList<String> input = new ArrayList<>();
        input.add("12");
        input.add("23");
        input.add("PM");
        String expected = "twelve";
        //String actual = timeParser.translateText(input, 1);
        String actual = timeParser.translateStringText(input.get(0));
        assertEquals("Expect strings to be equal", expected, actual);
    }

    @Test //test any regex component
    public void translateStringTextTest(){
        //String outputText = Character.toString('0') + Character.toString('3');
        String input = "02";
        String expected = "two";
        String actual = timeParser.translateStringText(input);
        assertEquals("Expect strings to be equal", expected, actual);
    }

    @Test
    public void translateMinutesTest() {
        ArrayList<String> input = new ArrayList<>();
        input.add("12");
        input.add("20");
        input.add("AM");
        String expected = "twenty";
        String actual = timeParser.translateMinutes(input);
        assertEquals("Expected the times to be equal", expected, actual);
        //returns string
    }

    @Test
    public void translateThirtyMinutesTest() {
        ArrayList<String> input = new ArrayList<>();
        input.add("12");
        input.add("30");
        input.add("AM");
        String expected = "thirty";
        String actual = timeParser.translateMinutes(input);
        assertEquals("Expected the times to be equal", expected, actual);
        //returns string
    }

    @Test
    public void translateFortyMinutesTest() {
        ArrayList<String> input = new ArrayList<>();
        input.add("12");
        input.add("40");
        input.add("AM");
        String expected = "forty";
        String actual = timeParser.translateMinutes(input);
        assertEquals("Expected the times to be equal", expected, actual);
        //returns string
    }

    @Test
    public void parseStandardTimeTest() throws StringParseError {
        String input = "01:05AM";
        ArrayList<String> expected = new ArrayList<>();
        expected.add("01");
        expected.add("05");
        expected.add("AM");
        ArrayList<String> actual = timeParser.parseStandardTime("01:05AM");
        assertEquals("Expected array values to be equal", expected, actual);
        //takes an input string, returns an ArrayList of strings
    }

    @Test
    public void parseMilitaryTimeTest() throws StringParseError {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("01");
        expected.add("00");
        ArrayList<String> actual = timeParser.parseMilitaryTime("0100");
        assertEquals("Expected array values to be equal", expected, actual);
        //takes an input string, returns an ArrayList of strings
    }

    @Test(expected = StringParseError.class) //expect an error
    public void cannotParseMilitaryTimeTest() throws StringParseError {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("0a");
        expected.add("00");
        ArrayList<String> actual = timeParser.parseMilitaryTime("0a00");
        assertEquals("Expected array values to be equal", expected, actual);
        //takes an input string, returns an ArrayList of strings
    }

    @Test(expected = StringParseError.class) //expect an error
    public void cannotParseTimeTest() throws StringParseError {
        String input = "01:0CAM";
        ArrayList<String> expected = new ArrayList<>();
        expected.add("01");
        expected.add(null);
        expected.add("AM");
        ArrayList<String> actual = timeParser.parseStandardTime("01:0CAM");
        assertEquals("Expected array values to be equal", expected, actual);
        //takes an input string, returns an ArrayList of strings
    }

    @Test
    public void convertTimeOfDay(){
        String expected = "AM";
        ArrayList<String> input = new ArrayList<>();
        input.add("01");
        input.add("05");
        input.add("am");
        String actual = timeParser.convertTimeOfDay(input);
        assertEquals("Expected to get AM", expected, actual);
    }

//    @Test
//    public void timeTranslatedToWordsTest(){
//        String expected = "The time is two 20 PM";
//        ArrayList<String> input = new ArrayList<>();
//        input.add("24");
//        input.add("05");
//        input.add("PM");
//        timeParser.standardTimeTranslatedToWords(input);
//
//    }
//
//    @Test
//    public void militaryTimeTranslatedToWordsTest(){
//        String expected = "The time is twelve o-five PM";
//        ArrayList<String> input = new ArrayList<>();
//        input.add("12");
//        input.add("05");
//        String actual = timeParser.militaryTimeTranslatedToWords(input);
//        assertEquals("Expected the strings to be equal", expected, actual);
//    }
}
