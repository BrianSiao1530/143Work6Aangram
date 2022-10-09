//recursion training
//homework 6
//you probably need to see LetterInventory project, so you can understand some of them

import java.util.*;
public class AnagramSolver {
    private List<String> dictionary;
    //store the input(dictionary), compare to our word
    private List<String> output = new ArrayList<>();
    //store what we are going to print
    public AnagramSolver(List<String> list/*as a dictionary*/){
        this.dictionary = list;
    }
    public void print(String s, int max) {
        if(max <= 0) {
            throw new IllegalArgumentException(); // set a pre condition
        }else {
            LetterInventory texted = new LetterInventory(s);// we need to use s to create a  letterinventory object so
                                                            //we can use the function in letterinventory to compare
            Iterator itrByDic = dictionary.iterator();
            while (itrByDic.hasNext() && !s.isEmpty()) {
                String tested = itrByDic.next() + "";
                LetterInventory dictionary1 = new LetterInventory(tested);
                if (texted.subtract(dictionary1) != null) {
                    LetterInventory remain = texted.subtract(dictionary1);
                        if (remain.isEmpty()) {
                            String output = this.output.toString();
                            System.out.println(output.substring(0, output.length() - 1) +
                                                ", " + tested + "]"); // the reason of using this is that by the backtracking
                                                                      // we can't subtract the last word
                        } else if (!remain.isEmpty() && max - 1 > 0) {
                            this.output.add(tested);
                            print(remain + "", max - 1);
                        }
                }
            }
            if (output.size() > 0) {
                this.output.remove(output.size() - 1);
            //backtracking
            }
        }
    }
}
