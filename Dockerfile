FROM quay.io/quarkus/quarkus-micro-image:2.0

WORKDIR /work/

RUN ./mvnw clean package -Dnative -Dquarkus.native.container-build=true -Dquarkus.native.native-image-xmx=6g

COPY target/*-runner /work/application
RUN chmod 775 /work

EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]