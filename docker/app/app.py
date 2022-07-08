import os

from flask import Flask
import mysql.connector

app = Flask(__name__)


@app.route('/')
def hello():
    db = mysql.connector.connect(host=os.getenv('DB_HOST'),
                                 user='root',
                                 passwd=os.getenv('DB_PASSWORD'),
                                 database=os.getenv('DB_NAME'),
                                 auth_plugin='mysql_native_password',
                                 )
    cur = db.cursor()
    cur.execute("UPDATE counter SET count = count + 1")
    try:
        db.commit()
    except:
        db.rollback()
    cur.close()
    return 'Hello World'


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8081)
