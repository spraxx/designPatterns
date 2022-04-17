import com.es2.singleton.End;
import com.es2.singleton.Registry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSingleton {
    @AfterAll
    public static void tearDown()
    {
        End e = new End();
    }
    @Test
    public void testSetPathRegistry()
    {
        String testPath = "Test/Path";

        Registry x = Registry.getInstance();
        x.setPath((testPath));
        assertEquals(testPath, x.getPath());
    }
    @Test
    public void testSetConnectionStringRegistry()
    {
        String testConnection = "Connection";

        Registry x = Registry.getInstance();
        x.setConnectionString(testConnection);
        assertEquals(testConnection, x.getConnectionString());
    }

    @Test
    public void testSetPathRegistryNull()
    {
        String testPath = null;

        Registry x = Registry.getInstance();
        x.setPath(testPath);
        assertEquals(testPath, x.getPath());
    }
    @Test
    public void testSetConnectionStringRegistryNull()
    {
        String testConnection = null;
        Registry x = Registry.getInstance();
        x.setConnectionString(testConnection);
        assertEquals(testConnection,x.getConnectionString());
    }
    @Test
    public void testIsConstructorPrivate() throws  NoSuchMethodException
    {
        final Constructor<?> constructor = Registry.class.getDeclaredConstructor();
        if (constructor.isAccessible() || !Modifier.isPrivate(constructor.getModifiers()))
        {
            fail("constructor is not private");
        }
    }


}
