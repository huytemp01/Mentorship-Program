package org.example;

import java.util.ArrayList;
import java.util.List;

public class Drive extends FileSystemItem{
//    private List<FileSystemItem> subItems;
    private List<Folder> folders;
    private List<File> files;

    public Drive(String drive_name){
        super(drive_name);
        folders = new ArrayList<>();
        files =new ArrayList<>();
    }

    public void addChild(File file) {
        files.add(file);
    }

    public void addChild(Folder folder) {
        folders.add(folder);
    }

    public Folder getFolderByName(String folderName) {
        for(Folder item:folders){
            if(item.getName().equals(folderName) ){
                return item;
            }
        }
        return null;
    }

    public File getFileByName(String fileName) {
        for(File item:files){
            if(item.getName().equals(fileName)){
                return item;
            }
        }
        return null;
    }

    public List<File> getFiles(){
        return this.files;

    }

    public List<Folder> getFolders(){
        return this.folders;

    }

    @Override
    public void addParent(Drive parent){
        super.parent = parent;
    }

    protected void removeChild(File item) {
        files.remove(item);
    }

    protected void removeChild(Folder item) {
        folders.remove(item);
    }
}
