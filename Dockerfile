FROM openjdk:alpine
WORKDIR /home/temp

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/classes app
COPY ${DEPENDENCY}/META-INF app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/lib app/lib

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.swapnil.tweets.ApplicationKt"]
