package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        System.out.println("A process consists of multiple threads and a thread is the smallest part of\n" +
                "the process and runs with other threads.");
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("The start method creates a new thread, then the run method runs.\n" +
                "The run method doesn't create a new thread, it just runs like it normally would.");
    }

    @Override
    public void run() {
        distinguish();
    }
}

