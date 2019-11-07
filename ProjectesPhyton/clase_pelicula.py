import os
import mechanicalsoup
import uuid

class Pelicula:
    def __init__(self, name, link, image, res):
        self.name = name #nombre de la pelicula
        self.link = link #link de la pagian donde se encuentra la pelicula
        self.image = image #imagen cargada de la pagina
        self.id = str(uuid.uuid4()) #id unica generada automaticamente
        self.res = res  #resolucion de la imagen mostrada en la web

    #method for download the film
    def download_film(self):
        br = mechanicalsoup.StatefulBrowser()
        resp = br.open(self.link)

        if resp.status_code == 200:
            div_magnet = br.get_current_page().find("div", class_="enlace_descarga")
            magnet_link = div_magnet.contents[3]["href"]
            os.startfile(magnet_link)  # magnet link