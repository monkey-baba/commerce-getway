#!/usr/bin/env bash
docker build -t zqiannn/test:1.0.0 .
docker run -p 5555:5555 zqiannn/test:1.0.0