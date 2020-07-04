package regex;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex {
    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 1:");
        System.out.println("***********************************************************************************");
        // 1. What does the following pattern match? (\d){36} explain in a println() statement.

        System.out.println("The following pattern ('\\d'){36} matches : any decimal digit exactly 36 times.");





        String[] TEKmentors = {"Amir Yunas","Mark Bennet", "Rosa Garcia", "Desaree Byers", "Abram Jablonski", "Dylan Fellows", "Emilios Papas", "Jonathan Diamond"};

        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 2:");
        System.out.println("***********************************************************************************");
        // 2. Create a new array of the first names of the TEKmentors.  Use Regex to only grab the first name of every TEKmentor.  Push the values to a new array
        String[] tekMentors;
        String pattern = "[a-zA-Z]+\\s";


        Pattern p = Pattern.compile(pattern);
        Matcher m1 = p.matcher(Arrays.toString(TEKmentors));
        List<String> mentors = new ArrayList<>();
        while(m1.find()) {
                mentors.add(m1.group().trim());
        }
        System.out.println(mentors);




        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 3:");
        System.out.println("***********************************************************************************");
        // 3. Find all the occurrences of any form of 'book' in the following paragraph. use regex to match the occurrences and store the count of books in an int.
        
        int bookCount = 0;
        String bookText = "Books are the keys to knowledge.  I didn't like to read books as a child, " +
                "but in college I started enjoying learning and reading books. You can borrows books from the library, " +
                "or you can buy them from the bookstore. I'm not sure if I prefer paperback books or hardcover books.  " +
                "I'm such a nerd that I even like textbooks.  With the advent of technology, you can even buy digital books, " +
                "such as kindle-books, nook-books, or other e-books. My personal favorite book format are pdf-books, " +
                "because I don't have to carry so many books around wherever I go.  All the books are on my ipad or laptop.  " +
                "When I lived abroad, they would give books to students absolutely free.  Free books for a student of knowledge " +
                "is like a kid in a candy store.  So wipe the dust off of your books, and remember the slogan from 'reading rainbow' : " +
                "'Take a look! It's in a book! Reading Rainbow!";

        String bookPattern = "\\b(\\w*book\\w*)\\b|\\b(\\w*Book\\w*)\\b";
        Pattern b = Pattern.compile(bookPattern);
        Matcher m2 = b.matcher(bookText);
        while(m2.find()) {
            bookCount++;
        }
        System.out.println("Book count: " + bookCount);

        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 4a:");
        System.out.println("***********************************************************************************");
        // 4.a Create an array of all the words besides the word 'sleepy'.
        // Each word does not have to be a separate element, although you can split it that way if you wish.
        // We just want an array that everything that is not 'sleepy'.

        String sleepy = "I felt sleepy because I saw the others were sleepy " +
                "and because I knew I should feel sleepy, but I wasn't really sleepy.  " +
                "If you're sleepy and you know it, clap your hands.  " +
                "Keep on being sleepy until you actually become sleepy";


        List<String> notSleepyArr = new ArrayList<>();
        for(String word: sleepy.split(" ")) {
            if(!word.contains("sleepy")) {
                notSleepyArr.add(word);
            }
        }
        System.out.println(notSleepyArr);

        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 4b:");
        System.out.println("***********************************************************************************");
        // 4.b combine the array that you just created into a string
        String not_sleepy = String.join(" ", notSleepyArr); //punctuation marks will be here
        System.out.println(not_sleepy);

        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 4c:");
        System.out.println("***********************************************************************************");
        //4.c remove the punctuation marks from the notSleepy string.
        String notSleepy = not_sleepy.replaceAll("\\p{Punct}", ""); ; //no punctuation marks should be here
        System.out.println(notSleepy);

        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 4d:");
        System.out.println("***********************************************************************************");
        //4.d Now replace all the occurrences of 'sleepy' with the word 'happy'.  Call the new string happy.

        List<String> happyStr = new ArrayList<>();
        for(String word: sleepy.split(" ")) {
            if(word.contains("sleepy")) {
                String happy = sleepy.replaceAll("\\b(\\w*sleepy\\w*)\\b", "happy");
                happyStr.add(happy);
            }
        }

        String happy = String.join(" ", happyStr);
        System.out.println(happy);


        System.out.println("***********************************************************************************");
        System.out.println("PROBLEM 5- BONUS:");
        System.out.println("***********************************************************************************");
        //BONUS : 
        //5. You are looking for unicode arrow symbols in a string.  https://jrgraphix.net/r/Unicode/2190-21FF is a selection of unicode
        // arrow symbols to aid you in your search.  Match all the codes that are arrows, and then print them out to the console.
        // They should be printing out as the arrow images.

        String[] arrows = {"\u21FD", "\u26F7", "\u21FF", "\u21EF","\u21EC", "\u26F9","\u26FD","\u26D4","\u26A5","\u21FD",
                "\u2190", "\u26A1","\u21BA","\u2196","\u2603","\u21FD"};

        String arrow = Arrays.toString(arrows);
        System.out.println(arrow);

    }

}


