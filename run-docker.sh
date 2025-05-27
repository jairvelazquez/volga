#!/bin/bash
docker build -t volga .
docker stop volga_backend_app || true
docker rm volga_backend_app || true
docker run -d --name volga_backend_app -p 8080:8080 volga