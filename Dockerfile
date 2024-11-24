FROM ubuntu:latest
LABEL authors="hilquias"

ENTRYPOINT ["top", "-b"]