import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        String Input = "I am Hamlet";
        String expected = "I am Leon";

        //When
        String actual = hamletParser.changeHamletToLeon(Input);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String Input ="Horatio Horatio Horatio";
        String  expected ="Tariq Tariq Tariq";

        //When
        String actual = hamletParser.changeHoratioToTariq(Input);

        //Then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testFindHoratio() {
        //Given
        String Input ="I am Horatio";
        Integer expected =1;

        //When
        Integer actual =hamletParser.findHoratio(Input);

        //Then

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testFindHamlet() {
        //Given

        String Input ="Hamlet Hamlet Hamlet";
        Integer expected =3;

        //When
        Integer actual = hamletParser.findHamlet(Input);

        //Then
        Assert.assertEquals(expected,actual);
    }
}