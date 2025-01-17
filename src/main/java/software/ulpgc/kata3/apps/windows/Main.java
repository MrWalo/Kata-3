package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.io.MockBarchartLoader;
import software.ulpgc.kata3.architecture.control.SelectStatisticCommand;
import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        MainFrame mainFrame = new MainFrame();
        MockBarchartLoader loader = new MockBarchartLoader();
        mainFrame.put("toggle", new ToggleStatisticCommand(mainFrame.getbarchartDisplay(), loader));
        mainFrame.put("select", new SelectStatisticCommand(mainFrame.getselectStatisticDialog(), loader, mainFrame.getbarchartDisplay()));
        mainFrame.getbarchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);

    }
}
