from flask import Flask, render_template
import os
from flask_sqlalchemy import SQLAlchemy
import mysql
import webbrowser

BASE_DIR = os.path.abspath(os.path.dirname(__file__))
DB_URI = "mysql+mysqlconnector://root@localhost/peliculas".format(username="josep", password="",
                                                                  hostname="localhost:5000",
                                                                  databasename="peliculas")

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = DB_URI
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

db = SQLAlchemy(app)
db.create_all()


@app.route('/localhost:8080/ProjectesPhyton/index.php')
def show_entries():
    connection = db.engine.execute("SELECT titulo, imagen_pelicula FROM pelicula")
    names = [row[0] for row in connection]
    print("pepe")
    return '<h1>Algo ha fet<h1>'


if __name__ == '__main__':
    webbrowser.open_new("http://localhost/ProjectesPhyton/index.php")
    app.run()
