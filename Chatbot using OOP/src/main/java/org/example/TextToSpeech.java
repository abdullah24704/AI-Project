package org.example;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

    private static final String VOICENAME_kevin = "kevin16";
    private Voice voice;

    public TextToSpeech() {
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);

        if (voice != null) {
            voice.allocate();
        } else {
            throw new IllegalStateException("Cannot find a voice named " + VOICENAME_kevin);
        }
    }

    public void speak(String text) {
        try {
            if (voice != null) {
                voice.speak(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deallocate() {
        if (voice != null) {
            voice.deallocate();
        }
    }
}
