package edu.touro.mco152.bm;

import edu.touro.mco152.bm.persist.DiskRun;
import edu.touro.mco152.bm.persist.EM;
import edu.touro.mco152.bm.ui.Gui;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static edu.touro.mco152.bm.App.*;
import static edu.touro.mco152.bm.App.msg;
import static edu.touro.mco152.bm.DiskMark.MarkType.READ;
import static edu.touro.mco152.bm.DiskMark.MarkType.WRITE;

/**
 * SwingGUI class that enables a benchmark to be ran on a swing-based GUI and implements a GUI interface
 */
public class SwingGUI extends SwingWorker<Boolean, DiskMark> implements GUI {
    DiskWorker worker;

    public SwingGUI() {
        worker = new DiskWorker();
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        return worker.doBenchmark();
    }

    @Override
    public Boolean cancelled() {
        return isCancelled();
    }

    @Override
    public void setTheProgress(int i) {
        setProgress(i);
    }

    @Override
    public void doPublish(DiskMark dm) {
        publish(dm);
    }

    @Override
    public void doProcess(List<DiskMark> markList) {
        process(markList);
    }

    @Override
    public void finish() {
        done();
    }

    @Override
    public void queueExecute() {
        execute();
    }

    @Override
    public void addPropertyListener(PropertyChangeListener propertyChangeListener) {
        addPropertyChangeListener(propertyChangeListener);
    }

    @Override
    public void doCancel(boolean b) {
        cancel(b);
    }
}
