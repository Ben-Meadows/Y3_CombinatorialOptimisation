package KemenyOptimiser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static final double INITIAL_TEMPERATURE = 1.0;
    public static final int TEMPERATURE_LENGTH = 10;
    public static final double COOLING_RATIO = 0.95;
    public static final int NUM_NON_IMPROVE = 8000;

    public static void main(String[] args) throws IOException {
        Path myPath = Paths.get("C:\\Ben\\University\\Year_3\\CM3109_Combinatorial_optimisation\\Coursework\\1994_Formula_One.wmg");
        // Loading the specified file into memory

        String[] fileContents;
        try {
            List<String> fileContentsList = Files.readAllLines(myPath);
            fileContents = fileContentsList.toArray(new String[fileContentsList.size()]);
        } catch (IOException e) {
            System.out.println("An error occurred loading the specified file:");
            System.out.println("\t" + args[0]);
            return;
        }
        /*String[] fileContents;
        List < String > lines = Files.readAllLines(myPath, StandardCharsets.UTF_8);
        lines.forEach(line -> System.out.println(line));
        fileContents = lines.toArray(new String[lines.size()]);*/

        // Creating initial data
        TournamentResults results = WMGParsingService.Parse(fileContents);
        Ranking initialRanking = new Ranking(results, new int[] {
                0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,35,36,37,38,39,40,41,
                42, 43, 44, 45});

        SimulatedAnnealingModel model = new SimulatedAnnealingModel();

        // Running the algorithm + timing
        Ranking ranking;
        long time = System.currentTimeMillis();
        ranking = model.runSimulatedAnnealing(initialRanking, INITIAL_TEMPERATURE, TEMPERATURE_LENGTH, COOLING_RATIO, NUM_NON_IMPROVE);
        time = System.currentTimeMillis() - time;

        // Print Output
        System.out.printf("KEMENY SCORE:  %d\n", ranking.getKemenyScore());
        System.out.printf("RUNTIME:       %dms\n", time);
        System.out.printf("UPHILL MOVES:  %d\n", model.getNumberOfUphillMoves());
        System.out.println();
        System.out.println(ranking);
    }
}