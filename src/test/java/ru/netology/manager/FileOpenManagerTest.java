package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    FileOpenManager manager = new FileOpenManager();
    Collection<String> extSet = new TreeSet<>();
    Collection<String> appSet = new TreeSet<>();
    String app1 = "IDEA";
    String ext1 = ".iml";
    String app2 = "Atom";
    String ext2 = ".Md";
    String app3 = "Notepad";
    String ext3 = ".TXT";

    // Регистрировать новое приложение для открытия файлов с определённым расширением
    @BeforeEach
    void setUp() {
        manager.register(ext1, app1);
        manager.register(ext2, app2);
        manager.register(ext3, app3);
        extSet.add(ext1.toLowerCase());
        extSet.add(ext2.toLowerCase());
        extSet.add(ext3.toLowerCase());
        appSet.add(app1.toLowerCase());
        appSet.add(app2.toLowerCase());
        appSet.add(app3.toLowerCase());
    }

    // Получать название приложения, предназначенного для открытия файла с определённым расширением
    @Test
    public void shouldSearchApplication() {
        assertEquals(app2.toLowerCase(), manager.getAppTitle(ext2));
    }

    // Удалять привязку приложения к определённому расширению
    @Test
    public void shouldRemoveAssociation() {
        manager.disableAssociation(ext2);
        assertNull(manager.getAppTitle(ext2));
    }

    // Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия
    @Test
    public void shouldGetAllExtensions() {
        assertEquals(extSet, manager.allExtensions());
    }

    // Получать список всех приложений, которые привязаны к каким-либо расширениям */
    @Test
    public void shouldGetAllApplications() {
        assertEquals(appSet, manager.allApps());
    }

}