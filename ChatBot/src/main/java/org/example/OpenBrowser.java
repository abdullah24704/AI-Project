package org.example;

import java.awt.Desktop;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

public class OpenBrowser {

    private final TextToSpeech textToSpeech;

    public OpenBrowser() {
        textToSpeech = new TextToSpeech();
    }

    public void openURL(String url, boolean isQuestion, String query) {
        try {
            String tempURL = url;
            // Ensure the URL contains ".com"
            if (!url.contains(".com")) {
                url += ".com";
            }

            // Ensure the URL starts with "http://" or "https://"
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            if (isQuestion) {
                // URL-encode the query to make it safe for use in a query string
                String encodedQuery = URLEncoder.encode(query, "UTF-8");
                // Append the encoded query to the URL
                url = url + "/search?q=" + encodedQuery;
            }

            // Announce that the website is being opened
            textToSpeech.speak("Opening " + tempURL);

            // Check if the Desktop API is supported
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Check if the browse action is supported
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Create a URI object
                    URI uri = new URI(url);

                    // Open the default browser with the specified URL
                    desktop.browse(uri);
                } else {
                    System.err.println("Browsing action is not supported on this system.");
                }
            } else {
                System.err.println("Desktop API is not supported on this system.");
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error encoding the query: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            textToSpeech.deallocate();
        }
    }
}
