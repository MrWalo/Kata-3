package software.ulpgc.kata3.architecture.io;

import java.io.IOException;
import java.util.List;

public interface PlayerLoader {
    List<Player> load() throws IOException;
}
