import random
# Define a dictionary of patterns and corresponding responses
chatbot_responses = {
    tuple(["hello", "hi"]): ["Greetings! How can I assist you today?", "Hello there! What can I do for you?", "Hi! I'm here to help."],
    tuple(["how are you"]): ["Thank you for asking. I'm functioning optimally. How can I assist you?", "I'm doing well. How can I help you today?", "I'm in good shape. What can I do for you?"],
    tuple(["goodbye"]): ["Goodbye! If you have more questions, feel free to return.", "Farewell! Don't hesitate to return if you need assistance.", "Until next time!"],
    tuple(["name"]): ["You can call me Assistant. How may I assist you today?", "I go by Assistant. How can I be of service?", "I'm known as Assistant. What can I do for you?"],
    tuple(["what's your purpose"]): ["My purpose is to assist and provide information. How can I assist you today?", "I'm here to be your helpful companion. What do you need assistance with?", "I exist to assist you with information. How can I help?"],
    tuple(["who created you"]): ["I was created by abdullah. How may I assist you today?", "My creator is abdullah. How can I be of service?", "abdullah is my creator. What can I do for you?"],
    tuple(["what can you do"]): ["I can provide information, answer questions, and engage in conversation. How can I assist you today?", "I possess the ability to provide information and answer inquiries. What do you need assistance with?", "I'm capable of answering questions and providing information. How may I assist you?"],
    tuple(["tell me a joke"]): ["Certainly! Why don't scientists trust atoms? Because they make up everything!", "Here's a joke: What do you call fake spaghetti? An impasta!", "Sure! How about a joke? Why don't some couples go to the gym? Because some relationships don't work out!"],
    tuple(["how old are you"]): ["I don't have an age. I'm a virtual assistant designed to assist you.", "Age is irrelevant to me. How can I help you today?", "I'm ageless. What can I assist you with?"],
    tuple(["where are you from"]): ["I exist in the digital realm, ready to assist you. How may I help you today?", "My origin is the world of programming. How can I assist you?", "I'm a digital entity here to help. What do you need assistance with?"],
    tuple(["thanks"]): ["You're welcome! If you have more questions, feel free to ask.", "No problem! If there's anything else you need, just let me know.", "Anytime! Let me know if there's anything else I can assist you with."],
    tuple(["help"]): ["How may I assist you today? Feel free to ask any questions.", "I'm here to help. What do you need assistance with?", "I'm at your service. How can I assist you today?"],
    tuple(["favorite color"]): ["I don't have a favorite color as I lack visual experiences. How can I assist you today?", "Colors are intriguing, although I can't perceive them. How may I help you?", "I don't have preferences for colors, but I'm ready to assist you. What can I do for you?"],
    tuple(["tell me a fun fact"]): ["Here's a fascinating fact: Honey never spoils and remains edible for thousands of years!", "Did you know that honey found in ancient Egyptian tombs is still perfectly edible after over 3,000 years?", "Here's an interesting fact: Honey is one of the few foods that never spoil."],
    tuple(["how does a computer work"]): ["Computers process information using electrical signals represented as 0s and 1s. The central processing unit (CPU) acts as the brain of the computer.", "Computers operate by processing electrical signals, interpreting them as binary code. How may I assist you further?", "A computer functions by processing electrical signals in the form of binary code. What else would you like to know?"],
    tuple(["can you sing"]): ["I'm afraid I can't sing. My abilities are focused on providing information and assistance.", "Singing is beyond my capabilities. How may I assist you in other ways?", "Unfortunately, singing is not within my skill set. What else can I help you with?"],
    tuple(["what's the meaning of life"]): ["The meaning of life is a subjective and philosophical question. Different individuals and cultures have diverse perspectives on this profound inquiry.", "The meaning of life is a complex and philosophical topic with varied interpretations. How can I assist you today?", "The meaning of life is subjective and varies from person to person. Is there anything else you'd like to discuss?"],
    tuple(["programming language"]): ["There are various programming languages, such as Python, JavaScript, Java, C++, and more. Each language has its strengths and use cases. How may I assist you in the realm of programming?", "Programming languages like Python, JavaScript, and Java serve different purposes. How can I help you with programming-related queries?", "The world of programming offers languages like Python, JavaScript, and Java, each with its unique features. What specific information are you seeking?"],
    tuple(["best programming language", "best coding language"]): ["The 'best' programming language depends on your goals. Python is known for its simplicity, while C++ is powerful and used in systems programming. How can I assist you with your programming endeavors?", "Selecting the best programming language depends on your objectives. Python is recognized for its simplicity, while C++ excels in system programming. How can I guide you further?", "Determining the best programming language relies on your requirements. Python is valued for its simplicity, while C++ is robust for system programming. What specific information are you seeking?"],
    tuple(["favorite programming language"]): ["I don't have personal preferences, but many developers enjoy using Python for its readability and versatility. How can I assist you with your programming interests?", "As a neutral entity, I don't have personal favorites. However, developers often appreciate Python for its readability and versatility. What programming-related queries do you have?", "While I don't have personal preferences, I understand that developers often favor Python for its readability and versatility. How may I assist you in the realm of programming?"],
    tuple(["coding tips"]): ["When coding, prioritize clean and readable code. Break down complex problems into smaller tasks, and don't hesitate to seek help from online resources or communities. How may I assist you further with coding tips?", "Coding tip: Emphasize clean and readable code. Break down complex problems into manageable tasks, and leverage online resources and communities for assistance. What specific coding tips are you seeking?", "In coding, it's essential to write clean and readable code. Break down complex problems, and don't hesitate to seek guidance from online resources. How can I assist you with coding tips?"],
    tuple(["favorite IDE"]): ["As a chatbot, I don't use an Integrated Development Environment (IDE). However, popular ones among developers include Visual Studio Code, PyCharm, and Sublime Text. How may I assist you with your development tools?", "While I don't have personal experiences with IDEs, many developers appreciate tools like Visual Studio Code, PyCharm, and Sublime Text. What specific information are you seeking about development environments?", "Although I don't utilize an Integrated Development Environment (IDE), developers often prefer tools such as Visual Studio Code, PyCharm, and Sublime Text. How can I assist you with your development tools?"],
    tuple(["project management"]): ["Effective project management involves clear communication, detailed planning, and proactive issue resolution."],
    tuple(["problem-solving in a professional setting"]):["In a professional setting, effective problem-solving requires critical thinking, collaboration, and a systematic approach."],
    tuple(["work-life balance"]): ["Maintaining a work-life balance involves setting priorities, setting boundaries, and taking breaks to recharge."],
    # General Questions
    tuple(["interesting historical facts"]): ["Did you know that the Great Wall of China is over 13,000 miles long? It's a marvel of ancient engineering!"],
    tuple(["concept of mindfulness"]): ["Mindfulness is the practice of being present in the moment, observing thoughts and sensations without judgment."],
    tuple(["importance of environmental sustainability"]): ["Environmental sustainability is crucial for preserving our planet's resources and ensuring a healthy future for generations to come."],
    # Technology Questions
    tuple(["emerging technologies"]): ["Emerging technologies like quantum computing and augmented reality are poised to revolutionize various industries."],
    tuple(["impact of artificial intelligence"]): ["Artificial intelligence enhances daily life through applications like virtual assistants, personalized recommendations, and autonomous systems."],
    tuple(["basics of blockchain technology"]): ["Blockchain is a decentralized and distributed ledger technology that ensures transparency, security, and immutability in transactions."],

    # Python
    tuple(["python programming"]): ["Python is a high-level programming language known for its simplicity and readability."],
    tuple(["python data type","python data types"]): ["Data types in Python include int, float, str, list, tuple, dict, bool, etc."],
    tuple(["python variables","python variable"]): ["Variables in Python are used to store and manage data."],
    tuple(["python lists","python list"]): ["Lists are ordered, mutable, and can contain elements of different data types."],
    tuple(["python dictionaries", "python dictionary"]): ["Dictionaries in Python store data in key-value pairs."],
    tuple(["python functions"]): ["Functions in Python are defined using the `def` keyword."],
    tuple(["python classes"]): ["Classes in Python are used to create objects with attributes and methods."],
    tuple(["python modules"]): ["Modules in Python are files containing Python code that can be imported into other Python scripts."],
    tuple(["python libraries"]): ["Libraries in Python provide pre-written code for various functionalities."],
    tuple(["python frameworks"]): ["Frameworks in Python are structured sets of tools and best practices for developing applications."],
    tuple(["python best practices"]): ["Best practices in Python include adhering to PEP 8 coding standards, writing modular code, and using meaningful variable names."],
    tuple(["python error handling"]): ["Error handling in Python involves using try-except blocks to manage exceptions."],
    tuple(["python debugging techniques"]): ["I don't have a favorite color as I lack visual experiences. How can I assist you today?", "Colors are intriguing, although I can't perceive them. How may I help you?", "I don't have preferences for colors, but I'm ready to assist you. What can I do for you?""Debugging techniques in Python include using print statements, logging, and debugging tools like pdb."],
    tuple(["python virtual environments"]): ["Virtual environments in Python isolate project dependencies to avoid conflicts."],
    tuple(["python decorators"]): [ "Decorators in Python are functions that modify the behavior of other functions."],
    tuple(["python generators"]): ["Generators in Python produce a sequence of values lazily, one at a time."],
    tuple(["python comprehensions"]): ["Comprehensions in Python provide concise syntax for creating lists, dictionaries, and sets."],
    tuple(["python lambda functions"]): ["Lambda functions in Python are anonymous functions defined using the `lambda` keyword."],
    tuple(["python asynchronous programming"]): ["Asynchronous programming in Python is achieved with the `asyncio` library for non-blocking I/O."],
    tuple(["python web development"]): ["Web development in Python can be done using frameworks like Django or Flask."],
    tuple(["python machine learning"]): ["Machine learning in Python is popular with libraries such as TensorFlow and PyTorch."],
    tuple(["python data analysis"]): ["Data analysis in Python is commonly done with libraries like Pandas and NumPy."],
    tuple(["python automation"]): ["Automation in Python can be achieved with tools like Selenium or scripting tasks with Python."],
    tuple(["python testing frameworks"]): ["Testing frameworks in Python include unittest, pytest, and nose."],
    tuple(["python coding standards"]): ["Coding standards in Python, such as PEP 8, help maintain consistent and readable code."],
    # cpp
    tuple(["cpp programming"]): ["C++ is a general-purpose programming language known for its efficiency and performance."],
    tuple(["cpp data types"]): ["Data types in C++ include int, float, double, char, bool, and more."],
    tuple(["cpp variables"]): ["Variables in C++ are used to store and manage data."],
    tuple(["cpp arrays"]): ["Arrays in C++ allow you to store multiple elements of the same data type."],
    tuple(["cpp pointers"]): ["Pointers in C++ are variables that store the memory address of another variable."],
    tuple(["cpp functions"]): ["Functions in C++ are defined using the `function` keyword."],
    tuple(["cpp classes"]): ["Classes in C++ are used to create objects with attributes and methods."],
    tuple(["cpp namespaces"]): ["Namespaces in C++ provide a way to organize code and prevent naming conflicts."],
    tuple(["cpp libraries"]): ["Libraries in C++ provide pre-written code for various functionalities."],
    tuple(["cpp frameworks"]): ["Frameworks in C++ are structured sets of tools and best practices for developing applications."],
    tuple(["cpp best practices"]): ["Best practices in C++ include following coding standards, writing modular code, and using meaningful variable names."],
    tuple(["cpp error handling"]): ["Error handling in C++ involves using try-catch blocks to manage exceptions."],
    tuple(["cpp debugging techniques"]): ["Debugging techniques in C++ include using print statements, logging, and debugging tools."],
    tuple(["cpp memory management"]): ["Memory management in C++ involves allocation and deallocation of memory using `new` and `delete`."],
    tuple(["cpp templates"]): ["Templates in C++ allow you to write generic functions and classes."],
    tuple(["cpp lambda expressions"]): ["Lambda expressions in C++ provide a concise way to define anonymous functions."],
    tuple(["cpp multithreading"]): ["Multithreading in C++ can be achieved using the `<thread>` library."],
    tuple(["cpp file handling"]): ["File handling in C++ involves operations such as reading from and writing to files."],
    tuple(["cpp standard template library"]): ["The Standard Template Library (STL) in C++ provides generic classes and functions."],
    tuple(["cpp object-oriented programming"]): ["Object-oriented programming in C++ involves organizing code around objects and classes."],
    tuple(["cpp game development"]): ["Game development in C++ is popular, and libraries like SDL and Unreal Engine are commonly used."],
    tuple(["cpp GUI programming"]): ["GUI programming in C++ can be done using libraries like Qt."],
    tuple(["cpp networking"]): ["Networking in C++ involves communication between computers, often using sockets."],
    tuple(["cpp unit testing"]): ["Unit testing in C++ can be done using frameworks like Google Test."],
    tuple(["cpp coding standards"]): ["Coding standards in C++, such as following the C++ Core Guidelines, help maintain consistent and readable code."],
}

def chatbot(user_input):
    # Convert user input to lowercase for case-insensitive matching
    user_input = user_input.lower()

    # Check if the input matches any pattern in the dictionary
    for patterns, responses in chatbot_responses.items():
        if any(keyword in user_input for keyword in patterns):
            return random.choice(responses)

    # If no match is found, provide a default response
    return "i didn't understand what do you want to ask"
