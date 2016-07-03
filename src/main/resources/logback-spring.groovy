import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO



appender("STDOUT",ConsoleAppender){
	encoder(PatternLayoutEncoder) { pattern='%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n' }
}


appender("FILE",RollingFileAppender){
	file='./logs/simple.log'
	rollingPolicy(TimeBasedRollingPolicy) {
		fileNamePattern = "./logs/simple.%d.log"
		maxHistory = 30
	}
	encoder(PatternLayoutEncoder) {
		pattern='%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n'
		charset=Charset.forName("UTF-8")
	}
}

logger("logback", ERROR)

root(INFO, ["STDOUT", "FILE"])