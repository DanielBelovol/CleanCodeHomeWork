package GameLogic;

import Print.PrintInfo;



public class PrintClass implements PrintInfo {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
