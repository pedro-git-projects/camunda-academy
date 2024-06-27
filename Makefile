# Define the application name and version
APP_NAME=c8-getting-started-microservice-orchestration-lab
VERSION=1.0-SNAPSHOT
SHADED_JAR_FILE=$(APP_NAME)-$(VERSION)-shaded.jar

# Define the target directory
TARGET_DIR=target

# Default target
all: clean package run

# Clean the project
clean:
	mvn clean

# Package the project
package:
	mvn package

# Run the application
run:
	java -jar $(TARGET_DIR)/$(SHADED_JAR_FILE)

# Phony targets to avoid conflicts with files of the same name
.PHONY: all clean package run

