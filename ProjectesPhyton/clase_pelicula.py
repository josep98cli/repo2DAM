import os
import mechanicalsoup
import uuid


class Pelicula:
    def __init__(self, name, link, image, res, id):
        self.name = name #nombre de la pelicula
        self.link = link #link de la pagian donde se encuentra la pelicula
        self.image = image #imagen cargada de la pagina
        self.id =id #id unica generada automaticamente
        self.res = str(res)  #resolucion de la imagen mostrada en la web

