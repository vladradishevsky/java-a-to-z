package radishevsky.server;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * interface FileManager
 * @author vladradishevsky
 * @since 04.01.2017
 * @version 1.0
 */
public interface FileManager {

    /**
     * Возвращает входящий поток
     * @return
     */
    InputStream getInputStream();

    /**
     * Возвращает исходящий поток
     * @return
     */
    OutputStream getOutputStream();

    /**
     * Возвращает корневой каталог
     * @return
     */
    File getRootDirectory();

    /**
     * Возвращает текущий каталог
     * @return
     */
    File getCurrentDirectory();

    /**
     * Устанавливает текущий каталог
     * @return
     */
    void setCurrentDirectory(File newDirectory);
}
