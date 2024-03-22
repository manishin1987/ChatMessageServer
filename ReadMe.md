

# CyberSpeed Chat Message

## Overview
One stop application for user conversations and store them into MongoDB using SpringBoot and Websocket

## Table of Contents
- [Features](#features)
- [Installation](#installation)
---

## Features
- User authentication with basic username/password login. The credentials can be hardcoded.
- Creation of a single chat room upon server startup. No need to create multiple rooms.
- Persistent storage of chat messages in a Database.
- Sending and receiving messages in the chat room. The client must be able to fetch the room messages
- RESTful endpoints for message sending, and message retrieval.
- WebSocket support for real-time chat communication.
- Server scalability using docker containers
---

## Installation
Provide step-by-step instructions on how to install and set up your project locally.

```bash
# Clone the repository
clone the project

# Change into the project directory
cd your-project

# Build the project
./mvnw clean install
```