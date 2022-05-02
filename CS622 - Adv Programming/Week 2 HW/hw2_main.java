package week2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw2_main {
    // global list of all project IDs contained in the merge file (duplication removal list)
    public static ArrayList<String> projectID = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        // directory for the merged file to be placed
        String mergeFileLoc = "C:/Users/Andrew/IdeaProjects/CS622/src/week2/merged.csv";

        // creating a new file at the directory location
        File file = new File(mergeFileLoc);

        /**
         * Putting this if statement here. If the file does not exist, create it, then write to it.
         * Need to check if the file exists already. If it does, without this if statement, the file will
         * endlessly append to duplicate values. If the file does not exist, it will create it, and write to it.
         * The below code allows it to append once, then we can run the findItem to search multiple times, without
         * appending to the file multiple times getting larger each time.
         */
        if (file.exists() == false) {
            file.createNewFile();

            writeFile("C:/Users/Andrew/IdeaProjects/CS622/src/week2/Indiegogo1.csv",
                    mergeFileLoc);
            writeFile("C:/Users/Andrew/IdeaProjects/CS622/src/week2/Indiegogo2.csv",
                    mergeFileLoc);
        }

        // IMPORTANT: Changee this variable to search for specific items
        // storing our keyword to search through the file
        String keyword = "Robotics";

        // searches our merged file
        findItem(mergeFileLoc, keyword);
    }

    /**
     * Searches through a file for keywords. Displays the percent target goal and close date of a project, if the
     * project contains the keyword. Also displays the project ID to easily figure out which projects are matched
     * @param readDir - file directory to read from
     * @param keyWord - keyword to search for in the entries
     */
    public static void findItem(String readDir, String keyWord) {
        // stores the readDir of the file passed to the method
        String copyFile1 = readDir;
        // new bufferedreader
        BufferedReader br = null;

        // placeholder to store each line
        String line = "";

        System.out.println("Keyword to search for: " + keyWord);

        // create a new pattern to find decimal numbers; regular expression was tricky...
        // finds the decimal for percent to goal
        Pattern p = Pattern.compile("\",\"[0-9]+\\.[0-9]+\",\"");
        // finds the date time group for close date (and open date, open date gets filtered out by foundFirst)
        Pattern p2 = Pattern.compile("\",\"..........T..............\",\"");
        // project ID finder
        Pattern p3 = Pattern.compile("\",\"[0-9]+\",\"campaign\",\"");

        // new matcher object to use later
        Matcher m = null;

        // boolean foundFirst to flag when the first instance of regex above is found
        boolean foundFirst = false;

        // counts the number of matches
        int countMatches = 0;

        // formatting helpers
        String percentString = "";
        double percentFormatter = 0.0;
        DecimalFormat formatter = new DecimalFormat("#0.00");

        try {
            // sets the reader to read from our pathway
            br = new BufferedReader(new FileReader(copyFile1));

            // critical code: while the file still has lines, keep going through, line by line of the file
            while ((line = br.readLine()) != null) {

                // if the line contains our keyword, search it using the matcher
                if (line.contains(keyWord) == true) {
                    // counts the number of matches for display to user
                    countMatches++;

                    // sets the matcher equal to the line being looked at; regex expression 1 being searched for
                    m = p.matcher(line);

                    // when the matcher finds the right line, display the fund raised percent
                    while (m.find()) {

                        // formatting helpers; replace the "," in the found text
                        percentString = m.group().replace("\",\"", "");

                        // once the "," is removed, make it a double, and multiply by 100 for percentage
                        percentFormatter = Double.parseDouble(percentString) * 100; // format helper
                        System.out.print(countMatches + ": Fund raised percent: " +
                                formatter.format(percentFormatter) + "%\t\t");
                    }

                    // next, we look for the close date; set matcher to regex expression 2
                    m = p2.matcher(line);

                    // resets foundFirst to false
                    foundFirst = false;

                    // if the pattern matches, AND it's the first occurrence, print it out
                    while (m.find() && foundFirst == false) {

                        System.out.print("Close date: " +
                                m.group().replace("\",\"", "") + "\t\t");
                        // sets the foundFirst flag to true, so we don't get the open date
                        foundFirst = true;
                    }

                    // sets matcher to find project ID
                    m = p3.matcher(line);
                    // once project ID is found, print it out
                    while (m.find()) {
                        System.out.println("Project ID: " + m.group().replace("\",\"", "").replace("campaign", ""));
                    }
                }
            }
        }
        // catches error if the file does not exist
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // catches the error if the IO is incorrect
        catch (IOException e) {
            e.printStackTrace();
        }

        // final steps, try to close the writer/reader
        finally {
            // assuming the reader wasn't empty, try to close the reader
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Writes to a file. Needs a valid directory readDir passed to it as well as the file directory to write to.
     * Will append to a file, based on passed directory. Does not create a new file in a directory (file
     * must already exist). Does not overwrite file contents, but adds to them.
     * @param readDir - file directory path to read from
     * @param writeDir - file directory path to write to
     */
    public static void writeFile(String readDir, String writeDir) {
        // stores the readDir of the file passed to the method
        String copyFile = readDir;
        // new bufferedreader
        BufferedReader br = null;
        // new buffered writer
        BufferedWriter bw = null;

        // making a new file to build to the writeDirector passed readDir
        File file = new File(writeDir);

        // placeholder to store each line
        String line = "";

        // individual project ID string to store before placing in array (duplication removal)
        String individualPID = "";

        try {
            // sets the reader to read from our pathway
            br = new BufferedReader(new FileReader(copyFile));

            // creates a filewriter using our new merged.csv file, and sets the append to true
            FileWriter fw = new FileWriter(file,true);

            // sets the buffered writer equal to the fw
            bw = new BufferedWriter(fw);

            // pattern matching to pull project ID; duplication removal
            Pattern p = Pattern.compile("\",\"[0-9]+\",\"campaign\",\"");
            Matcher m = null;

            // critical code: while the file still has lines, keep going through, line by line of the file
            while ((line = br.readLine()) != null) {

                // sets the matcher equal to the line being looked at
                m = p.matcher(line);

                // finds project IDs
                while (m.find()) {

                    // gets the individual project IDs and stores as a string
                    individualPID = m.group().replace("\",\"", "").
                            replace("campaign", "");

                    // duplication removal - if the projectID is not in our LinkedList, add it, and write the line to
                    // our merge file; if the projectID has already been added, don't add to merge file
                    if (projectID.contains(individualPID) == false) {
                        // writes to the file and does a \n to ensure each one is on its own line
                        bw.write(line + "\n");
                        projectID.add(individualPID);
                    }
                }
            }
        }
        // catches error if the file does not exist
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // catches the error if the IO is incorrect
        catch (IOException e) {
            e.printStackTrace();
        }

        // final steps, try to close the writer/reader
        finally {
            // assuming the reader wasn't empty, try to close the reader
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // assuming the writer was not empty, try to close the writer
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 Test cases:

 Keyword to search for: Faraj
 1: Fund raised percent: 44.91%		Close date: 2019-03-15T23:59:59-07:00		Project ID: 2467236

 Process finished with exit code 0


 Keyword to search for: Robotics
 1: Fund raised percent: 14.00%		Close date: 2015-04-30T23:59:59-07:00		Project ID: 1171978
 2: Fund raised percent: 157.93%		Close date: 2021-05-22T23:59:59-07:00		Project ID: 2640051
 3: Fund raised percent: 0.06%		Close date: 2015-08-18T23:59:59-07:00		Project ID: 1325590
 4: Fund raised percent: 3.00%		Close date: 2016-01-11T23:59:59-08:00		Project ID: 1457231
 5: Fund raised percent: 276.64%		Close date: 2015-04-03T23:59:59-07:00		Project ID: 1069486
 6: Fund raised percent: 16.75%		Close date: 2016-03-08T23:59:59-08:00		Project ID: 1425466
 7: Fund raised percent: 13.84%		Close date: 2020-03-11T23:59:59-07:00		Project ID: 2548293
 8: Fund raised percent: 157.07%		Close date: 2019-11-30T23:59:59-08:00		Project ID: 2548847
 9: Fund raised percent: 29.45%		Close date: 2021-01-13T23:59:59-08:00		Project ID: 2642517
 10: Fund raised percent: 117.38%		Close date: 2020-10-17T23:59:59-07:00		Project ID: 2630371
 11: Fund raised percent: 57.50%		Close date: 2021-01-04T23:59:59-08:00		Project ID: 2632604
 12: Fund raised percent: 1962.43%		Close date: 2020-01-22T23:59:59-08:00		Project ID: 2575752

 Process finished with exit code 0

*/