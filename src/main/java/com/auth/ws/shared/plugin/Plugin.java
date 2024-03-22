package com.auth.ws.shared.plugin;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.joda.time.format.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Plugin {

    public static Date stringToDate(String date) {
        List<String> patternList = Arrays.asList("dd/MM/yyyy", "dd.MM.yyyy", "MM/dd/yyyy", "MM.dd.yyyy", "yyyy-MM-dd", "yyyy", "MM-yyyy","MM/yyyy","MM.yyyy");
        for (String pattern : patternList) {
            try {
                return DateTimeFormat.forPattern(pattern).parseLocalDate(date).toDate();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Float stringToFloat(String text) {
        try {
            return Float.parseFloat(text);
        } catch (Exception e) {
        }
        return null;
    }

    public static String openAiString(String text) {
        try {
            if(text.equals("null") || text.equals(""))
                return null;
            else
                return text;
        } catch (Exception e) {
        }
        return null;
    }
}
