package software.ulpgc.kata3.architecture.control;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
