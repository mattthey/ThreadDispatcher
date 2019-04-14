public class Main {
    public static void main(String[] args) {
        ThreadDispatcher dispatcher = ThreadDispatcher.getInstance();

        dispatcher.Add(new GUI());
        try { Thread.sleep(1000); } catch (Exception ignore) {}

        dispatcher.Add(new SleepWorker());
        try { Thread.sleep(1000); } catch (Exception ignore) {}

        dispatcher.Add(new SleepWorker());
        dispatcher.Add(new SleepWorker());
//        try { Thread.sleep(1000); } catch (Exception ignore) {}

        dispatcher.Add(new SleepWorker());
    }
}
