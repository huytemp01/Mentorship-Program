package org.example;

public class Contributor extends Role{
    public Contributor() {
        super("Contributor");
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public boolean hasCreatePermission() {
        return true;
    }

    @Override
    public boolean hasSharePermission(FileSystemItem item) {
        return false;
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
