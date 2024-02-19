FROM mcr.microsoft.com/devcontainers/base:ubuntu
# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

# Install the xz-utils package
RUN apt-get update && \
    apt-get install -y xz-utils && \
    apt-get install -y openjdk-11-jdk
