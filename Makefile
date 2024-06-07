# Define the platform
ifeq ($(OS), Windows_NT)
    MVNW_CMD = mvnw.cmd
else
    MVNW_CMD = ./mvnw
endif

run-compose:
	docker-compose down; docker-compose up -d

run:
	@$(MVNW_CMD) spring-boot:run

build-jar:
	@$(MVNW_CMD) clean install -DskipTests

build-image:
	@$(MVNW_CMD) docker:build

push-image:
	@$(MVNW_CMD) docker:build
