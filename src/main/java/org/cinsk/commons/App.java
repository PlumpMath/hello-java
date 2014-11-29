package org.cinsk.commons;

import java.util.*;
import java.io.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.commons.cli.*;

public class App {
    private static Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        CommandLineParser cliParser = new GnuParser();
        CommandLine cmd = null;
        Properties properties = new Properties();

        try {
            cmd = cliParser.parse(buildOptions(), args);
        }
        catch (ParseException e) {
            log.fatal("Option parsing failed: " + e.getMessage());
            System.exit(1);
        }

        if (cmd.hasOption("help")) {
            helpAndExit();
        }
        if (cmd.hasOption("properties")) {
            String propFilename = cmd.getOptionValue("properties");
            PropertyConfigurator.configure(propFilename);
            try {
                properties.load(new FileInputStream(new File(propFilename)));
            }
            catch (Exception e) {
                log.fatal("parsing failed for the property file: " +
                          e.getMessage());
                System.exit(1);
            }
        }
    }

    public static Options buildOptions() {
        Options spec = new Options();

        Option help = OptionBuilder
                .withDescription("show help and exit")
                .create("help");
        spec.addOption(help);

        Option properties = OptionBuilder.withArgName("properties")
                .hasArg()
                .withDescription("Properties for App")
                .create("properties");
        spec.addOption(properties);

        /*
        Options debug = OptionBuilder.withArgName("level")
                .hasArg()
                .withDescription("Debug level")
                .create("debug");
        */
        return spec;
    }

    public static void helpAndExit() {
        System.out.println("help message");
    }
}
