import org.example.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserTest {
    private static User huy;
    private static User minh;
    private static Drive drive;

    @Before
    public void setUp_User_Drive() {
        huy = new User("Huy");
        drive = new Drive("Mentorship");
        minh = new User("Minh");
    }

    @Test
    public void test_user_add_new_drive() {
        huy.add(drive);
        List<Drive> items = huy.getAllDrives();
        Assert.assertEquals(drive, items.get(0));
    }

    @Test
    public void test_user_add_2_drives() {
        huy.add(drive);
        huy.add(new Drive("dropbox"));
        List<Drive> items = huy.getAllDrives();
        Assert.assertEquals(2, items.size());
    }

    @Test
    public void test_owner_drive_add_new_folder_to_drive() {
        huy.add(drive);
        Folder folder = new Folder("Java");
        huy.add(folder, drive);
        Folder actual = drive.getFolderByName(folder.getName());

        Assert.assertEquals(folder, actual);
        Assert.assertEquals(1,drive.getFolders().size());
    }

    @Test
    public void test_owner_drive_add_new_file_to_drive() {
        huy.add(drive);
        File file = new File("main.java");
        Folder folder = new Folder("Java");
        huy.add(file, drive);

        File actual = drive.getFileByName(file.getName());
        Assert.assertEquals(file, actual);
        Assert.assertEquals(1, drive.getFiles().size());
    }

    @Test
    public void test_owner_add_subfoler_to_folder() {
        Folder f1 = new Folder("C#");
        Folder f2 = new Folder("CardGame");
        huy.add(drive);
        huy.add(f1, drive);
        huy.add(f2, f1);

        Drive d = huy.getAllDrives().get(0);
        Folder actual1 = d.getFolders().get(0);
        Folder actual2 = actual1.getFolders().get(0);

        Assert.assertEquals(f2, actual2);
        Assert.assertEquals(f1,actual1);

    }

    @Test
    public void test_owner_Grant_Admin_Permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.ADMIN, cardGame);

        Assert.assertTrue(minh.hasAdminPermission(cardGame));
        Assert.assertFalse(minh.hasAdminPermission(cSharp));
    }

    @Test
    public void test_user_no_permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.ADMIN, cardGame);
        Assert.assertFalse(minh.hasAdminPermission(cSharp));
        Assert.assertTrue(minh.hasAdminPermission(cardGame));
    }

    @Test
    public void test_user_have_reader_permission_can_read_a_file() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.READER, cSharp);

        Assert.assertTrue(minh.hasReadPermission(cSharp));
        Assert.assertFalse(minh.hasSharePermission(cSharp));
    }

    @Test
    public void test_role_reader_cannot_add_file() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.READER, cSharp);

        minh.add(new File("intership.doc"), cSharp);
        Assert.assertEquals(0, cSharp.getFiles().size());
    }

    @Test
    public void test_contributor_can_add_new_folder() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.CONTRIBUTOR, cSharp);
        Folder main = new Folder("main");
        minh.add(main, cSharp);

        Assert.assertTrue(cSharp.getFolders().contains(main));

    }
    @Test
    public void test_user_cannot_add_new_folder_to_folder_without_permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.CONTRIBUTOR, cSharp);
        Folder main = new Folder("main");
        minh.add(main, drive);

        Assert.assertFalse(drive.getFolders().contains(main));

    }

    @Test
    public void test_contributor_cannot_have_share_permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.CONTRIBUTOR, cSharp);

        User tien = new User("Tien");
        minh.share(tien, Role.READER, cSharp);

        Assert.assertFalse(minh.hasSharePermission(cSharp));
    }

    @Test
    public void test_contributor_cannot_have_share_folder() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);
        huy.share(minh, Role.CONTRIBUTOR, cSharp);
        User tuan = new User("Tuan");

        minh.share(tuan, Role.ADMIN, cSharp);
        Assert.assertEquals(0,tuan.getRolePermissions().size());
    }

    @Test
    public void test_user_cannot_read_without_permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);
        huy.share(minh, Role.CONTRIBUTOR, cSharp);
        Assert.assertFalse(minh.hasReadPermission(cardGame));
    }

    @Test
    public void test_admin_can_add_new_item_to_subfolder() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        Folder src = new Folder("src");

        huy.add(cSharp, drive);
        huy.add(cardGame, cSharp);
        huy.add(src, cardGame);

        User minh = new User("Minh");
        huy.share(minh, Role.ADMIN, cardGame);

        minh.add(new File("abc.xml"), src);
        minh.add(new Folder("ja"), src);
        int fileCount = src.getFiles().size();
        int folderCount = src.getFolders().size();
        Assert.assertEquals(2, fileCount + folderCount);
    }

    @Test
    public void test_contributer_can_add_new_item_to_subfolder() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        Folder src = new Folder("src");
        huy.add(cSharp, drive);
        huy.add(cardGame, cSharp);
        huy.add(src, cardGame);

        User minh = new User("Minh");
        huy.share(minh, Role.CONTRIBUTOR, cardGame);

        minh.add(new File("abc.xml"), src);
        minh.add(new Folder("ja"), src);

        int fileCount = src.getFiles().size();
        int folderCount = src.getFolders().size();
        Assert.assertEquals(2, fileCount + folderCount);
    }

    @Test
    public void test_contributor_can_delete_file_from_folder() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        Folder src = new Folder("src");
        huy.add(cSharp, drive);
        huy.add(cardGame, cSharp);
        huy.add(src, cardGame);
        File main = new File("main.cs");
        huy.add(main, cardGame);

        User minh = new User("Minh");
        huy.share(minh, Role.CONTRIBUTOR, drive);

        minh.delete(main);
        int count = cardGame.getFiles().size();
        Assert.assertEquals(0, count);
    }


    @Test
    public void test_user_cannot_delete_file_without_permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        Folder src = new Folder("src");
        huy.add(cSharp, drive);
        huy.add(cardGame, cSharp);
        huy.add(src, cardGame);
        File main = new File("main.cs");
        huy.add(main, cardGame);

        User minh = new User("Minh");
        huy.share(minh, Role.READER, cardGame);

        Assert.assertFalse(minh.hasDeletePermission(main));

        minh.delete(main);
        Assert.assertEquals(1, cardGame.getFiles().size());
    }

    @Test
    public void test_Not_allowed_to_add_files_with_duplicate_name_to_drive(){
        huy.add(drive);
        huy.add(new File("java.js"), drive);
        Assert.assertFalse(huy.add(new File("java.js"), drive));
    }

    @Test
    public void test_Not_allowed_to_add_folders_with_duplicate_name_to_drive(){
        huy.add(drive);
        huy.add(new Folder("java"), drive);
        Assert.assertFalse(huy.add(new Folder("java"), drive));
    }

    @Test
    public void test_Not_allowed_to_add_files_with_duplicate_name_to_folder(){
        huy.add(drive);
        Folder backend = new Folder("backend");
        huy.add(backend,drive);
        huy.add(new File("main.cs"), backend);

        Assert.assertFalse(huy.add(new File("main.cs"), backend));
    }

    @Test
    public void test_Not_allowed_to_add_folders_with_duplicate_name_to_folder(){
        huy.add(drive);
        Folder backend = new Folder("backend");
        huy.add(backend,drive);
        huy.add(new Folder("java"), backend);

        Assert.assertFalse(huy.add(new Folder("java"), backend));
    }


}
