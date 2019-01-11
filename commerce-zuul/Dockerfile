FROM zqiannnn/commerce-suit-base:20190111
MAINTAINER ZQian<zqiannnn@gmail.com>

COPY . /app/

WORKDIR /app

RUN mvn clean package -U -DskipTests


ENTRYPOINT ["java", "$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom", "-jar"]

CMD ["target/*.jar"]
