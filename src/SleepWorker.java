public class SleepWorker extends Threaded {

    @Override
    public void doRun() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Error in ThreadSleep");
        }
    }
}
