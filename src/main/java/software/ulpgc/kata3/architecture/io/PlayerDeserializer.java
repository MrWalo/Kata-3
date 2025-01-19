package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Player;

public interface PlayerDeserializer {
    Player deserialize(String line);
}
