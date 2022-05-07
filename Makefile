VERSION = $(shell mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

IMAGE_NAME = "todo:$(VERSION)"

JAR_FILE = "target/todo-$(VERSION).jar"

version:
	@echo $(VERSION)

jar-package:
	mvn package

docker-image: jar-package
	docker build --no-cache -t $(IMAGE_NAME) \
		--build-arg JAR_FILE=$(JAR_FILE) \
		.

run: jar-package
	VERSION=$(VERSION) docker-compose up
