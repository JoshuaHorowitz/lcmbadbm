package edu.touro.mco152.bm.Commands;

import java.util.List;


/**
 * The superclass of other executors for read/write benchmarks.
 * Implements @TestCommand for an execute method
 */
public class TestExecutor implements TestCommand {
    TestCommand c;


    public TestExecutor(TestCommand command) {
        this.c = command;
    }


    @Override
    public int execute() {
        return c.execute();
    }

    public void invokeAll(List<TestCommand> commandList) {
        commandList.forEach(TestCommand::execute);
    }
}
