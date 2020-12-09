package edu.touro.mco152.bm;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskMarkTest {
    DiskMark dm = new DiskMark(DiskMark.MarkType.WRITE);
    @Test
    void getBwMbSecAsString() {
        String secAsString = dm.getBwMbSecAsString();
        Assert.assertEquals("0", secAsString);
    }

    @Test
    void getMarkNum() {
        System.out.println(dm.getMarkNum());
    }

    @Test
    void getCumAvg() {
        System.out.println(dm.getCumAvg());
    }
}