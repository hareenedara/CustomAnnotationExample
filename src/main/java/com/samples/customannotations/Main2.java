package com.samples.customannotations;

import javax.validation.constraints.NotNull;

/**
 * Created by I681336 on 5/12/2017.
 */

public class Main2 {
    public static void main(String[] args) {
        Person person = new Person("eh", "2011-12-23");
        Main2 main = new Main2();
        main.checkPerson(null);
        System.out.println("done");

    }
    public void checkPerson(@NotNull Person person){

    }
}
