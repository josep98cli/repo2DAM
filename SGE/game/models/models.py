# -*- coding: utf-8 -*-

from odoo import models, fields, api, tools
import random


class jugador(models.Model):
    _name = 'game.jugador'
    # imageJugador = fields.Binary()
    name = fields.Char(string='Nom jugadors',
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
            'jugador': res.id

        })
        return res


class ciutat(models.Model):
    _name = 'game.ciutat'
    name = fields.Char(string='Nom ciutats',
                       default=lambda self: self._get_default_name(), )

    @api.model
    def _get_default_name(self):
        lista_nombres = ['Vulcano', 'Minshara', 'Khan', 'Voyager', 'Tau', 'Cyanga V', 'Defiant', 'Mudd', 'Elanna',
                         'Tholianos', 'Tholia', 'Medusanos']
        random_name = random.choice(lista_nombres)
        return random_name

    vida = fields.Float(default=1000)
    jugador = fields.Many2one('game.jugador')
    recursos = fields.One2many('game.recursos', 'ciutat')


class recursos(models.Model):
    _name = 'game.recursos'
    ciutat = fields.Many2one('ciutat')
    recurs = fields.Many2one('recurs')


class recurs(models.Model):
    _name = 'game.recurs'
    name = fields.Char()
    image = fields.Binary()
    cantidad = fields.Float()
    ciutat = fields.Many2one('game.ciutat')
