package edu.touro.mco152.bm.Executor;

import edu.touro.mco152.bm.App;
import edu.touro.mco152.bm.Commands.DoReadTest;
import edu.touro.mco152.bm.Commands.TestExecutor;
import edu.touro.mco152.bm.SwingGUI;
import edu.touro.mco152.bm.persist.DiskRun;
import edu.touro.mco152.bm.ui.Gui;
import edu.touro.mco152.bm.ui.MainFrame;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Properties;

class ExecutorTests {

    @BeforeEach
    void setUp() {
        setupDefaultAsPerProperties();
    }

    private static void setupDefaultAsPerProperties() {
        /// Do the minimum of what  App.init() would do to allow to run.
        Gui.mainFrame = new MainFrame();
        App.p = new Properties();
        App.loadConfig();
        System.out.println(App.getConfigString());
        Gui.progressBar = Gui.mainFrame.getProgressBar(); //must be set or get Nullptr

        // configure the embedded DB in .jDiskMark
        System.setProperty("derby.system.home", App.APP_CACHE_DIR);

        // code from startBenchmark
        //4. create data dir reference
        App.dataDir = new File(App.locationDir.getAbsolutePath() + File.separator + App.DATADIRNAME);

        //5. remove existing test data if exist
        if (App.dataDir.exists()) {
            if (App.dataDir.delete()) {
                App.msg("removed existing data dir");
            } else {
                App.msg("unable to remove existing data dir");
            }
        } else {
            App.dataDir.mkdirs(); // create data dir if not already present
        }
    }

    @Test
    void executeWrite() {
        SwingGUI swingGUI = new SwingGUI();

        DoReadTest dwt = new DoReadTest(swingGUI, DiskRun.BlockSequence.SEQUENTIAL,25, 128, 2048);

        TestExecutor testExecutor = new TestExecutor(dwt);

        int result = testExecutor.execute();

        Assert.assertEquals(3200, result);
    }

    @Test
    void executeRead() {
        SwingGUI swingGUI = new SwingGUI();

        DoReadTest drt = new DoReadTest(swingGUI, DiskRun.BlockSequence.SEQUENTIAL,25, 128, 2048);

        TestExecutor testExecutor = new TestExecutor(drt);

        int result = testExecutor.execute();

        Assert.assertEquals(3200, result);
    }
}