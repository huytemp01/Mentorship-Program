package org.example;

public abstract class Role {
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public  String getName(){
        return roleName;
    }
}
