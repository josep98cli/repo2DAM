# -*- coding: utf-8 -*-

from odoo import models, fields, api, tools
import random
from openerp.exceptions import except_orm


class jugador(models.Model):
    _name = 'game.jugador'
    fecha_creacion = fields.Date(default=lambda self: fields.Date.today())
    image = fields.Binary()
    name = fields.Char(string='Nombre jugador',
                       default=lambda self: self._get_default_name(), )
    ciutat = fields.One2many('game.ciutat', 'jugador')

    @api.multi
    def eliminar_jugador(self):
        for j in self:
            for c in j.ciutat:
                for r in c.recursos:
                    r.unlink()
                for m in c.mines:
                    m.unlink()
                c.unlink()
            j.unlink()

    @api.model
    def _get_default_name(self):
        lista_nombres = ['Michael Burnham', 'Saru', 'Leonard Nimoy', 'DeForest Kelley', 'James Doohan',
                         'Nichelle Nichols', 'George Takei', 'Grace Lee Whitney', 'Majel Barrett', 'Walter Koenig']

        random_name = random.choice(lista_nombres)
        return random_name

    @api.model
    def create(self, values):
        res = super(jugador, self).create(values)
        names = ['Vulcano', 'Minshara', 'Khan', 'Voyager', 'Tau', 'Cyanga V', 'Defiant', 'Mudd', 'Elanna',
                 'Tholianos', 'Tholia', 'Medusanos']

        f = self.env['game.ciutat'].create({
            'name': str(random.choice(names)),
            'vida': 1000,
            'jugador': res.id,
        })

        return res

    # metodo que crea una ciudad nueva desde el boton
    @api.multi
    def crear_ciudad(self):
        names = ['Vulcano', 'Minshara', 'Khan', 'Voyager', 'Tau', 'Cyanga V', 'Defiant', 'Mudd', 'Elanna',
                 'Tholianos', 'Tholia', 'Medusanos']
        self.ciutat.create({

            'name': str(random.choice(names)),
            'vida': 1000,
            'jugador': self.id

        })

    @api.model
    def update_recursos(self):  # metodo para el cron
        ciutat_total = self.env['game.ciutat'].search([])

        for c in ciutat_total:
            for r in c.recursos:
                for m in c.mines:
                    if m.mina.recurs.name == r.name:
                        if m.minutos == 0:
                            r.cantidad += m.produccion
                            m.mejora = False
                            m.write({'status': 'Mejorada'})
                        elif m.mejora:
                            m.write({'status': 'Mejorando...'})
                            m.write({'minutos': m.minutos - 1})


class ciutat(models.Model):
    _name = 'game.ciutat'
    name = fields.Char(string='Nombre ciudades',
                       default=lambda self: self._get_default_name(), )
    image = fields.Binary()

    # metodo para coger el nombre por defecto de la ciudad
    @api.model
    def _get_default_name(self):
        lista_nombres = ['Vulcano', 'Minshara', 'Khan', 'Voyager', 'Tau', 'Cyanga V', 'Defiant', 'Mudd', 'Elanna',
                         'Tholianos', 'Tholia', 'Medusanos']
        random_name = random.choice(lista_nombres)
        return random_name

    vida = fields.Float(default=1000)
    jugador = fields.Many2one('game.jugador', ondelete="cascade")
    recursos = fields.One2many('game.recursos', 'ciutat')
    mines = fields.One2many('game.mines', 'ciutat')

    # override a oncreate
    @api.multi
    def create(self, values):
        res = super(ciutat, self).create(values)
        array_recursos = ['game.cerio', 'game.holmio', 'game.lutecio', 'game.itrio']
        array_mines = ['game.central_fusion', 'game.arco_electrico', 'game.cavitacion', 'game.rayo_laser']

        for i in array_recursos:
            r = res.recursos.create({
                'ciutat': res.id,
                'recurs': self.env.ref(i).id,
                'name': self.env.ref(i).name,
                'cantidad': 1000
            })

        for j in array_mines:
            m = res.mines.create({
                'ciutat': res.id,
                'mina': self.env.ref(j).id,
                'name': self.env.ref(j).name,
                'coste': 100
            })

        return res


class recursos(models.Model):
    _name = 'game.recursos'
    name = fields.Char()
    ciutat = fields.Many2one('game.ciutat')
    recurs = fields.Many2one('game.recurs')
    cantidad = fields.Float()

    # calculo del coste para upgradear una mina
    @api.multi
    def calcular_coste(self, recurs1, nivel, produccion, name_mina):

        for r in self:
            if nivel > 0:
                coste = (nivel + 2) * ((produccion + 20) * 10)
            else:
                coste = 100

            if r.name == recurs1.name:
                if r.cantidad >= coste:
                    for m in r.ciutat.mines:
                        if m.name == name_mina:
                            m.mejora = True
                            if m.minutos == 0:
                                m.nivel += 1
                                m.produccion += (nivel + 1) * 100
                                m.minutos = (2 * (nivel + 1))
                                m.tiempo_total = (2 * (nivel + 1))
                                m.coste = coste
                                r.cantidad -= coste

                else:
                    raise except_orm('ERROR',
                                     'Faltan recursos para hacer la mejora')


class recurs(models.Model):
    _name = 'game.recurs'
    name = fields.Char()
    image = fields.Binary()
    mina = fields.One2many('game.mina', 'recurs')
    ciutat = fields.Many2one('game.ciutat', 'recurs')


class mines(models.Model):
    _name = 'game.mines'
    name = fields.Char()
    ciutat = fields.Many2one('game.ciutat')
    mina = fields.Many2one('game.mina')
    coste = fields.Float()
    produccion = fields.Float()
    nivel = fields.Integer()
    minutos = fields.Integer()
    mejora = fields.Boolean(default=False)
    status = fields.Char()
    const_percent = fields.Float(compute='_get_const_percent')
    tiempo_total = fields.Float()

    # metodo que llama a la funcion de calcular cantidad
    @api.multi
    def llamar_calc_cantidad(self):
        self.ciutat.recursos.calcular_coste(self.mina.recurs, self.nivel, self.minutos, self.name)

    @api.depends('minutos')
    def _get_const_percent(self):
        for r in self:
            if r.minutos > 0:
                r.const_percent = 100 - (r.minutos / r.tiempo_total) * 100


class mina(models.Model):
    _name = 'game.mina'
    name = fields.Char()
    image = fields.Char()
    recurs = fields.Many2one('game.recurs')
