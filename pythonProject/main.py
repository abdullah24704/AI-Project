import win32com.client
import speech_recognition as sr
import os
import webbrowser
import datetime
import cv2
import pyjokes


def speak(text):
   speaker = win32com.client.Dispatch("SAPI.SpVoice")
   return speaker.speak(text)



chatStr = ""

def takeCommand():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        r.pause_threshold = 0.6
        audio = r.listen(source, 0, 8)
        try:
            print("Recognizing...")
            query = r.recognize_google(audio, language="en-pk")
            print(f"User said: {query}")
            return query
        except Exception as e:
            return "Some Error Occurred. Sorry from bot"


if __name__ == '__main__':
    print('Welcome to  A.I')
    speak("hey abdullah i am  A I")
    while True:
        try:
           print("Listening...")
           query = takeCommand()
        # todo: Add any sites

           site_keywords = set(query.split()[1:])
           for keyword in site_keywords:
               full_url = f'https://www.{keyword}.com'
               if f"open {keyword}".lower() in query.lower():
                 speak(f"Opening {keyword} abdullah...")
                 webbrowser.open(full_url)

        # todo: Add a feature to play a specific song

           music_keywords = set(query.split()[1:])
           for music in music_keywords:
            music_path = f'"D:/music/{music}.mp3"'
           if f"start music {music}".lower() in query.lower():
            speak(f"Opening {music} abdullah...")
            os.startfile(music_path)

           elif 'the time' in query:
            hour = datetime.datetime.now().strftime("%H")
            min = datetime.datetime.now().strftime("%M")
            speak(f"Abdullah time is {hour} baj ke {min} minutes")

           elif "play a game".lower() in query.lower():
             speak("opening game abdullah")
             from anotherone import gameLoop

           elif "photo" in query:
               camera = cv2.VideoCapture(0)  # Use the default camera (you may need to adjust the index)

               if not camera.isOpened():
                   print("Error: Could not open camera.")
               speak("SMILE")
            # Capture a single frame
               ret, frame = camera.read()
               if ret:
                # Save the captured frame as an image file
                   cv2.imwrite("C:/Users/quemi/Pictures/Camera Roll/New Bitmap image.bmp", frame)
                   speak("Photo captured successfully.")
               else:
                   speak("Error capturing photo.")
                # Release the camera
               camera.release()


           elif "tell me a joke".lower() in query.lower():
               joke = pyjokes.get_joke()
               print(joke)
               speak(joke)


           elif "Use ai".lower() in query.lower():

               from bot import chatbot

               print("Hi there")
               speak("hi there")
               while True:
                   user_input = takeCommand()
                   if user_input.lower() == "exit":
                       print("Chatbot: Goodbye!")
                       break
                   else:
                     response = chatbot(user_input)
                     print(f"Chatbot: {response}")
                     speak(response)

           elif "exit".lower() in query.lower():
             exit()

           elif "reset chat".lower() in query.lower():
            chatStr = ""

        except Exception as e:
            print(f"An error occurred: {e}")
        except KeyboardInterrupt:
            print("User interrupted the process. Exiting...")