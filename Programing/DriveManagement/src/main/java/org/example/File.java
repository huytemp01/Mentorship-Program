package org.example;

public class File extends FileSystemItem{

    public File(String item_name, ItemType itemType) {
        super(item_name, itemType);
    }

    public File(String file_name){
        super(file_name,ItemType.FILE);
    }
}
