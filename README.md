# Javaagent

This is a small sample to understand the java agent.

Run this program with following command in the terminal


1.Build the program <code>gradle build</code>

2.Execute the jar without agent <code>java -jar build/libs/Javaagent.jar _an-external-class-path_ _a-class-in-that-class-path_</code>

For example <code>java -jar build/libs/Javaagent.jar /Users/liushanchen/IdeaProjects/AfTest/build/classes/main polyu_af.MyList1</code>

OR execute the jar with agent <code>java -javaagent:build/libs/Javaagent.jar -jar build/libs/Javaagent.jar _an-external-class-path_ _a-class-in-that-class-path_</code>

For example <code>java -javaagent:build/libs/Javaagent.jar -jar build/libs/Javaagent.jar /Users/liushanchen/IdeaProjects/AfTest/build/classes/main polyu_af.MyList1</code>

##How to creat a javaagent:
1. Creating the instrumentation agent class<br/>
An instrumentation agent is a class with a special method (premain), with a predefined signature, that the JVM will invoke before the rest of the application for us to set up any instrumentation code. 
2. Package the agent into a jar<br/>
Once we have compiled our agent class, we need to package it into a jar. This step is slightly fiddly, because we also need to create a manifest file. 
3. Run the application with the agent or dynamically load the agent<br/>



##The program exe working flow:

###With -javaagent P
1.premain<br/>
loading jvm classes -- P's Transformer can modify the classes' byte code<br/>
2.main<br/>
load another javaagent D
loading other new classes -- D's & p's Transformer can modify the new classes's byte code <br/>

###Without -javaagent P
1.main<br/>
load another javaagent D
loading other new classes -- D's Transformer can modify the new classes's byte code <br/>

