run:
	./mvnw spring-boot:run

run-compose:
	docker-compose down; docker-compose up -d

build-jar:
	./mvnw clean install -DskipTests

build-image:
	./mvnw docker:build

push-image:
	./mvnw docker:push
