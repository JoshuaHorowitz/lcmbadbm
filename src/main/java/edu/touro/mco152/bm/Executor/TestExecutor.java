package edu.touro.mco152.bm.Executor;

import java.io.IOException;
import java.util.List;

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
