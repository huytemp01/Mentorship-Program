package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class FileSystemItem {
    private String item_name;
    private Long size;

    protected FileSystemItem parent;

    private List<UserRolePermission> rolePermissions;

    private User owner;

    public FileSystemItem(String item_name){
        this.item_name = item_name;
        rolePermissions = new ArrayList<>();
    }



    public static void remove(File item) {
        FileSystemItem parent = item.parent;
        if(parent instanceof Folder){
            parent = (Folder) parent;
        }
        else if(parent instanceof Drive){
            parent = (Drive) parent;
        }

        parent.removeChild(item);
    }

    public static void remove(Folder item) {
        FileSystemItem parent = item.parent;
        if(parent instanceof Folder){
            parent = (Folder) parent;
        }
        else if(parent instanceof Drive){
            parent = (Drive) parent;
        }
        parent.removeChild(item);

        item.parent= null;
    }

    public static boolean isDuplicated(File file, Drive drive) {
        return drive.getFiles().contains(file);
    }

    public static boolean isDuplicated(Folder folder, Folder parent) {
        return parent.getFolders().contains(folder);
    }

    public static boolean isDuplicated(Folder folder, Drive drive) {
        return drive.getFolders().contains(folder);
    }

    public static boolean isDuplicated(File file, Folder folder) {
        return folder.getFiles().contains(file);
    }

    protected abstract void removeChild(File item) ;
    protected abstract void removeChild(Folder item) ;

    public void addParent(Drive parent){
        this.parent = parent;

    }

    public void addParent(Folder parent){
        this.parent = parent;
    }

    public void addParent(FileSystemItem item) {
        this.parent = item;

    }

    public FileSystemItem getParent(){
        return this.parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileSystemItem that = (FileSystemItem) o;
        return Objects.equals(item_name, that.item_name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_name);
    }

    public void addOwer(User user) {
        this.owner = user;
    }

    public String getName() {
        return item_name;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setPermission(UserRolePermission permission) {
        rolePermissions.add(permission);
    }

    public void grantPermission(User user, Role role) {
        UserRolePermission permission = new UserRolePermission(user, role, this);
        this.setPermission(permission);
        user.getRolePermissions().add(permission);
    }
}

