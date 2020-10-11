






















DataDrivenAndKeWordScenarioFramework

Step:
1... Create Maven Project
2... Delete default packages 
3... Create utils package 
     a) create ExcelDataProvider class
     b) create ExcUtils class 
     c) create ExcelUtilsTest class 
     d) create Screenshots class 

4... Click on Maven Project and create below folders
     a) create excel
     b) create Logs
     c) create Screenshots

5... Import dependencies to POM.xml and save it.

6... Click on src/main/java and navigate to file then, create Log4J2.propertiesfile - insert




name=PropertiesConfig
property.filename = logs
appenders = console, file

appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = [%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n

appender.file.type = File
appender.file.name = LOGFILE
appender.file.fileName=${filename}/propertiesMylogs.log
appender.file.layout.type=PatternLayout
appender.file.layout.pattern=[%-5level] %{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
appender.file.append = true

loggers=file
logger.file.name=log
logger.file.level = trace
logger.file.appenderRefs = file
logger.file.appenderRef.file.ref = LOGFILE

rootLogger.level = trace
rootLogger.appenderRefs = stdout
rootLogger.appenderRef.stdout.ref = STDOUT

