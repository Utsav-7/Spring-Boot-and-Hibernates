# Two option for running the app

# 1. Use java -jar 
  > java -jar appName.jar

# 2. Use Spring boot Maven plugin
--> It is provided two files 
  # 1. mvnw.cmd for MS windows
    > mvnw clean compile test
  # 2. mvnw.sh for Linux/Mac 
    $ ./mvnw clean compile test
    
 also use,
    $ ./mvnw package
    $ ./mvnw spring-boot:run
