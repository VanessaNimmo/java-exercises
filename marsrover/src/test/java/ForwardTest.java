import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void canMakeACommand() {
        Command command = new Forward();

        assertNotNull(command);
    }


}