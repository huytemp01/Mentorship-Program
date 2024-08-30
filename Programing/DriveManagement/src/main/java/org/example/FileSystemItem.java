package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class FileSystemItem {
    private String item_name;
    private Long size;
    private ItemType itemType;

    protected FileSystemItem parent;

    private List<UserRolePermission> rolePermissions;

    private User owner;

    public FileSystemItem(String item_name, ItemType itemType){
        this.item_name = item_name;
        this.itemType = itemType;
        rolePermissions = new ArrayList<>();
    }

//    public static void remove(File item) {
//        FileSystemItem parent = item.parent;
//        if(parent instanceof Folder){
//            parent = (Folder) parent;
//        }
//        else if(parent instanceof Drive){
//            parent = (Drive) parent;
//        }
//    }

    public void addParent(Drive parent){
        this.parent = parent;
        parent.addChild(this);
    }

    public void addParent(Folder parent){
        this.parent = parent;
        parent.addChild(this);
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
        return Objects.equals(item_name, that.item_name) && itemType == that.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_name, itemType);
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

