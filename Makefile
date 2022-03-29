VERSION = $(shell mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

IMAGE_NAME = "todo:$(VERSION)"

JAR_FILE = "target/todo-$(VERSION).jar"

version:
	@echo $(VERSION)

jar-file:
	mvn package

docker-image: jar-file
	docker build --no-cache -t $(IMAGE_NAME) \
		--build-arg JAR_FILE=$(JAR_FILE) \
		.

run: jar-file
	VERSION=$(VERSION) docker-compose build app; docker-compose up
