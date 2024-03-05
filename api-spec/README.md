# aaccount-opening-service-api
# Build
Build the api and dto manually by running gradle task openApiGenerate:
```
.\gradlew openApiGenerate
```
This will generate a maven project at `build/generated` folder.

Package to JAR by the generated maven project
```
mvn install
```
The JAR lib will be generated at `build/generated/target/account-opening-service-api-<version>.jar`

Automate the build process later.