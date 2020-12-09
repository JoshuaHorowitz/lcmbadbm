import edu.touro.mco152.bm.App;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    void getVersion() {
        String version = App.getVersion();
        Assert.assertEquals("0.4", version);
    }

    
}