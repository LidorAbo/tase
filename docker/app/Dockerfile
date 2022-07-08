FROM python:3.8

EXPOSE 8081

WORKDIR /app

COPY requirements.txt /app
RUN pip3 install -r requirements.txt

COPY app.py /app
CMD python app.py