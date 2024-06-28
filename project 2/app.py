from flask import Flask, render_template, request
import subprocess
import speech_recognition as sr
import win32com.client
import os
import webbrowser
import datetime
import cv2
import pyjokes
import pythoncom

app = Flask(__name__)
chatStr =''
def speak(text):
    pythoncom.CoInitialize()
    speaker = win32com.client.Dispatch("SAPI.SpVoice")
    result = speaker.speak(text)
    pythoncom.CoUninitialize()
    return result

def takeCommand():
    speak("Welcome to A I....")
    r = sr.Recognizer()
    r.pause_threshold =0.9
    try:
        print("Recognizing...")
        user_input = request.form['user_input']
        print(f"User said: {user_input}")
        return user_input
    except Exception as e:
        return "Some Error Occurred. Sorry from bot"

def process_user_input(user_input):
    result = ""
    global chatStr  # Declare chatStr as a global variable
    if "open browser" in user_input.lower():
        site_keywords = set(user_input.split()[2:])
        for site in site_keywords:
         webbrowser.open(f"https://www.{site}.com")
         result = f"Opening the {site}."
         return result

    elif "play music" in user_input.lower():
        music_keywords = set(user_input.split()[2:])
        for music in music_keywords:
            music_path = f'"D:/music/{music}.mp3"'
            os.startfile(music_path)
            result = f"Playing {music}."
        return result

    elif 'the time' in user_input.lower():
        current_time = datetime.datetime.now().strftime("%H:%M")
        speak(f"The current time is {current_time}.")
        result = f"The current time is {current_time}."
        return result

    elif "play a game" in user_input.lower():
        speak("Opening the game Abdullah.")
        from game import gameLoop
        return "Nice Try"

    elif "take a photo" in user_input.lower():
        camera = cv2.VideoCapture(0)
        if not camera.isOpened():
            result = "Error: Could not open the camera."
        else:
            speak("Smile!")
            ret, frame = camera.read()
            if ret:
                cv2.imwrite("C:/Users/quemi/Pictures/Camera Roll/New Bitmap image.bmp", frame)
                speak("Photo captured successfully.")
                result = "Photo captured successfully."
            else:
                speak("Error capturing photo.")
                result = "Error capturing photo."
            camera.release()
        return result

    elif "tell me a joke" in user_input.lower():
        joke = pyjokes.get_joke()
        print(joke)
        speak(joke)
        result = joke
        return result

    elif "use ai" in user_input.lower():
        from bot import chatbot
        print("Hi there")
        speak("Hi there")

        # Check if there is a user prompt from the modified HTML form
        user_prompt = request.form.get('user_prompt')

        if user_prompt:
            # If there is a user prompt, use it instead of taking command from speech recognition
            response = chatbot(user_prompt)
            print(f"Chatbot: {response}")
            speak(response)
        else:
            # If there is no user prompt, continue taking commands using the original logic
            while True:
                user_input = takeCommand()
                if user_input.lower() == "exit":
                    print("Chatbot: Goodbye!")
                    break
                else:
                    response = chatbot(user_input)
                    print(f"Chatbot: {response}")
                    speak(response)

        result = "AI chat session ended."
        return response

    else:
        result = "I didn't understand what you want to ask."
    print("result is: ",result)
    return result


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/run_script', methods=['POST'])
def run_script():
    try:
        user_input = takeCommand().lower()
        print('user input ', user_input)
        result = process_user_input(user_input)
        print("result is ", result)
        return render_template('result.html', result=result)
    except Exception as e:
        print(f"An exception occurred: {e}")
        return "Internal Server Error", 500

if __name__ == '__main__':
    pythoncom.CoInitialize() 
    app.run()
