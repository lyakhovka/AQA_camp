FROM maven:3.6.0-jdk-11-slim
WORKDIR /AQA_camp
COPY . .
ENTRYPOINT ["mvn", "clean", "test"]
CMD ["-Dtest=P1TestsSuite"]