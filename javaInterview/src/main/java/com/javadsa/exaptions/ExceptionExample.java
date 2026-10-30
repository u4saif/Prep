package com.javadsa.exaptions;

public class ExceptionExample {

    public static void main(String[] args) throws Exception{
        System.out.println("----Code Started------");
        ExceptionExample ex = new ExceptionExample();
        try{
            ex.writeToFile();
        } catch (FileNotFoundException e){
            e.showException();
        }

    }

    public void writeToFile() throws Exception{
        System.out.println("Writing to file");
        throw new FileNotFoundException();
    }
}


class FileNotFoundException extends RuntimeException{

    public void showException(){
        System.out.println("File not found");
    }

}