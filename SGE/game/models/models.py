# -*- coding: utf-8 -*-

from odoo import models, fields, api
import random


class jugador(models.Model):
    _name = 'game.jugador'
    name = fields.Char()
    ciutat = fields.One2many('game.ciutat', 'jugador')


class ciutat(models.Model):
    _name = 'game.ciutat'
    name = fields.Char(compute='nombreRandom')
    vida = fields.Float(default=1000)
    cerio = fields.Float(default=500)
    lanthanum = fields.Float(default=100)
    erbio = fields.Float(default=0)
    jugador = fields.Many2one('game.jugador')
    def nombreRandom(self):
        lista_nombres = ['Michael Burnham', 'Saru', 'Leonard Nimoy', 'DeForest Kelley', 'James Doohan',
                         'Nichelle Nichols', 'George Takei', 'Grace Lee Whitney', 'Majel Barrett', 'Walter Koenig']

        for r in self:
            random_name = random.choice(lista_nombres)
            r.name = random_name
