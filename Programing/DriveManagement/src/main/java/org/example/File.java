package org.example;

public class File extends FileSystemItem{

    public File(String file_name){
        super(file_name);
    }

    @Override
    protected void removeChild(File item) {
        throw new RuntimeException("This function don't work on File");
    }

    @Override
    protected void removeChild(Folder item) {
        throw new RuntimeException("This function don't work on File");
    }

}
