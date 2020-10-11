# Data-Driven-And-Keyword-Framework

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

