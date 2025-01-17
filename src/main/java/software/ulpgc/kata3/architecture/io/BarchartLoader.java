package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;

import java.io.IOException;

public interface BarchartLoader {
    Barchart load(int id) throws IOException;
}
