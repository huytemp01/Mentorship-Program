package org.example;


import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private List<Folder> folders;
    private List<File> files;

    public Folder(String item_name){
        super(item_name);
        folders = new ArrayList<>();
        files = new ArrayList<>();
    }

    @Override
    protected void removeChild(File item) {
        files.remove(item);
    }

    protected void removeChild(Folder item) {
        folders.remove(item);
    }

    public void addChild(File file) {
        files.add(file);
        file.parent = this;
    }
    public List<File> getFiles() {
        return this.files;
    }

    public List<Folder> getFolders(){return this.folders;}

    public void addChild(Folder folder) {
        folders.add(folder);

    }
}
