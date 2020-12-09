package edu.touro.mco152.bm;

import java.beans.PropertyChangeListener;
import java.util.List;
/**
Generic GUI interface that all future GUIs can implement in order to extend the abilities of the benchmarking process
 */
public interface GUI {

    Boolean cancelled();

    void setTheProgress(int i);

    void doPublish(DiskMark dm);

    void doProcess(List<DiskMark> markList);

    void finish();

    void queueExecute();

    void addPropertyListener(PropertyChangeListener propertyChangeListener);

    void doCancel(boolean b);

}
