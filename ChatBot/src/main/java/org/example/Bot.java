package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Bot {


    // Define a map of patterns and corresponding responses
    private static final Map<String[], String[]> chatbotResponses = new HashMap<>();

    static {
        chatbotResponses.put(new String[]{"hello", "hi"}, new String[]{
                "Greetings! How" + " can I assist you today?",
                "Hello there! What can I do for you?",
                "Hi! I'm here to help."
        });
        chatbotResponses.put(new String[]{"how are you","you"}, new String[]{
                "Thank you for asking. I'm functioning optimally. How can I assist you?",
                "I'm doing well. How can I help you today?",
                "I'm in good shape. What can I do for you?"
        });
        chatbotResponses.put(new String[]{"goodbye","bye","exit"}, new String[]{
                "Goodbye! If you have more questions, feel free to return.",
                "Farewell! Don't hesitate to return if you need assistance.",
                "Until next time!"
        });
        chatbotResponses.put(new String[]{"name","your name"}, new String[]{
                "You can call me Assistant. How may I assist you today?",
                "I go by Assistant. How can I be of service?",
                "I'm known as Assistant. What can I do for you?"
        });
        chatbotResponses.put(new String[]{"what's your purpose","your purpose"}, new String[]{
                "My purpose is to assist and provide information. How can I assist you today?",
                "I'm here to be your helpful companion. What do you need assistance with?",
                "I exist to assist you with information. How can I help?"
        });
        chatbotResponses.put(new String[]{"who created you","who creates you"}, new String[]{
                "I was created by Abdullah. How may I assist you today?",
                "My creator is Abdullah. How can I be of service?",
                "Abdullah is my creator. What can I do for you?"
        });
        chatbotResponses.put(new String[]{"what can you do","what can you perform"}, new String[]{
                "I can provide information, answer questions, and engage in conversation. How can I assist you today?",
                "I possess the ability to provide information and answer inquiries. What do you need assistance with?",
                "I'm capable of answering questions and providing information. How may I assist you?"
        });
        chatbotResponses.put(new String[]{"tell me a joke"}, new String[]{
                "Certainly! Why don't scientists trust atoms? Because they make up everything!",
                "Here's a joke: What do you call fake spaghetti? An impasta!",
                "Sure! How about a joke? Why don't some couples go to the gym? Because some relationships don't work out!"
        });
        chatbotResponses.put(new String[]{"how old are you","your age","age"}, new String[]{
                "I don't have an age. I'm a virtual assistant designed to assist you.",
                "Age is irrelevant to me. How can I help you today?",
                "I'm ageless. What can I assist you with?"
        });
        chatbotResponses.put(new String[]{"where are you from"}, new String[]{
                "I exist in the digital realm, ready to assist you. How may I help you today?",
                "My origin is the world of programming. How can I assist you?",
                "I'm a digital entity here to help. What do you need assistance with?"
        });
        chatbotResponses.put(new String[]{"thanks"}, new String[]{
                "You're welcome! If you have more questions, feel free to ask.",
                "No problem! If there's anything else you need, just let me know.",
                "Anytime! Let me know if there's anything else I can assist you with."
        });
        chatbotResponses.put(new String[]{"help"}, new String[]{
                "How may I assist you today? Feel free to ask any questions.",
                "I'm here to help. What do you need assistance with?",
                "I'm at your service. How can I assist you today?"
        });
        chatbotResponses.put(new String[]{"favorite color"}, new String[]{
                "I don't have a favorite color as I lack visual experiences. How can I assist you today?",
                "Colors are intriguing, although I can't perceive them. How may I help you?",
                "I don't have preferences for colors, but I'm ready to assist you. What can I do for you?"
        });
        chatbotResponses.put(new String[]{"tell me a fun fact"}, new String[]{
                "Here's a fascinating fact: Honey never spoils and remains edible for thousands of years!",
                "Did you know that honey found in ancient Egyptian tombs is still perfectly edible after over 3,000 years?",
                "Here's an interesting fact: Honey is one of the few foods that never spoil."
        });
        chatbotResponses.put(new String[]{"how does a computer work"}, new String[]{
                "Computers process information using electrical signals represented as 0s and 1s. The central processing unit (CPU) acts as the brain of the computer.",
                "Computers operate by processing electrical signals, interpreting them as binary code. How may I assist you further?",
                "A computer functions by processing electrical signals in the form of binary code. What else would you like to know?"
        });
        chatbotResponses.put(new String[]{"can you sing"}, new String[]{
                "I'm afraid I can't sing. My abilities are focused on providing information and assistance.but listen badu badi badu badi akh lari badu badi ",
                "Singing is beyond my capabilities. How may I assist you in other ways?",
                "Unfortunately, singing is not within my skill set. What else can I help you with?"
        });
        chatbotResponses.put(new String[]{"what's the meaning of life"}, new String[]{
                "The meaning of life is a subjective and philosophical question. Different individuals and cultures have diverse perspectives on this profound inquiry.",
                "The meaning of life is a complex and philosophical topic with varied interpretations. How can I assist you today?",
                "The meaning of life is subjective and varies from person to person. Is there anything else you'd like to discuss?"
        });
        chatbotResponses.put(new String[]{"programming language"}, new String[]{
                "There are various programming languages, such as Python, JavaScript, Java, C++, and more. Each language has its strengths and use cases. How may I assist you in the realm of programming?",
                "Programming languages like Python, JavaScript, and Java serve different purposes. How can I help you with programming-related queries?",
                "The world of programming offers languages like Python, JavaScript, and Java, each with its unique features. What specific information are you seeking?"
        });
        chatbotResponses.put(new String[]{"best programming language", "best coding language"}, new String[]{
                "The 'best' programming language depends on your goals. Python is known for its simplicity, while C++ is powerful and used in systems programming. How can I assist you with your programming endeavors?",
                "Selecting the best programming language depends on your objectives. Python is recognized for its simplicity, while C++ excels in system programming. How can I guide you further?",
                "Determining the best programming language relies on your requirements. Python is valued for its simplicity, while C++ is robust for system "
        });
        chatbotResponses.put(new String[]{"interesting historical facts"}, new String[]{
                "Did you know that the Great Wall of China is over 13,000 miles long? It's a marvel of ancient engineering!"
        });
        chatbotResponses.put(new String[]{"concept of mindfulness"}, new String[]{
                "Mindfulness is the practice of being present in the moment, observing thoughts and sensations without judgment."
        });
        chatbotResponses.put(new String[]{"importance of environmental sustainability"}, new String[]{
                "Environmental sustainability is crucial for preserving our planet's resources and ensuring a healthy future for generations to come."
        });
        chatbotResponses.put(new String[]{"emerging technologies"}, new String[]{
                "Emerging technologies like quantum computing and augmented reality are poised to revolutionize various industries."
        });
        chatbotResponses.put(new String[]{"impact of artificial intelligence"}, new String[]{
                "Artificial intelligence enhances daily life through applications like virtual assistants, personalized recommendations, and autonomous systems."
        });
        chatbotResponses.put(new String[]{"basics of blockchain technology"}, new String[]{
                "Blockchain is a decentralized and distributed ledger technology that ensures transparency, security, and immutability in transactions."
        });
        chatbotResponses.put(new String[]{"python programming",}, new String[]{
                "Python is a high-level programming language known for its simplicity and readability."
        });
        chatbotResponses.put(new String[]{"python data type","python data types"}, new String[]{
                "Data types in Python include int, float, str, list, tuple, dict, bool, etc."
        });
        chatbotResponses.put(new String[]{"python variables","python variable"}, new String[]{
                "Variables in Python are used to store and manage data."
        });
        chatbotResponses.put(new String[]{"python lists","python list"}, new String[]{
                "Lists are ordered, mutable, and can contain elements of different data types."
        });
        chatbotResponses.put(new String[]{"python dictionaries", "python dictionary"}, new String[]{
                "Dictionaries in Python store data in key-value pairs."
        });
        chatbotResponses.put(new String[]{"python functions"}, new String[]{
                "Functions in Python are defined using the `def` keyword."
        });
        chatbotResponses.put(new String[]{"python classes"}, new String[]{
                "Classes in Python are used to create objects with attributes and methods."
        });
        chatbotResponses.put(new String[]{"python modules"}, new String[]{
                "Modules in Python are files containing Python code that can be imported into other Python scripts."
        });
        chatbotResponses.put(new String[]{"python libraries"}, new String[]{
                "Libraries in Python provide pre-written code for various functionalities."
        });
        chatbotResponses.put(new String[]{"python frameworks"}, new String[]{
                "Frameworks in Python are structured sets of tools and best practices for developing applications."
        });
        chatbotResponses.put(new String[]{"python best practices"}, new String[]{
                "Best practices in Python include adhering to PEP 8 coding standards, writing modular code, and using meaningful variable names."
        });
        chatbotResponses.put(new String[]{"python error handling"}, new String[]{
                "Error handling in Python involves using try-except blocks to manage exceptions."
        });
        chatbotResponses.put(new String[]{"python debugging techniques"}, new String[]{
                "Debugging techniques in Python include using print statements, logging, and debugging tools like pdb."
        });
        chatbotResponses.put(new String[]{"python virtual environments"}, new String[]{
                "Virtual environments in Python isolate project dependencies to avoid conflicts."
        });
        chatbotResponses.put(new String[]{"python decorators"}, new String[]{
                "Decorators in Python are functions that modify the behavior of other functions."
        });
        chatbotResponses.put(new String[]{"python generators"}, new String[]{
                "Generators in Python produce a sequence of values lazily, one at a time."
        });
        chatbotResponses.put(new String[]{"python comprehensions"}, new String[]{
                "Comprehensions in Python provide concise syntax for creating lists, dictionaries, and sets."
        });
        chatbotResponses.put(new String[]{"python lambda functions"}, new String[]{
                "Lambda functions in Python are anonymous functions defined using the `lambda` keyword."
        });
        chatbotResponses.put(new String[]{"python asynchronous programming"}, new String[]{
                "Asynchronous programming in Python is achieved with the `asyncio` library for non-blocking I/O."
        });
        chatbotResponses.put(new String[]{"python web development"}, new String[]{
                "Web development in Python can be done using frameworks like Django or Flask."
        });
        chatbotResponses.put(new String[]{"python machine learning"}, new String[]{
                "Machine learning in Python is popular with libraries such as TensorFlow and PyTorch."
        });
        chatbotResponses.put(new String[]{"python data analysis"}, new String[]{
                "Data analysis in Python is commonly done with libraries like Pandas and NumPy."
        });
        chatbotResponses.put(new String[]{"python automation"}, new String[]{
                "Automation in Python can be achieved with tools like Selenium or scripting tasks with Python."
        });
        chatbotResponses.put(new String[]{"python testing frameworks"}, new String[]{
                "Testing frameworks in Python include unittest, pytest, and nose."
        });
        chatbotResponses.put(new String[]{"python coding standards"}, new String[]{
                "Coding standards in Python, such as PEP 8, help maintain consistent and readable code."
        });
        chatbotResponses.put(new String[]{"cpp programming","c++","cpp"}, new String[]{
                "C++ is a general-purpose programming language known for its efficiency and performance."
        });
        chatbotResponses.put(new String[]{"cpp data types"}, new String[]{
                "Data types in C++ include int, float, double, char, bool, and more."
        });
        chatbotResponses.put(new String[]{"cpp variables"}, new String[]{
                "Variables in C++ are used to store and manage data."
        });
        chatbotResponses.put(new String[]{"cpp arrays"}, new String[]{
                "Arrays in C++ allow you to store multiple elements of the same data type."
        });
        chatbotResponses.put(new String[]{"cpp pointers"}, new String[]{
                "Pointers in C++ are variables that store the memory address of another variable."
        });
        chatbotResponses.put(new String[]{"cpp functions"}, new String[]{
                "Functions in C++ are defined using the `function` keyword."
        });
        chatbotResponses.put(new String[]{"cpp classes"}, new String[]{
                "Classes in C++ are used to create objects with attributes and methods."
        });
        chatbotResponses.put(new String[]{"cpp namespaces"}, new String[]{
                "Namespaces in C++ provide a way to organize code and prevent naming conflicts."
        });
        chatbotResponses.put(new String[]{"cpp libraries"}, new String[]{
                "Libraries in C++ provide pre-written code for various functionalities."
        });
        chatbotResponses.put(new String[]{"cpp frameworks"}, new String[]{
                "Frameworks in C++ are structured sets of tools and best practices for developing applications."
        });
        chatbotResponses.put(new String[]{"cpp best practices"}, new String[]{
                "Best practices in C++ include following coding standards, writing modular code, and using meaningful variable names."
        });
        chatbotResponses.put(new String[]{"cpp error handling"}, new String[]{
                "Error handling in C++ involves using try-catch blocks to manage exceptions."
        });
        chatbotResponses.put(new String[]{"cpp debugging techniques"}, new String[]{
                "Debugging techniques in C++ include using print statements, logging, and debugging tools."
        });
        chatbotResponses.put(new String[]{"cpp memory management"}, new String[]{
                "Memory management in C++ involves allocation and deallocation of memory using `new` and `delete`."
        });
        chatbotResponses.put(new String[]{"cpp templates"}, new String[]{
                "Templates in C++ allow you to write generic functions and classes."
        });
        chatbotResponses.put(new String[]{"cpp lambda expressions"}, new String[]{
                "Lambda expressions in C++ provide a concise way to define anonymous functions."
        });
        chatbotResponses.put(new String[]{"cpp multithreading"}, new String[]{
                "Multithreading in C++ can be achieved using the `<thread>` library."
        });
        chatbotResponses.put(new String[]{"cpp file handling"}, new String[]{
                "File handling in C++ involves operations such as reading from and writing to files."
        });
        chatbotResponses.put(new String[]{"cpp standard template library"}, new String[]{
                "The Standard Template Library (STL) in C++ provides generic classes and functions."
        });
        chatbotResponses.put(new String[]{"cpp object-oriented programming"}, new String[]{
                "Object-oriented programming in C++ involves organizing code around objects and classes."
        });
        chatbotResponses.put(new String[]{"cpp game development"}, new String[]{
                "Game development in C++ is popular, and libraries like SDL and Unreal Engine are commonly used."
        });
        chatbotResponses.put(new String[]{"cpp GUI programming"}, new String[]{
                "GUI programming in C++ can be done using libraries like Qt."
        });
        chatbotResponses.put(new String[]{"cpp networking"}, new String[]{
                "Networking in C++ involves communication between computers, often using sockets."
        });
        chatbotResponses.put(new String[]{"cpp unit testing"}, new String[]{
                "Unit testing in C++ can be done using frameworks like Google Test."
        });
        chatbotResponses.put(new String[]{"cpp coding standards"}, new String[]{
                "Coding standards in C++, such as following the C++ Core Guidelines, help maintain consistent and readable code."
        });
        chatbotResponses.put(new String[]{"java"}, new String[]{
                "Java is a high-level programming language known for its platform independence and object-oriented approach."
        });
        chatbotResponses.put(new String[]{"java programming"}, new String[]{
                "Java is a high-level programming language known for its platform independence and object-oriented approach."
        });
        chatbotResponses.put(new String[]{"java data types"}, new String[]{
                "Data types in Java include int, float, double, char, boolean, and more."
        });
        chatbotResponses.put(new String[]{"java variables"}, new String[]{
                "Variables in Java are used to store and manage data."
        });
        chatbotResponses.put(new String[]{"java arrays"}, new String[]{
                "Arrays in Java allow you to store multiple elements of the same data type."
        });
        chatbotResponses.put(new String[]{"java pointers"}, new String[]{
                "Java does not have pointers like C or C++. Instead, it uses references to objects."
        });
        chatbotResponses.put(new String[]{"java functions"}, new String[]{
                "Functions in Java are called methods and are defined within classes."
        });
        chatbotResponses.put(new String[]{"java classes"}, new String[]{
                "Classes in Java are used to create objects with attributes and methods."
        });
        chatbotResponses.put(new String[]{"java inheritance"}, new String[]{
                "Inheritance in Java allows a class to inherit attributes and methods from another class."
        });
        chatbotResponses.put(new String[]{"java interfaces"}, new String[]{
                "Interfaces in Java define a contract for classes to implement, specifying methods they must contain."
        });
        chatbotResponses.put(new String[]{"java packages"}, new String[]{
                "Packages in Java provide a way to organize classes into namespaces."
        });
        chatbotResponses.put(new String[]{"java libraries"}, new String[]{
                "Libraries in Java provide pre-written code for various functionalities."
        });
        chatbotResponses.put(new String[]{"java frameworks"}, new String[]{
                "Frameworks in Java, like Spring and Hibernate, provide structured sets of tools and best practices for developing applications."
        });
        chatbotResponses.put(new String[]{"java best practices"}, new String[]{
                "Best practices in Java include following naming conventions, writing modular code, and using design patterns."
        });
        chatbotResponses.put(new String[]{"java exception handling"}, new String[]{
                "Exception handling in Java involves using try-catch blocks to manage exceptions."
        });
        chatbotResponses.put(new String[]{"java debugging techniques"}, new String[]{
                "Debugging techniques in Java include using print statements, logging, and debugging tools like the Java Debugger (jdb)."
        });
        chatbotResponses.put(new String[]{"java memory management"}, new String[]{
                "Memory management in Java is handled automatically by the JVM through garbage collection."
        });
        chatbotResponses.put(new String[]{"java multithreading"}, new String[]{
                "Multithreading in Java allows concurrent execution of multiple threads within a single process."
        });
        chatbotResponses.put(new String[]{"java file handling"}, new String[]{
                "File handling in Java involves operations such as reading from and writing to files using classes like FileInputStream and FileOutputStream."
        });
        chatbotResponses.put(new String[]{"java GUI programming"}, new String[]{
                "GUI programming in Java can be done using libraries like Swing and JavaFX."
        });
        chatbotResponses.put(new String[]{"java networking"}, new String[]{
                "Networking in Java involves communication between computers, often using sockets and classes like Socket and ServerSocket."
        });
        chatbotResponses.put(new String[]{"java unit testing"}, new String[]{
                "Unit testing in Java can be done using frameworks like JUnit and TestNG."
        });
        chatbotResponses.put(new String[]{"java coding standards"}, new String[]{
                "Coding standards in Java, such as following the Java Code Conventions, help maintain consistent and readable code."
        });
    }



  // Add more patterns and responses as needed


    public static String chat(String userInput) {
        // Convert user input to lowercase for case-insensitive matching
        userInput = userInput.toLowerCase();
        boolean isSingleWord = userInput.trim().contains(" ") == false;

        // Check if any pattern in the map matches the user input
        for (Map.Entry<String[], String[]> entry : chatbotResponses.entrySet()) {
            String[] patterns = entry.getKey();
            for (String pattern : patterns) {
                if (isSingleWord) {
                    // Split the pattern into words and match each word individually for single-word input
                    String[] patternWords = pattern.split(" ");
                    for (String patternWord : patternWords) {
                        if (userInput.equals(patternWord)) {
                            // Return a random response from the matched patterns
                            String[] responses = entry.getValue();
                            return responses[new Random().nextInt(responses.length)];
                        }
                    }
                } else {
                    // For multi-word input, match the entire input with the pattern
                    if (userInput.contains(pattern)) {
                        // Return a random response from the matched patterns
                        String[] responses = entry.getValue();
                        return responses[new Random().nextInt(responses.length)];
                    }
                }
            }
        }

        // If no match is found, provide a default response
        return "I didn't understand what you want to ask.";
    }
    }

