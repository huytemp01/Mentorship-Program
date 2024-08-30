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
    public void test_owner_drive_add_new_folder_to_drive() {
        huy.add(drive);
        Folder folder = new Folder("Java");
        huy.add(folder, drive);
        Folder actual = drive.getFolderByName(folder.getName());

        Assert.assertEquals(folder, actual);
    }

    @Test
    public void test_owner_drive_add_new_file_to_drive() {
        huy.add(drive);
        File file = new File("main.java");
        Folder folder = new Folder("Java");
        huy.add(file, drive);

        File actual = drive.getFileByName(file.getName());
        Assert.assertEquals(file, actual);
    }

    @Test
    public void test_owner_add_subfoler_to_folder() {
        Folder f1 = new Folder("C#");
        Folder f2 = new Folder("CardGame");
        huy.add(drive);
        huy.add(f1, drive);
        huy.add(f2, f1);

        Drive d = huy.getAllDrives().get(0);
        Folder a = (Folder) d.getSubItems().get(0);
        Folder b = (Folder) a.getSubItems().get(0);

        Assert.assertEquals(f2, b);

    }

    @Test
    public void test_owner_GrantPermission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.ADMIN, cardGame);

        Assert.assertTrue(minh.add(new File("test.ab"), cardGame));
    }

    @Test//////
    public void test_user_no_permission() {
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

        Assert.assertFalse(minh.add(new File("main.cs"), cSharp));
    }

    @Test
    public void test_contributor_can_add_new_folder() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);

        huy.share(minh, Role.CONTRIBUTOR, cSharp);
        Assert.assertTrue(minh.add(new Folder("main"), cSharp));
        Assert.assertFalse(minh.add(new Folder("tcs"), cardGame));
    }

    @Test
    public void test_contributor_cannot_share() {
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
    public void test_user_cannot_read_without_permission() {
        huy.add(drive);
        Folder cSharp = new Folder("C#");
        Folder cardGame = new Folder("CardGame");
        huy.add(cSharp, drive);
        huy.add(cardGame, drive);
        huy.share(minh, Role.CONTRIBUTOR, cSharp);

        Assert.assertFalse(minh.hasDeletePermission(cardGame));
        Assert.assertFalse(minh.hasReadPermission(cardGame));
        Assert.assertFalse(minh.hasSharePermission(cardGame));
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

        Assert.assertTrue(minh.add(new File("abc.xml"), src));
        Assert.assertTrue(minh.add(new Folder("ja"), src));
        Assert.assertFalse(minh.add(new Folder("ja"), cSharp));
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

        Assert.assertTrue(minh.add(new File("abc.xml"), src));
        Assert.assertTrue(minh.add(new Folder("ja"), src));
        Assert.assertFalse(minh.add(new Folder("ja"), cSharp));
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

//        Assert.assertTrue(minh.hasDeletePermission(main));
//        Assert.assertTrue(minh.hasDeletePermission(cSharp));
        Assert.assertTrue(minh.delete(main));
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
        huy.share(minh, Role.CONTRIBUTOR, cardGame);

        Assert.assertTrue(minh.hasDeletePermission(main));
        Assert.assertFalse(minh.hasDeletePermission(cSharp));
    }


}
