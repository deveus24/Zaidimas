package player;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainMenuTest {
    public static void main(String[] args) throws IOException
    {
        String simulatedInput = "2\n0\n";
        InputStream originalIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
            MainMenu.main(new String[]{});

        } finally {
            System.setIn(originalIn);
        }
    }
}
