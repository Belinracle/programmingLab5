package WorkWithFile;

import Collection.DequeMovieCollection;
import MovieClasses.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.naming.Name;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Parser{
    BufferedReader reader;
    String path;
    String[] FILE_HEADER = {"id", "Name", "oscCoun", "CX", "CY", "MPR", "G", "ScN", "ScId", "ScW", "ScLN", "ScLX", "ScLY", "ScLZ"};
    public Parser(String path, DequeMovieCollection col) throws FileNotFoundException {
        this.path = path;
        File myFile = new File(path);
        reader = new BufferedReader(new FileReader(path));
    }

    public void parseColl(ArrayDeque<Movie> deq) {
        FileWriter fileWriter = null;
        CSVPrinter csvFilePrinter = null;
        try {
            csvFilePrinter = new CSVPrinter(new FileWriter(path), CSVFormat.DEFAULT.withRecordSeparator("\n"));
            csvFilePrinter.printRecord(FILE_HEADER);
            for (Movie movie : deq) {
                List MovieDataRecord = new ArrayList();
                MovieDataRecord.add(String.valueOf(movie.getID()));
                MovieDataRecord.add(movie.getName());
                MovieDataRecord.add(String.valueOf(movie.getOscarsCount()));
                MovieDataRecord.add(movie.getCoordinates().getX());
                MovieDataRecord.add(movie.getCoordinates().getY());
                MovieDataRecord.add(movie.getMpaaRating());
                MovieDataRecord.add(movie.getGenre());
                MovieDataRecord.add(movie.getScreenwriter().getName());
                MovieDataRecord.add(movie.getScreenwriter().getPassportID());
                MovieDataRecord.add(String.valueOf(movie.getScreenwriter().getWeight()));
                MovieDataRecord.add(movie.getScreenwriter().getLocation().getName());
                MovieDataRecord.add(movie.getScreenwriter().getLocation().getX());
                MovieDataRecord.add(movie.getScreenwriter().getLocation().getY());
                MovieDataRecord.add(movie.getScreenwriter().getLocation().getZ());
                csvFilePrinter.printRecord(MovieDataRecord);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }
    }
    public void load(ArrayDeque<Movie> deq){
            String id = "id";
            String name = "Name";
            String oscCoun = "oscCoun";
            String CX = "CX";
            String CY = "CY";
            String MPR = "MPR";
            String G= "G";
            String ScN = "ScN";
            String ScId = "ScId";
            String ScW = "ScW";
            String ScLN = "ScLN";
            String ScLX = "ScLX";
            String ScLY = "ScLY";
            String ScLZ = "ScLZ";

                FileReader fileReader = null;
                CSVParser csvFileParser = null;
                try {
                    List csvRecords = new CSVParser(new FileReader(path), CSVFormat.DEFAULT.withHeader(FILE_HEADER)).getRecords();
                    for (int i = 1; i < csvRecords.size(); i++) {
                        CSVRecord record = (CSVRecord) csvRecords.get(i);
                        Movie mov = new Movie();
                        mov.setID(Long.parseLong(record.get(id)));
                        mov.setMpaaRating(MpaaRating.valueOf(record.get(MPR)));
                        mov.setMovieGenre(MovieGenre.valueOf(record.get(G)));
                        mov.setOscarsCount(Integer.parseInt(record.get(oscCoun)));
                        mov.setName(record.get(name));
                        mov.setCoordinates(new Coordinates(Integer.parseInt(record.get(CX)),Float.parseFloat(record.get(CY))));
                        Person pers= new Person();
                        pers.setPersonName(record.get(ScN));
                        pers.setWeight(Integer.parseInt(record.get(ScW)));
                        pers.setLocation(new Location(record.get(ScLN),Long.parseLong(record.get(ScLX)),Integer.parseInt(record.get(ScLY)),Float.parseFloat(record.get(ScLZ))));
                        mov.setPerson(pers);
                        deq.add(mov);
                    }
                }
                catch (Exception e) {
                    System.out.println("Error in CsvFileReader !!!");
                    e.printStackTrace();
                } finally {
                    try {
                        fileReader.close();
                        csvFileParser.close();
                    } catch (IOException e) {
                        System.out.println("Error while closing fileReader/csvFileParser !!!");
                        e.printStackTrace();
                    }
                }

            }

        }


