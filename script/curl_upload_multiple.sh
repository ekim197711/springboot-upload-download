#!/usr/bin/env bash
cd $(dirname $0)
curl \
-F "files=@./MikeVacation.jpg" \
-F "files=@./MikeVacation.jpg" \
-F "files=@./MikeVacation.jpg" \
-F "files=@./MikeVacation.jpg" \
http://localhost:8080/uploadmultiple
