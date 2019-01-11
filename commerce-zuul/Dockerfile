FROM zqiannnn/commerce-suit-base:20190111
MAINTAINER ZQian<zqiannnn@gmail.com>

COPY . /app/

WORKDIR /app

RUN mvn clean package -U -DskipTests

ENV JAVA_OPTS="-Xmx256M -Xms256M -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/target/*.jar" ]
