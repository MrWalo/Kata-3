package software.ulpgc.kata3.architecture.io;

public class CsvPlayerDeserializer implements PlayerDeserializer {

    @Override
    public Player deserialize(String line) {return deserialize(line.split(","));}

    private Player deserialize(String[] fields) {
        return new Player(fields[0], fields[1], fields[2], fields[3]);
    }
}

