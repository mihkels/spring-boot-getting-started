# Spring Boot Getting Started

![Backend build](https://github.com/mihkels/spring-boot-getting-started/actions/workflows/gradle.yml/badge.svg)
![Frontend build](https://github.com/mihkels/spring-boot-getting-started/actions/workflows/deno.yml/badge.svg)

Notes for developing a reactive Spring Boot API and a separate Astro
frontend, and for exploring Gradle, IDEs, GitHub Actions, Docker, and
deployment to DigitalOcean App Platform. The API uses the WebFlux starter
and its embedded Reactor Netty server.

## Requirements

- [mise](https://mise.jdx.dev/getting-started.html) for Java and Deno
- Docker, if you want to run the backend as a container

The project uses Spring Boot 4.1.2, Java 27 (Temurin), Deno 2, and the Gradle
9.8.2 wrapper. The Java and Deno versions are selected in `.mise.toml`; a
separate Gradle installation is not needed. This setup builds a JVM
application and does not provide a GraalVM native-image build.

## Setup

```bash
git clone https://github.com/mihkels/spring-boot-getting-started.git
cd spring-boot-getting-started
mise install
```

The commands below use `mise exec` so they also work without activating mise
in your shell.

## Backend

Build and run the API from the repository root:

```bash
mise exec -- ./gradlew clean build
mise exec -- ./gradlew bootRun
```

The API listens on `http://localhost:8080`. For example:

```bash
curl http://localhost:8080/api
curl http://localhost:8080/demo
curl -X POST 'http://localhost:8080/counter?message=hello'
```

To build and run the backend container:

```bash
docker build -t spring-boot-getting-started .
docker run --rm -p 8080:8080 spring-boot-getting-started
```

## Frontend

The Astro frontend runs separately from the API:

```bash
cd static
mise exec -- deno install --frozen-lockfile
mise exec -- deno lint
mise exec -- deno task build
mise exec -- deno task dev
```

Open the local URL printed by Astro, normally `http://localhost:4321`.
