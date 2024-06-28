package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        OpenBrowser browser = new OpenBrowser();
        TextToSpeech textToSpeech = new TextToSpeech();
        OpenFileExplorer file = new OpenFileExplorer();
        Scanner scanner = new Scanner(System.in);

        textToSpeech.speak("Welcome! How can I assist you today?");
        System.out.println("Welcome! How can I assist you today?");
        System.out.println("You can type 'exit' to end the conversation.");

        while (true) {
            textToSpeech.speak("Do you want to talk to the bot or perform another action?");
            System.out.println("Do you want to talk to the bot or perform another action?");
            String action = scanner.nextLine().trim().toLowerCase();
            String[] words = action.split("\\s+");
            //thi
            if (action.equals("exit")) {
                textToSpeech.speak("Do you really want to exit? Please type 'yes' to confirm or 'no' to continue.");
                System.out.println("Do you really want to exit? Please type 'yes' to confirm or 'no' to continue.");
                String confirmExit = scanner.nextLine().trim().toLowerCase();
                if (confirmExit.equals("yes")) {
                    textToSpeech.speak("Goodbye! Have a great day!");
                    System.out.println("Goodbye! Have a great day!");
                    break;
                } else {
                    continue;
                }
            }
            // this is for opening file using "file" object and formatfriverletter function by passing filepath variable
            if (words[0].equals("open") && (words[1].equals("file") || words[1].equals("folder"))) {
                System.out.println("Enter the file path you want to open:");
                String filePath = scanner.nextLine();
                filePath = file.formatDriveLetter(filePath);
                String escapedFilePath = filePath.replace("\\", "\\\\").replace("/", "\\\\");
                file.openFileInExplorer(escapedFilePath);
            }
            else if (words[0].equals("move") && words[1].equals("file")) {
                System.out.println("Enter the source path:");
                String sourcePath = scanner.nextLine();
                sourcePath = file.formatDriveLetter(sourcePath);
                System.out.println("Enter the destination path:");
                String destinationPath = scanner.nextLine();
                destinationPath = file.formatDriveLetter(destinationPath);
                String escapedFilePath = sourcePath.replace("\\", "\\\\").replace("/", "\\\\");
                String result = file.moveFile(escapedFilePath, destinationPath);
                System.out.println(result);
            } else if (words[0].equals("delete") && words[1].equals("file")) {
                System.out.println("Enter the file path you want to delete:");
                String filePath = scanner.nextLine();
                filePath = file.formatDriveLetter(filePath);
                String escapedFilePath = filePath.replace("\\", "\\\\").replace("/", "\\\\");

                String result = file.deleteFile(escapedFilePath);
                System.out.println(result);
            } else if (words.length > 1 && words[0].equals("open")) {
                String website = words[1];
                textToSpeech.speak("any question yes or no.");
                System.out.println("any question ? (yes/no):");
                String choice = scanner.nextLine();

                if ("yes".equalsIgnoreCase(choice)) {
                    textToSpeech.speak("Enter your question.");
                    System.out.println("question:");
                    String question = scanner.nextLine();
                    browser.openURL(website, true, question);
                } else {
                    browser.openURL(website, false, "");
                }
                continue;
            } else if (action.equals("bot")) {
                while (true) {
                    System.out.print("You: ");
                    String userInput = scanner.nextLine();
                    if (userInput.equals("exit")) {
                        textToSpeech.speak("Goodbye!");
                        System.out.println("Goodbye!");
                        break;
                    }
                    // Get response from the chatbot
                    String response = Bot.chat(userInput);
                    textToSpeech.speak(response);
                    System.out.println("Chatbot: " + response);
                }
            } else if (words[0].equals("take") || words[0].equals("screenshot")) {
                ScreenshotTaker screenshotTaker = new ScreenshotTaker();
                screenshotTaker.takeScreenshot();
            }else {
                continue;
            }
            scanner.close();

        }
    }
}
