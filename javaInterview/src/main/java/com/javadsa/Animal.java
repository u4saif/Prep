package com.javadsa;

public class Animal {
    String name;

    public Animal(){
        this.name="Default Constructor";

        System.out.println(this.name);
    }

    public Animal(String name){
        this.name = name;
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        Animal am = new Animal();
        String s1 = "string1";
        String s2 = "string2";
        String s3= new String();

        for(Long i = 0L ; i< 10_000_00_0;i++){
            s3 = s1 + s2;
        }

        System.out.println(s3);
    }


}
