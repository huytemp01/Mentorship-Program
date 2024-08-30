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
        if(hasCreatePermission(parent)){
            folder.addParent(parent);
//            parent.addChild(folder);
            return true;
        }
        return false;
    }


    public boolean hasSharePermission(FileSystemItem item) {
//        if(item.hasAdminPermissionFor(this)){
//            return true;
//        }
        FileSystemItem temp = getParentHavePermission(item);
        Role role = this.getRole(item);
        if(role!=null && role.hasSharePermission()){
            return true;
        }

        if(temp instanceof Drive){
            return this.isOwner((Drive) temp);
        }

        return false;
    }


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


    public boolean share(User user, Role role, FileSystemItem item) {
        if(!this.hasSharePermission(item)){
            return false;
        }
        item.grantPermission(user, role);
        return true;
    }

    public boolean add(File file, Folder folder) {
        if(!this.hasCreatePermission(folder)){
            return false;
        }

        folder.addChild(file);
        return true;
    }

    private boolean hasCreatePermission(FileSystemItem folder) {

        FileSystemItem temp = getParentHavePermission(folder);

        Role role = this.getRole(temp);
        if(role != null){
            return role.hasCreatePermission();
        }

        if(temp instanceof Drive){
            return this.isOwner((Drive) temp);
        }

        return false;
    }

    private FileSystemItem getParentHavePermission(FileSystemItem item) {
        while(!item.equals(item.parent)){
            if(this.getRole(item) != null){
                break;
            }
            item = item.parent;
        }
        return item;
    }

    private Role getRole(FileSystemItem folder) {
        for(UserRolePermission p:rolePermissions){
            if(p.getItem().equals(folder)){
                return p.getRole();
            }
        }
        return null;
    }

    public boolean hasReadPermission(Folder folder) {
        FileSystemItem temp = getParentHavePermission(folder);

        Role role = this.getRole(temp);
        if(role != null){
            return role.hasReadPermission();
        }

        if(temp instanceof Drive){
            return this.isOwner((Drive) temp);
        }

        return false;
    }

    public boolean hasDeletePermission(FileSystemItem item){
        FileSystemItem temp = getParentHavePermission(item);

        Role role = this.getRole(temp);
        if(role != null){
            return role.hasDeletePermission();
        }

        if(temp instanceof Drive){
            return this.isOwner((Drive) temp);
        }

        return false;
    }

    public boolean hasAdminPermission(FileSystemItem item) {
        return this.hasSharePermission(item);
    }

    public  List<UserRolePermission> getRolePermissions() {
        return this.rolePermissions;
    }

    public boolean delete(FileSystemItem item) {
        if(!this.hasDeletePermission(item)){
            return false;
        }

        FileSystemItem.remove(item);
        return true;
    }
}
