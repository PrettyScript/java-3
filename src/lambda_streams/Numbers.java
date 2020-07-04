package lambda_streams;

import java.util.*;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.
        // Use streams to compute the results wherever possible.
        System.out.println(nums);


        //Part II - refactor all of the class methods to accept lambda expressions.
        // You can put the lambda functions directly inside the method calls, or defined them first,
        // then pass them into the methods. give them the same names as the static methods,
        // but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */


        // Part I
//        isEven(2);
//        isPrime(131);
//        added(nums);
//        subtracted();
//        multipled();
//        divided();
//        findMax();
//        findMin();
//        compare(5, 3);
//        System.out.println(append(5));
//        System.out.println(nums);


        // Part II
        Calculate lambdaIsOdd = (i) -> i;
        isOdd(lambdaIsOdd.compute(43));

        System.out.println("********************************************************************************");

        Calculate lambdaIsEven = i -> i;
        isEven(lambdaIsEven.compute(56));

        System.out.println("********************************************************************************");

        Calculate lambdaIsPrime = i -> i;
        isPrime(lambdaIsPrime.compute(131));

        System.out.println("********************************************************************************");

        Nums lambdaAdded = list -> list;
        added(lambdaAdded.numsList(nums));

        System.out.println("********************************************************************************");

        Nums lambdaSubtracted = list -> list;
        subtracted(lambdaSubtracted.numsList(nums));

        System.out.println("********************************************************************************");

        Nums lambdaMultipled = list -> list;
        multipled(lambdaMultipled.numsList(nums));

        System.out.println("********************************************************************************");

        Nums lambdaDivided = list -> list;
        divided(lambdaDivided.numsList(nums));

        System.out.println("********************************************************************************");

        Nums lambdaFindMax = list -> list;
        findMax(lambdaFindMax.numsList(nums));

        System.out.println("********************************************************************************");

        Nums lambdaFindMin = list -> list;
        findMin(lambdaFindMin.numsList(nums));

        System.out.println("********************************************************************************");

        Calculate lambdaCompare = i -> i;
        Calculate lambdaCompare2 = j -> j;
        compare(lambdaCompare.compute(10), lambdaCompare2.compute(5));

        System.out.println("********************************************************************************");

        Calculate lambdaAppend = num -> num;
        append(lambdaAppend.compute(25));




    }


    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        if(i % 2 != 0) {
            System.out.println(i + " is an odd number");
            return true;
        }
        System.out.println(i + " is not an odd number");
        return false;
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        if(i % 2 == 0) {
            System.out.println(i + " is an even number");
            return true;
        }
        System.out.println(i + " is not an even number");
        return false;
    }

    static boolean isPrime(int i) {
         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        for (int j = 2; j <= i/2; j++) {
            if (i % j != 0) {
                System.out.println(i + " is a prime number");
                return true;
            }
        }
        System.out.println(i + " is not a prime number");
        return false;
    }

    static int added(List<Integer> nums) {
        //add all the elements in the list.  return the sum.
        nums.stream()
                .reduce((a,b) -> a+b)
                .ifPresent(n -> System.out.println("Sum: " + n));
        return 0;
    }

    static int subtracted(List<Integer> nums) {
        //subtract all the elements in the list. return the remainder.
        nums.stream()
                .reduce((a,b) -> a-b)
                .ifPresent(n -> System.out.println("Difference: " + n));
        return 0;
    }

    static int multipled(List<Integer> nums) {
        //multiply all the elements in the list. and return the product.
        nums.stream()
                .reduce((a,b) -> a*b)
                .ifPresent(n -> System.out.println("Product: " + n));
        return 0;
    }

    static int divided(List<Integer> nums) {
        //multiply all the elements in the list. and return the product.
        nums.stream()
                .reduce((a,b) -> a/b)
                .ifPresent(n -> System.out.println("Quotient: " + n));
        return 0;
    }

    static int findMax(List<Integer> nums) {
         //return the maximum value in the list.
        nums.stream().max(Comparator.naturalOrder())
                .ifPresent((x) -> System.out.println("Max value: " + x));
        return 0;
    }

    static int findMin(List<Integer> nums) {
        //return the minimum value in the list.
        nums.stream()
                .sorted()
                .findFirst()
                .ifPresent(x -> System.out.println("Min value: " + x) );
        return 0;
    }

    static int compare(int i, int j) {
        //compare the values stored in the array at index position i and j.
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.
        // if the two values are equal, return 0.
        if(i > j) {
            System.out.println(i + " is greater than " + j);
            return 1;
        } else if(j > i) {
            System.out.println(j + " is greater than " + i);
        } else if(i == j) {
            System.out.println(i + " equals " + j);
            return 0;
        }
        return 0;

    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        List<Integer> copy = new ArrayList<>(nums);
        copy.add(n);
        nums = new ArrayList<>(copy);
        System.out.println(n + " was added to the nums array");
        return n;
    }

}

@FunctionalInterface
interface Calculate {
    public int compute(int num);
}


@FunctionalInterface
interface Nums {
    public List numsList(List<Integer> numbers);
}


