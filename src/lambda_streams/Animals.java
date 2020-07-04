package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition. 
        List<String> cleaned = capsFirst(animals, true);
        System.out.println(cleaned);
       
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------


        System.out.println(capsFirst(animals,true));
        System.out.println("********************************************************************************************************************");
        System.out.println(lowerFirst(animals,false));
        System.out.println("********************************************************************************************************************");
        System.out.println(sortAnimals(false));
        System.out.println("********************************************************************************************************************");
        System.out.println(flipAnimals(true));

    }

    static List<String> capsFirst(List<String> animaList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.
        // Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array
        // stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.
        // if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function,
        // WITHOUT modifying the original animals array.
        if (mutate) {
            animals = animaList.stream()
                    .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase())
                    .collect(Collectors.toList());
        } else {
            List<String> newList = animaList;
            animals = newList.stream()
                    .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase())
                    .collect(Collectors.toList());
        }
        return animals;
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        List<String> copy = new ArrayList<>(animals);
        copy.add(animal);
        animals = new ArrayList<>(copy);
        return animal;
    }


    static List<String> lowerFirst(List<String> animaList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.
        // Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or
        // perform your stream operations on a 'copy' of the animals list.
        // return the list of the function in both cases.
        if (mutate) {
            animals = animaList.stream()
                    .map(i -> i.substring(0, 1).toLowerCase() + i.substring(1).toUpperCase())
                    .collect(Collectors.toList());
        } else {
            List<String> copy = new ArrayList<>(animals);
            animals = copy.stream()
                    .map(i -> i.substring(0, 1).toLowerCase() + i.substring(1).toUpperCase())
                    .collect(Collectors.toList());
        }
        return animals;
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the boolean parameter is true,
        // reverse the static animals array list by mutating the array.  if the mutate boolean is false,
        // flip a 'copy' of the animals list, then return that list of flipped animals,
        // WITHOUT mutating the static animals array. return the flipped list in both cases.
        ArrayList<String> animalList = new ArrayList<>();
        List<String> instructions = Arrays.asList("Flip","the","animals","list","."," ","Mutate","the","animals","only","if","flag","true");

        if(mutate) {
            for(int i=animals.size()-1; i>= 0; i--) {
                animalList.add(animals.get(i));
            }
        } else {
            List<String> copy = new ArrayList<>(animals);
            for(int i=copy.size()-1; i>=0; i--) {
                animalList.add(animals.get(i));
            }
        }
        return animalList;
    }

    static List<String> sortAnimals(boolean mutate) {
        //sort the animals in alphabetical order.  If the boolean parameter is true,
        // mutating the animals list.  if the mutate boolean is false, sort a 'copy' of the animals list,
        // then return that list of sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.
        if(mutate) {
            animals.sort(Comparator.naturalOrder());
            return animals;
        } else {
            List<String> copy = new ArrayList<>(animals);
            copy.sort(Comparator.naturalOrder());
            return copy;
        }
    }


}
