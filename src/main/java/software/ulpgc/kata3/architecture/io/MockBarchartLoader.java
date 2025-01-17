package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockBarchartLoader implements BarchartLoader{

    @Override
    public Barchart load(int id) throws IOException {
        return switch (id){
            case 0  -> barchart0();
            case 1  -> barchart1();
            default -> null;
        };
    }

    private Barchart barchart0() throws IOException {
        Barchart barchart = new Barchart("Positions", "Position", "Size");
        File file = new File("E:/UNI/Tercero de Carrera/IS2/Katas/Dataset/IE1.csv");
        List<Player> players = new FilePlayerLoader(file, new CsvPlayerDeserializer()).load();
        Map<String, Integer> stats = new HashMap<>();
        for (Player player : players) {
            String position = player.getPosition();
            stats.put(position, stats.getOrDefault(position, 0)+1);
        }
        int i = 1;
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            String key = entry.getKey();
            barchart.put(key, entry.getValue());
        }
        return barchart;
    }

    private Barchart barchart1() throws IOException {
        Barchart barchart = new Barchart("Elements", "Element", "Size");
        File file = new File("E:/UNI/Tercero de Carrera/IS2/Katas/Dataset/IE1.csv");
        List<Player> players = new FilePlayerLoader(file, new CsvPlayerDeserializer()).load();
        Map<String, Integer> stats = new HashMap<>();
        for (Player player : players) {
            String element = player.getElement();
            stats.put(element, stats.getOrDefault(element, 0)+1);
        }
        int i = 1;
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            String key = entry.getKey();
            barchart.put(key, entry.getValue());
        }
        return barchart;
    }


}
