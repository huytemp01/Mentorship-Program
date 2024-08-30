package org.example;

public enum Role {
    ADMIN, CONTRIBUTOR, READER;

    public boolean hasCreatePermission(){
        return this.equals(ADMIN) || this.equals(CONTRIBUTOR);
    }

    public  boolean hasModifyPermission(){
        return this.equals(ADMIN) || this.equals(CONTRIBUTOR);
    }

    public  boolean hasSharePermission(){
        return this.equals(ADMIN);
    }

    public  boolean hasReadPermission(){
        return this.equals(ADMIN) || this.equals(CONTRIBUTOR) || this.equals(READER);
    }

    public boolean isAdmin() {
        return this.equals(ADMIN);
    }

    public boolean hasDeletePermission() {
        return this.equals(ADMIN) || this.equals(CONTRIBUTOR);
    }
}
