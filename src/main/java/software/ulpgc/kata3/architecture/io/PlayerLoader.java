package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Player;

import java.io.IOException;
import java.util.List;

public interface PlayerLoader {
    List<Player> load() throws IOException;
}
