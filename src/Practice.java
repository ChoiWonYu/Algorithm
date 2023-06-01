import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

enum Fruit{
    APPLE("red"),BANANA("yellow"),PEACH("pink");
    private String color;
    Fruit(String color){
        this.color=color;
    }

    String getColor(){
        return this.color;
    }
};

public class Practice {
    public static void main(String[] args){
        char c='c';
      System.out.println(c=='c');
    }
}