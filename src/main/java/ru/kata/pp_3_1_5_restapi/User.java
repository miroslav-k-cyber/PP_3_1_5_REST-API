package ru.kata.pp_3_1_5_restapi;

public class User {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;
    
    public User(){
    }
    
    public User (Long id,String name,String lastName,Byte age ){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    
    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
   public String getLastName(){
        return lastName;
   }
    public Byte getAge(){
        return age;
    }
    
    public void setId(java.lang.Long id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLastname(String lastName){
        this.lastName = lastName;
    }
    public void setAge(Byte age) {
        this.age = age;
    }
    
}
