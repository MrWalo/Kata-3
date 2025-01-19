package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.model.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockBarchartLoader implements BarchartLoader {

    private static final String CSV_PATH = new File("").getAbsolutePath() + "\\IE1.csv";

    @Override
    public Barchart load(int id) throws IOException {
        return switch (id) {
            case 0 -> barchart0();
            case 1 -> barchart1();
            default -> null;
        };
    }

    private Barchart barchart0() throws IOException {
        Barchart barchart = new Barchart("Positions", "Position", "Size");
        downloadCsvIfNeeded();
        File file = new File(CSV_PATH);
        List<Player> players = new FilePlayerLoader(file, new CsvPlayerDeserializer()).load();
        Map<String, Integer> stats = new HashMap<>();
        for (Player player : players) {
            String position = player.getPosition();
            stats.put(position, stats.getOrDefault(position, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            barchart.put(entry.getKey(), entry.getValue());
        }
        return barchart;
    }

    private Barchart barchart1() throws IOException {
        Barchart barchart = new Barchart("Elements", "Element", "Size");
        downloadCsvIfNeeded();
        File file = new File(CSV_PATH);
        List<Player> players = new FilePlayerLoader(file, new CsvPlayerDeserializer()).load();
        Map<String, Integer> stats = new HashMap<>();
        for (Player player : players) {
            String element = player.getElement();
            stats.put(element, stats.getOrDefault(element, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            barchart.put(entry.getKey(), entry.getValue());
        }
        return barchart;
    }

    private void downloadCsvIfNeeded() throws IOException {
        File csvFile = new File(CSV_PATH);
        if (!csvFile.exists()) {
            String url = "https://github.com/MrWalo/Resources/raw/main/IE1.csv";
            CsvDownloader.downloadCsv(url, CSV_PATH);
        }
    }
}
