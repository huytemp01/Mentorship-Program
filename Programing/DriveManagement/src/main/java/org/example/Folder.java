package org.example;


import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private List<FileSystemItem> subItems;
    public Folder(String item_name, ItemType itemType) {
        super(item_name, itemType);

    }

    public Folder(String item_name){
        super(item_name,ItemType.FOLDER);
        subItems = new ArrayList<>();
    }


    public void addChild(FileSystemItem fileSystemItem) {
        subItems.add(fileSystemItem);
        fileSystemItem.parent = this;
    }

    public List<FileSystemItem> getSubItems() {
        return subItems;
    }
}
