package ru.netology.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FileOpenManager {

    private Map<String, String> fileOpenManager = new HashMap<>();

    // Регистрировать новое приложение для открытия файлов с определённым расширением
    public void register(String key, String value) {
        fileOpenManager.put(key.toLowerCase(), value.toLowerCase());
    }

    // Получать название приложения, предназначенного для открытия файла с определённым расширением
    public String getAppTitle(String key) {
        return fileOpenManager.get(key.toLowerCase());
    }

    // Удалять привязку приложения к определённому расширению */
    public void disableAssociation(String key) {
        fileOpenManager.remove(key.toLowerCase());
    }

    // Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия
    public Set<String> allExtensions() {
        Set<String> result = new TreeSet<>();
        for (String key : fileOpenManager.keySet()) {
            result.add(key);
        }
        return result;
    }

    // Получать список всех приложений, которые привязаны к каким-либо расширениям
    public Set<String> allApps() {
        Set<String> result = new TreeSet<>();
        for (String key : fileOpenManager.values()) {
            result.add(key);
        }
        return result;
    }

}
