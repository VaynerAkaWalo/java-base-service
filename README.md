# Java Base Service - Template for Spring Boot Based Services

This repository contains a foundational application with the essential infrastructure to create and deploy Spring Boot applications with high efficiency.

## Features

- **Automatic CI Pipeline:** Integrates CI/CD pipeline on pull requests to the main branch.
- **Containerization:** Upon merging to the main branch, a container is built and published to the GitHub Container Registry.
- **Logging Configuration:** Configured with request tracing for better logging and monitoring.
- **Health Check & Info Endpoints:** Ready-to-use endpoints for monitoring application health and retrieving service information.
- **Log Management:** Replaces Logback with Log4j2 for enhanced logging capabilities.

## Getting Started

Follow these steps to create a new service based on this template:

1. **Create Repository:**
   Click the **'Use this template'** button on the GitHub repository page to create a new repository for your service.

2. **Clone the Repository:**
   Pull the newly created repository into your preferred IDE.

3. **Configure Application Settings:**
   Adjust the following configurations to tailor the service to your needs:
    - Update the `rootProject.name` in [settings.gradle](settings.gradle).
    - Modify the `spring.application.name` and `server.port` in [application.properties](src/main/resources/application.properties).

4. **Create Pull Request:**
   After making your modifications, create a pull request and merge it.

5. **Ready for Development:**
   Your new repository should now be ready for additional development.

## Endpoints

The application runs by default on port **8000** with no context path.

### Health Check

```GET /health``` ```GET /healthcheck```
### Expected response
```json
{
    "status": "OK"
}
```

### Service info
```GET /info```
### Expected response
```json
{
    "version":"a4f66f8",
    "uptime":"20193"
}
```

1. Version: Contains short hash of last commit
2. Uptime: Service uptime in milliseconds 

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
