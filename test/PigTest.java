import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;
import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * import java.io.ByteArrayOutputStream; import java.io.PrintStream; import
 * java.lang.reflect.Method; import java.lang.reflect.Modifier; import
 * org.junit.Before;
 */

public class PigTest {
    private class MethodInfo {
        private String methodName;
        private Class[] parameters;
        private Class returnType;

        public MethodInfo(String name, Class[] params, Class returnType) {
            methodName = name;
            parameters = params;
            this.returnType = returnType;
        }

        public String getName() {
            return methodName;
        }

        public Class[] getParams() {
            return parameters;
        }

        public Class getReturn() {
            return returnType;
        }
    }

    private static PrintStream console;
    private static ByteArrayOutputStream out;
    private Class<?> className;
    private Method aMethod;
    private String classStringName = "Pig";
    private MethodInfo[] methods = {
            new MethodInfo("getRandom", new Class[] { int.class, int.class },
                    int.class),
            new MethodInfo("roll", new Class[] {}, int.class),
            new MethodInfo("getYNAnswer",
                    new Class[] { Scanner.class, String.class }, String.class),
            new MethodInfo("takeTurn", new Class[] { Scanner.class },
                    int.class),
            new MethodInfo("takeComputerTurn", new Class[] { int.class },
                    int.class),
            new MethodInfo("playGame", new Class[] { Scanner.class },
                    void.class),
            new MethodInfo("main", new Class[] { String[].class },
                    void.class) };

    @BeforeClass
    public static void beforeTestsBegin() {
        console = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

    }

    @AfterClass
    public static void afterTestsEnd() {
        System.setOut(console);
    }

    @Before
    public void beforeEachTest() {
        className = null;
        aMethod = null;
    }

    @Test
    public void testClassHasMethods() {
        // class exists
        try {
            Package pkg = getClass().getPackage();
            // declare name and path as Strings. Remove earlier declaration
            String name = pkg == null ? "" : pkg.getName();
            String path = name.equals("") ? "" : (name + ".");
            // System.out.println("In try, name is " + name + "; path is " +
            // path );
            className = Class.forName(path + classStringName);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
            fail(classStringName + ".class does not have a " + classStringName
                    + " class (is the class name spelled correctly?");
        }
        for (MethodInfo m : methods) {
            String name = m.getName();
            Class[] params = m.getParams();
            Class expectedReturnType = m.getReturn();
            try {
                aMethod = className.getMethod(name, params);
                Class actualReturnType = aMethod.getReturnType();
                int mods = aMethod.getModifiers();
                assertEquals(
                        name + "should have a return type of"
                                + expectedReturnType.toString(),
                        expectedReturnType, actualReturnType);
                assertTrue(name + " should be 'public'",
                        Modifier.isPublic(mods));
                assertTrue("Method \"sumWithWhileLoop\" should be 'static'",
                        Modifier.isStatic(mods));
            }
            catch (NoSuchMethodException | SecurityException e) {
                fail(classStringName + ".class does not have a  " + name
                        + "  method. ");
            }
        }
    }

    @Test
    public void testgetYNwithY() {
        testClassHasMethods();
        String[] array = { "Yes", "yes", "Y", "YYYY", "y", "yasdfjkl" };
        String prompt = "k";
        Scanner in;
        for (String s : array) {
            in = new Scanner(s);
            String expected = Pig.YES;
            String actual = Pig.getYNAnswer(in, prompt);
            assertTrue(Pig.YES + " should be returned.",
                    actual.contentEquals(expected));
        }
    }

    @Test
    public void testgetYNwithN() {
        testClassHasMethods();
        String[] array = { "No", "no", "N", "NNN", "n", "nasdfjkl;" };
        String prompt = "k";
        Scanner in;
        for (String s : array) {
            in = new Scanner(s);
            String expected = Pig.NO;
            String actual = Pig.getYNAnswer(in, prompt);
            assertTrue(Pig.NO + " should be returned.",
                    actual.contentEquals(expected));
        }
    }

    @Test
    public void testgetYNwithOther() {
        testClassHasMethods();
        String[] array = { "SOS", "hello", "goon", "Java" };
        String prompt = "k";
        Scanner in;
        for (String s : array) {
            in = new Scanner(s);
            String expected = Pig.NO;
            String actual = Pig.getYNAnswer(in, prompt);
            assertTrue(Pig.NO + " should be returned.",
                    actual.contentEquals(expected));
        }
    }

    @Test
    public void testGetRandomInOrder() {
        testClassHasMethods();
        // By defining the "seed" we get deterministic values to test
        Pig.randGen = new Random(434);

        assertEquals("getRandom return value is incorrect", 1,
                Pig.getRandom(1, 6));
        assertEquals("getRandom return value is incorrect", 6,
                Pig.getRandom(3, 8));
        assertEquals("getRandom return value is incorrect", 3131,
                Pig.getRandom(40, 9237));
        assertEquals("getRandom return value is incorrect", 86,
                Pig.getRandom(86, 86));

    }

    @Test
    public void testGetRandomInWrongOrder() {
        testClassHasMethods();
        // By defining the "seed" we get deterministic values to test
        Pig.randGen = new Random(434);
        assertEquals("getRandom return value is incorrect", 8,
                Pig.getRandom(8, 5));
        assertEquals("getRandom return value is incorrect", 76,
                Pig.getRandom(90, 18));
        assertEquals("getRandom return value is incorrect", 5189,
                Pig.getRandom(5423, 5000));
        assertEquals("getRandom return value is incorrect", 14,
                Pig.getRandom(14, 14));

    }

    @Test
    public void testRoll() {
        // public static int roll()
        // 6 2 6 5 2
        // By defining the "seed" we get deterministic values to test
        Pig.randGen = new Random(996);
        // int[] expected = { 6, 2, 6, 5, 2 };
        int expected = 6;
        int actual = Pig.roll();
        assertEquals("roll return value is incorrect", expected, actual);
        expected = 2;
        actual = Pig.roll();
        assertEquals("roll return value is incorrect", expected, actual);
        expected = 6;
        actual = Pig.roll();
        assertEquals("roll return value is incorrect", expected, actual);
        expected = 5;
        actual = Pig.roll();
        assertEquals("roll return value is incorrect", expected, actual);
        expected = 2;
        actual = Pig.roll();
        assertEquals("roll return value is incorrect", expected, actual);
    }

}
