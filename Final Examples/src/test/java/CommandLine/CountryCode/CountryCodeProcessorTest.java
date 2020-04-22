package CommandLine.CountryCode;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CountryCodeProcessorTest {
    CountryCodeProcessor oneArgValid;
    CountryCodeProcessor oneArgInvalid;
    CountryCodeProcessor noArgs;
    ErrorLogger log;

    @Before
    public void setUp() throws Exception {
        String[] argsValid = new String[]{"test_files/valid_format.csv"};
        String[] argsInvalid = new String[]{"test_files/invalid_format.csv"};
        log = new ErrorLogger();
        oneArgValid = new CountryCodeProcessor(argsValid);
        oneArgInvalid = new CountryCodeProcessor(argsInvalid);
        noArgs = new CountryCodeProcessor(new String[]{});
    }

    @Test
    public void getCodes() {
        Map<String, String> valid = new HashMap<>();
        valid.put("C1","Country 1");
        valid.put("C2","2, Country");
        assertEquals(valid, oneArgValid.getCodes());
    }

    @Test
    public void getCodesInvalid() {
        Map<String, String> invalid = new HashMap<>();
        assertEquals(invalid, oneArgInvalid.getCodes());
    }

    @Test
    public void getLog() {
        log.log("Exactly one argument expected: the file path");
        assertEquals(log, noArgs.getLog());
    }

    @Test
    public void getLogValid() {
        assertEquals(log, oneArgValid.getLog());
    }

    @Test
    public void getLogInvalid() {
        assertEquals(log, oneArgInvalid.getLog());
    }
}