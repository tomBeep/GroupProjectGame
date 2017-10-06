package controller.tests;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControllerTests {

    //KeyboardCommands.class Reflection Tests

    /*@Test
    public void test01_processCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IGame game = new MockGame();
        Controller controller = new Controller(game, new KeyListener(null), new MouseListener());
        Method method = Controller.class.getDeclaredMethod("processCommand", Command.class);
        method.setAccessible(true);

        assertFalse(game.isPaused());
        method.invoke(controller, Command.PAUSE);
        assertTrue(game.isPaused());
    }

    @Test
    public void test02_notifyCommands_Pressed() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        IGame game = new MockGame();
        Controller controller = new Controller(game, new KeyListener(), new MouseListener());
        Method method = Controller.class.getDeclaredMethod("notifyCommands", Command.class, boolean.class);
        method.setAccessible(true);

        Field field = Controller.class.getDeclaredField("currentCommands");
        field.setAccessible(true);
        Set<Command> commands = (Set<Command>) field.get(controller);

        method.invoke(controller, Command.PAUSE, true);
        assertTrue(commands.contains(Command.PAUSE));
    }

    @Test
    public void test03_notifyCommands_Released() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        IGame game = new MockGame();
        Controller controller = new Controller(game, new KeyListener(), new MouseListener());
        Method method = Controller.class.getDeclaredMethod("notifyCommands", Command.class, boolean.class);
        method.setAccessible(true);

        Field field = Controller.class.getDeclaredField("currentCommands");
        field.setAccessible(true);
        Set<Command> commands = (Set<Command>) field.get(controller);

        method.invoke(controller, Command.PAUSE, true);
        assertTrue(commands.contains(Command.PAUSE));
        method.invoke(controller, Command.PAUSE, false);
        assertFalse(commands.contains(Command.PAUSE));
    }

    @Test
    public void test04_update() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IGame game = new MockGame();
        Controller controller = new Controller(game, new KeyListener(), new MouseListener());
        Method method = Controller.class.getDeclaredMethod("notifyCommands", Command.class, boolean.class);
        method.setAccessible(true);
        method.invoke(controller, Command.PAUSE, true);

        assertFalse(game.isPaused());
        controller.update();
        assertTrue(game.isPaused());
    }

    @Test
    public void test05_reloadController() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        IGame game = new MockGame();
        Controller controller = new Controller(game, new KeyListener(), new MouseListener());
        Method method = Controller.class.getDeclaredMethod("notifyCommands", Command.class, boolean.class);
        method.setAccessible(true);

        Field field = Controller.class.getDeclaredField("currentCommands");
        field.setAccessible(true);
        Set<Command> commands = (Set<Command>) field.get(controller);

        method.invoke(controller, Command.PAUSE, true);
        assertTrue(commands.contains(Command.PAUSE));
        controller.reloadController();
        assertFalse(commands.contains(Command.PAUSE));
    }*/
}
