package org.example;

public class Reader extends Role{
    public Reader() {
        super("Reader");
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public boolean hasCreatePermission() {
        return false;
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
        return false;
    }
}
