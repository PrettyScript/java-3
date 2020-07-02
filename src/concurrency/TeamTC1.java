package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TeamTC1 implements Runnable {

    List<String> team = new ArrayList<>();
    List<String> color = new ArrayList<>();

    //This thread should be created by implementing the Runnable interface,
    // NOT by extending the Thread class.  In the run method of this thread,
    // print out the name of each student in your TA group, (starting with your TA).
    // There should be a pause of 1 second before each name is printed to the console.
    // The name should then be pushed to the team List  After all the names have been pushed to this List,
    // print out the entire list of all the students in your TA group. Don't forget your TA as well!
    // All of these steps should be done whenever the thread is started.  (i.e. it can be done directly
    // in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package.

    private void students() {

    }

    @Override
    public void run() {
        team.add("Dylan");
        team.add("George");
        team.add("Jeramie");
        team.add("Jessica");
        team.add("John");
        team.add("Katherine");
        team.add("Kevin");
        team.add("Matthew");
        team.add("Nancy");
        team.add("Norita");
        team.add("Sabitha");
        team.add("Vani");
        team.add("Victor");
        team.add("Vimala");

        color.add("Yellow");
        color.add("Carol");
        color.add("Pink");
        color.add("Lavendar");
        color.add("Blue");
        color.add("Teal");
        color.add("Grey");
        color.add("Green");
        color.add("Peach");
        color.add("Lilac");
        color.add("Turquoise");
        color.add("Midnight Blue");
        color.add("Emerald");
        color.add("Gold");
        color.add("Silver");
        color.add("Beige");


        for(int i=0; i<team.size(); i++) {
            int rnd = new Random().nextInt(color.size());
            String randomColor = color.get(rnd);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((1 + i) + ". " + team.get(i) + " " + randomColor);
        }

    }
}