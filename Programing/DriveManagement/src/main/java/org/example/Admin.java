package org.example;

public class Admin extends Role{

    public Admin() {
        super("Admin");
    }

    public String getName(){
        return super.getName();
    }

    @Override
    public boolean hasCreatePermission() {
        return true;
    }

    @Override
    public boolean hasSharePermission(FileSystemItem item) {
        return true;
    }

    @Override
    public boolean hashReadPermission() {
        return true;
    }

    @Override
    public boolean hasDeletePermission() {
        return true;
    }

}
