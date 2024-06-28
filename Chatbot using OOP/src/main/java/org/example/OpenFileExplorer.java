package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class OpenFileExplorer {

    public String formatDriveLetter(String filePath) {
        if (filePath.length() > 1 && Character.isLetter(filePath.charAt(0)) && (filePath.charAt(1) == '/' || filePath.charAt(1) == '\\')) {
            filePath = filePath.charAt(0) + ":" + filePath.substring(1);
        }
        return filePath;
    }

    public void openFileInExplorer(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("The file does not exist.");
            return;
        }

        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported on this system.");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
            System.out.println("File opened in file explorer.");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to open the file.");
            e.printStackTrace();
        }
    }

    public String moveFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath, sourceFile.getName());

        if (!sourceFile.exists()) {
            return "Error: Source file '" + sourcePath + "' does not exist.";
        }

        if (!destinationFile.getParentFile().exists()) {
            return "Error: Destination directory '" + destinationPath + "' does not exist.";
        }

        try {
            Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "File '" + sourcePath + "' successfully moved to '" + destinationFile.getAbsolutePath() + "'.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: An error occurred while moving the file.";
        }
    }

    public String deleteFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return "Error: File '" + filePath + "' does not exist.";
        }

        if (file.delete()) {
            return "File '" + filePath + "' successfully deleted.";
        } else {
            return "Error: An error occurred while deleting the file.";
        }
    }
}
