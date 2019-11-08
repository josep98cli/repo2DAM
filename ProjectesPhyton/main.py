from clase_pelicula import *
import requests
import json
import mysql.connector

br = mechanicalsoup.StatefulBrowser()
resp = br.open("https://www.elitetorrent.nu/idioma/castellano-16/?post_type=peliculas%22")

# conection to database
connection = mysql.connector.connect(
    host="localhost",
    database="peliculas",
    user="root",
    passwd=""
)
# pàgina principal de pelis en castellà
if resp.status_code == 200:
    page = br.get_current_page().find("ul", class_="miniboxs miniboxs-ficha")
    lista_peliculas = {
        "peliculas": []
    }
    for i in range(len(page)):
        if i % 2 != 0:
            title = page.contents[i].contents[1].contents[1]["title"]  # Títol de la película
            link = page.contents[i].contents[1].contents[1]["href"]  # Link de la película
            res = page.contents[i].contents[1].contents[5].text  # Resolució de la película
            url = "https://www.elitetorrent.nu/" + page.contents[i].contents[1].contents[1].contents[1][
                "data-src"]  # Url de la imatge
            # Descarreguem la imatge i la guardem en la carpeta images
            imgdata = requests.get(url).content
            with open('images/' + (title.replace(' ', '').replace(':', '')) + '.jpg', 'wb') as handler:
                handler.write(imgdata)

            image = 'images/' + (title.replace(' ', '').replace(':', '')) + '.jpg'  # Ruta de la imatge
            # cree el id aleatoriament
            ident = str(uuid.uuid4())

            # Creem el objecte Pelicula
            pelicula = Pelicula(title, link, image, ident, res)
            # Afegim la película a la llista
            lista_peliculas["peliculas"].append(pelicula.__dict__)

    # afegisc les dades de la pelicula a la base de dades
    cursor = connection.cursor(buffered=True)

    sql = "INSERT INTO pelicula(titulo, link_pelicula, imagen_pelicula, id_pelicula, resolucion) VALUES(%s, %s, %s, %s, %s)"
    values = (title, link, image, ident, res)

    cursor.execute(sql, values)
    connection.commit()

connection.close()
# with open("data.json", "w") as write_file:
#    json.dump(lista_peliculas, write_file, indent=4)
