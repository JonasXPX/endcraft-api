FROM openjdk:11

ENV DB_USERNAME=endcraft
ENV DB_PASSWORD=hackme
ENV DB_URL=jdbc:mysql://mysql/endcraft?serverTime=UTC
ENV DB_NAME=endcraft

WORKDIR /app
COPY target/endcraft-api.jar /app
EXPOSE 8080

CMD [ \
    "java", \
    "-Xmx256M", \
    "-XX:+UseConcMarkSweepGC",\
    "-XX:+UseCompressedOops",\
    "-XX:+CMSParallelRemarkEnabled",\
    "-XX:ParallelGCThreads=4",\
    "-XX:ConcGCThreads=2",\
    "-jar", \
    "endcraft-api.jar" \
]