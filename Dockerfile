FROM openjdk:8-jre-slim

EXPOSE 8088

RUN mkdir /app

COPY build/libs/*.jar /app/eight-shop.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/eight-shop.jar"]

kubectl run demo-app --image=demo-app:latest --port=8088 --image-pull-policy Never

kubectl expose deployment demo-app --type=NodePort

docker run --name="demo-app" --publish 9001:8088 demo-app

docker run --name="eight-shop" --publish 9001:8088 visdocker10/eight-shop:latest

docker build --tag=visdocker10/eight-shop:latest --rm=true .