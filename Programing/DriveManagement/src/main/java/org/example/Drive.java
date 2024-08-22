package org.example;

import java.util.ArrayList;
import java.util.List;

public class Drive extends FileSystemItem{
    private List<FileSystemItem> subItems;
    public Drive(String drive_name, ItemType itemType){
        super(drive_name,itemType);
    }

    public Drive(String drive_name){
        super(drive_name,ItemType.DRIVE);
        subItems = new ArrayList<>();
    }


    public void addChild(FileSystemItem fileSystemItem) {
        subItems.add(fileSystemItem);
    }

    public Folder getFolderByName(String folderName) {
        for(FileSystemItem item:subItems){
            if(item.getName().equals(folderName) && item instanceof Folder){
                return (Folder) item;
            }
        }
        return null;
    }

    public File getFileByName(String fileName) {
        for(FileSystemItem item:subItems){
            if(item.getName().equals(fileName) && item instanceof File){
                return (File) item;
            }
        }
        return null;
    }

    public List<FileSystemItem> getSubItems(){
        return this.subItems;

    }

    @Override
    public void addParent(Drive parent){
        super.parent = parent;
    }
}
