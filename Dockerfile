FROM openjdk:21-slim

WORKDIR /app
COPY target/universal/artings-2.0.tgz /app/
RUN tar -xzf artings-2.0.tgz && rm artings-2.0.tgz

EXPOSE 9002

CMD ["./artings-2.0/bin/artings"]