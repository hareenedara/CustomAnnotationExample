package com.samples.customannotations;

public class Person {
    private String name;
    @ValidEffectiveDate(format="yyyy-MM-dd", yearsbuffer=1, message="invalid date")
    private
    String effDate;

    Person(String name, String effdate){
        this.setName(name);
        this.setEffDate(effdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }
}
