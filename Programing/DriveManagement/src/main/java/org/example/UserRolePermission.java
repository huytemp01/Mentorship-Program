package org.example;

public class UserRolePermission {
    private User user;
    private Role role;
    private FileSystemItem item;

    public UserRolePermission(User user, Role role, FileSystemItem item) {
        this.user = user;
        this.role = role;
        this.item = item;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public FileSystemItem getItem() {
        return item;
    }

    public void setItem(FileSystemItem item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean hasCreatePermission() {
        return role.hasCreatePermission();
    }
}
