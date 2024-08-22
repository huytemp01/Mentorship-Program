package org.example;

import java.util.ArrayList;
import java.util.List;
public class User {
    private String name;

    private List<Drive> items;

    private List<UserRolePermission> rolePermissions;

    public User(String name) {
        this.name = name;
        items = new ArrayList<>();
        rolePermissions = new ArrayList<>();
    }

    public void add(Drive item){
        item.addParent(item);
        items.add(item);
        item.addOwer(this);
    }

    public void add(FileSystemItem folder, Drive drive){
        if(this.isOwner(drive)){
            folder.addParent(drive);
        }
    }

    public void add(File file, Drive drive){
        if(this.isOwner(drive)){
            file.addParent(drive);
        }
    }

    public boolean add(Folder folder, Folder parent) {
        if(this.hasAdminPermission(parent)){
            folder.addParent(parent);
            parent.addChild(folder);
            return true;
        }
        return false;
    }

    public boolean hasAdminPermission(FileSystemItem item) {
        if(item.hasAdminPermissionFor(this)){
            return true;
        }
        FileSystemItem closestPermissionItem = item.getParent();
        while(!closestPermissionItem.equals(item)){
            {
                item = closestPermissionItem;
                closestPermissionItem = item.getParent();
            }
        }
        if(closestPermissionItem.hasAdminPermissionFor(this)){
            return true;
        }
        if(!closestPermissionItem.getOwner().equals(this)){
            return false;
        }

        return true;

    }

//    private boolean isOwner(FileSystemItem item) {
//        FileSystemItem closestPermissionItem = item.getParent();
//        while(!closestPermissionItem.equals(item)){
//            {
//                item = closestPermissionItem;
//                closestPermissionItem = item.getParent();
//            }
//        }
//        if(!closestPermissionItem.getOwner().equals(this)){
//            return false;
//        }
//
//        return true;
//    }

    private boolean isOwner(Drive drive) {
        return drive.getOwner().equals(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Drive> getAllDrives() {
        return items;
    }


    public boolean grantPermission(User user, Role role, FileSystemItem item) {
        if(!this.hasAdminPermission(item)){
            return false;
        }

        UserRolePermission permission = new UserRolePermission(user, role, item);
//        rolePermissions.add(permission);

        item.setPermission(permission);

        return true;
    }

    public boolean add(File file, Folder cardGame) {
        if(!this.hasAdminPermission(cardGame)){
            return false;
        }

        cardGame.addChild(file);
        return true;
    }
}
