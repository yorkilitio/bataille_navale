package model;
import java.util.*;
import java.io.*;
import view.*;
import game.*;
import players.*;


//class representing a boat
public class Bateau{
    private int size;
   


    public Bateau(int size){
        this.size = size;
        
    }


    public String toString(){
        return "bateau de "+ this.size + " cases";
    }

    public int returnSize(){
        return this.size;
    }
    
    
    public void addCase(int case1){
        this.size += case1;
    }




}