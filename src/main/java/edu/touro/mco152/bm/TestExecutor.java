package edu.touro.mco152.bm;

import java.io.IOException;

public class TestExecutor implements TestCommand {
    TestCommand c;

    public TestExecutor(TestCommand command) {
        this.c = command;
    }

    @Override
    public void execute() throws IOException {
        c.execute();
    }
}
