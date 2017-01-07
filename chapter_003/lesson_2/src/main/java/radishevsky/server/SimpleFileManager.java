package radishevsky.server;

import java.io.*;
import java.util.Properties;

/**
 * Class SimpleFileManager
 * @author vladradishevsky
 * @since 06.01.2017
 * @version 1.0
 */
public class SimpleFileManager implements FileManager {

    private final String LINE_SEPARATOR = System.lineSeparator();
    private final File rootDirectory;
    private File currentDirectory;
    private InputStream is;
    private OutputStream os;


    public SimpleFileManager(File rootDirectory, InputStream is, OutputStream os) {

        this.rootDirectory = rootDirectory;
        this.currentDirectory = this.rootDirectory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!this.currentDirectory.equals(this.rootDirectory)) {
            sb.append("[back]: ..").append(this.LINE_SEPARATOR);
        }
        try {

            for (File file : this.currentDirectory.listFiles()) {
                if (file.isFile()) {
                    sb.append("[file]: ").append(file.getName()).append(this.LINE_SEPARATOR);
                } else if (file.isDirectory()) {
                    sb.append("[dir ]: ").append(file.getName()).append(this.LINE_SEPARATOR);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Возвращает входящий поток
     *
     * @return
     */
    @Override
    public InputStream getInputStream() {
        return this.is;
    }

    /**
     * Возвращает исходящий поток
     *
     * @return
     */
    @Override
    public OutputStream getOutputStream() {
        return this.os;
    }

    /**
     * Возвращает корневой каталог
     *
     * @return
     */
    @Override
    public File getRootDirectory() {
        return this.rootDirectory;
    }

    /**
     * Возвращает текущий каталог
     *
     * @return
     */
    @Override
    public File getCurrentDirectory() {
        return this.currentDirectory;
    }

    /**
     * Устанавливает текущий каталог
     *
     * @param newDirectory
     * @return
     */
    @Override
    public void setCurrentDirectory(File newDirectory) {
        this.currentDirectory = newDirectory;
    }
}
