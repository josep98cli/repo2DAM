# -*- coding: utf-8 -*-

from odoo import models, fields, api, tools
import random


class jugador(models.Model):
    _name = 'game.jugador'
    # imageJugador = fields.Binary()
    name = fields.Char(string='Nombre jugador',
                       default=lambda self: self._get_default_name(), )

    @api.model
    def _get_default_name(self):
        lista_nombres = ['Michael Burnham', 'Saru', 'Leonard Nimoy', 'DeForest Kelley', 'James Doohan',
                         'Nichelle Nichols', 'George Takei', 'Grace Lee Whitney', 'Majel Barrett', 'Walter Koenig']

        random_name = random.choice(lista_nombres)
        return random_name

    ciutat = fields.One2many('game.ciutat', 'jugador')

    @api.model
    def create(self, values):
        res = super(jugador, self).create(values)
        names = ['Vulcano', 'Minshara', 'Khan', 'Voyager', 'Tau', 'Cyanga V', 'Defiant', 'Mudd', 'Elanna',
                 'Tholianos', 'Tholia', 'Medusanos']

        f = self.env['game.ciutat'].create({
            'name': str(random.choice(names)),
            'vida': 1000,
            'jugador': res.id,
            'image': self.env.ref('game.img_ciutat').image

        })
        return res


class ciutat(models.Model):
    _name = 'game.ciutat'
    name = fields.Char(string='Nombre ciudades',
                       default=lambda self: self._get_default_name(), )

    image = fields.Binary()

    @api.model
    def _get_default_name(self):
        lista_nombres = ['Vulcano', 'Minshara', 'Khan', 'Voyager', 'Tau', 'Cyanga V', 'Defiant', 'Mudd', 'Elanna',
                         'Tholianos', 'Tholia', 'Medusanos']
        random_name = random.choice(lista_nombres)
        return random_name

    vida = fields.Float()
    jugador = fields.Many2one('game.jugador')
    recursos = fields.One2many('game.recursos', 'ciutat')
    mines = fields.One2many('game.mines', 'ciutat')
    recurs = fields.Many2one('game.recurs')

    @api.model
    def create(self, values):
        res = super(ciutat, self).create(values)
        array_recursos = ['game.cerio', 'game.holmio', 'game.lutecio', 'game.itrio']
        array_mines = ['game.central_fusion', 'game.arco_electrico', 'game.cavitacion', 'rayo_laser']
        for i in array_recursos:
            res.recursos.create({
                'ciutat': res.id,
                'recurs': self.env.ref(i).id,
                'name': self.env.ref(i).name
            })
        for i in array_mines:
            res.mines.create({
                'ciutat': res.id,
                'name': self.env.ref(i).name,
                'nivel': self.env.ref(i).nivel,
                'produccion': self.env.ref(i).nivel
            })

        return res


class recursos(models.Model):
    _name = 'game.recursos'
    name = fields.Char()
    ciutat = fields.Many2one('game.ciutat')
    recurs = fields.Many2one('game.recurs')


class recurs(models.Model):
    _name = 'game.recurs'
    name = fields.Char()
    image = fields.Binary()
    cantidad = fields.Float()
<<<<<<< 5c07f1c81aaf93c945833991c80727a284c9241d
=======
    mina = fields.One2many('game.mina', 'recurs')
    ciutat = fields.Many2one('game.ciutat', 'recurs')
>>>>>>> Millora aspectes views.xml i funcionament


class mines(models.Model):
    _name = 'game.mines'
    name = fields.Char()
    ciutat = fields.Many2one('game.ciutat')
    mina = fields.Many2one('game.mina')

    @api.multi
    def calcular_cantidad(self):
        for i in self.ciutat.recursos:
            if i.name == self.mina.recurs.name:
                print(i.name)


class mina(models.Model):
    _name = 'game.mina'
    name = fields.Char()
    nivel = fields.Integer()
    produccion = fields.Float()
    recurs = fields.Many2one('game.recurs')
<<<<<<< 5c07f1c81aaf93c945833991c80727a284c9241d


class coste(models.Model):
    _name = 'game.costa'
    name = fields.Char()
    recurs = fields.Many2one('game.recurs')
    minutes = fields.Integer()
=======
    minutos = fields.Integer()
    coste = fields.Float(default=lambda self: 600)
>>>>>>> Millora aspectes views.xml i funcionament
