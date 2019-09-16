#!/usr/bin/env bash
cd $(dirname $0)
curl -F "file=@./MikeVacation.jpg" http://localhost:8080/upload