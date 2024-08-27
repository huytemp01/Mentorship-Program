package org.example;

public abstract class Role {
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public  String getName(){
        return roleName;
    }

    public abstract boolean hasCreatePermission();

    public abstract boolean hasSharePermission(FileSystemItem item) ;

    public abstract boolean hashReadPermission();

    public abstract boolean hasDeletePermission();
}
