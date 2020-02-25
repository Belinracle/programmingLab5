package Parsers;

import Collection.CollectionShellInterface;
import MovieClasses.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


    public class ParserCSV implements Parser {
        BufferedReader reader;
        String[] FILE_HEADER = {"id", "Name", "oscCoun", "CX", "CY", "MPR", "G", "ScN", "ScId", "ScW", "ScLN", "ScLX", "ScLY", "ScLZ"};
        CollectionShellInterface deq;
        public ParserCSV(CollectionShellInterface deq) throws FileNotFoundException {
            this.deq=deq;
        }

        public String ser () {
            CSVPrinter csvFilePrinter = null;
            try {
                StringBuilder sb= new StringBuilder();
                csvFilePrinter = new CSVPrinter(sb, CSVFormat.DEFAULT.withRecordSeparator("\n"));
                csvFilePrinter.printRecord(FILE_HEADER);
                List<Movie> buffList = new ArrayList<>();
                buffList.addAll(deq.getCol());
                for(int i = 0; i<deq.getCol().size(); i++ ){
                    Movie movie = buffList.get(i);
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
                return sb.toString();
            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            }
            return null;
        }
        public void deSer (String path){
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
            }

        }

    }