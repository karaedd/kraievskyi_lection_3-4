package com.kraievskyi.lection.task1.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFormatter {
    private static final String NAME = "\\s(name\\s*=\\s*\"\\W*)\"";
    private static final String SURNAME = "(\\ssurname\\s*=\\s*\")(\\W*\")";
    private static final String MATCHER = "[\\W\\S]*?/>";
    private static final String REPLACEMENT = "name\\s*=\\s*\"\\W*\"";

    public String formatFile(String input) {
        StringBuilder output = new StringBuilder();

        Matcher matcher = Pattern.compile(MATCHER).matcher(input);
        while (matcher.find()) {
            String person = matcher.group();
            Matcher nameMatcher = Pattern.compile(NAME).matcher(person);
            Matcher surnameMatcher = Pattern.compile(SURNAME).matcher(person);
            while (nameMatcher.find() && surnameMatcher.find()) {
                output.append(person.replaceAll(SURNAME, "")
                        .replaceAll(REPLACEMENT, nameMatcher.group(1)
                                + " " + surnameMatcher.group(2)));
            }
        }
        return output
                .append("\n")
                .append("</persons>")
                .append("\n")
                .toString();
    }
}
