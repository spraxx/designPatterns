import com.es2.decorator.*;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class TestDecorator {
    //private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpBeforeAllTests() {
    }

    @BeforeEach
    public void setUp(){}


    @BeforeAll
    public static void setUpStreams() throws FileNotFoundException {
        String outContent = null;
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.setOut(System.out);
        End e = new End();
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(standardOut);
    }


    @Test
    public void testRightAuthWithoutDecorators() throws AuthException, IOException {
        AuthInterface auth = (AuthInterface) new Auth();
        auth.auth("admin", "admin");
    }

    // Password errada
    @Test(expected = AuthException.class)
    public void testWrongAuthWithoutDecorators() throws AuthException, IOException {
        AuthInterface auth = (AuthInterface) new Auth();
        auth.auth("admin", "notadmin");
    }

    // Auth Correta, mas admin é uma palavra comum
    @Test(expected = AuthException.class)
    public void testRightAuthWithCommonWordsDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator((AuthInterface) new Auth());
        auth.auth("admin", "adminnn");
    }

    // Auth incorreta, mas palavra não é comum
    @Test(expected = AuthException.class)
    public void testWrongAuthWithCommonWordsDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator((AuthInterface) new Auth());
        auth.auth("admin", "ola");
    }

    // Auth correta com logging decorator
    @Test
    public void testRightAuthWithLoggingDecorator() throws AuthException, IOException {
        AuthInterface auth = new Logging((AuthInterface) new Auth());
        auth.auth("admin", "admin");
    }

    // Auth incorreta com logging decorator
    @Test(expected = AuthException.class)
    public void testWrongAuthWithLoggingDecorator() throws AuthException, IOException {
        AuthInterface auth = new Logging((AuthInterface) new Auth());
        auth.auth("admin", "notadmin");
    }

    // Auth correta, com todos decorators. Dá error porque admin é uma palavra comum
    @Test(expected = AuthException.class)
    public void testRightAuthWithAllDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Logging((AuthInterface) new Auth()));
        auth.auth("admin", "adminnn");
    }

    // Auth incorreta, mas com palavra não comum
    @Test(expected = AuthException.class)
    public void testWrongAuthWithAllDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Logging((AuthInterface) new Auth()));
        auth.auth("admin", "ola");
    }

    //Testar todas as decoraçoes
    @Test
    public void testAllDecorations() throws AuthException, IOException
    {
        AuthInterface a = new Logging(new CommonWordsValidator((AuthInterface) new Auth()));
        a.auth("admin","admin");
        Assertions.assertTrue(outputStreamCaptor.toString().contains(",auth()"));

        Assertions.assertThrows(AuthException.class,()->{a.auth("auth","admin");});
        Assertions.assertThrows(AuthException.class,()->{a.auth("admin","auth");});

    }

    //Testar Logging
    @Test
    public void testLogging() throws AuthException, IOException
    {
        AuthInterface a = new Logging((AuthInterface) new Auth());
        a.auth("admin","admin");
        Assertions.assertTrue(outputStreamCaptor.toString().contains(",auth()"));
    }
}