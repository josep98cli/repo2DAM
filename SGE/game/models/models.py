# -*- coding: utf-8 -*-

from odoo import models, fields, api, tools
import random
from openerp.exceptions import except_orm
import datetime


class jugador(models.Model):
    _name = 'game.jugador'
    fecha_creacion = fields.Date(default=lambda self: datetime.date.today())
    fecha_muerte = fields.Date(default=lambda self: datetime.date.today() + datetime.timedelta(days=10))
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
        print('\x1b[6;30;42m' + 'Actualizando recursos..' + '\x1b[0m')
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
        print('\x1b[6;30;42m' + 'Recursos actualizados!' + '\x1b[0m')


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
    soldado = fields.One2many('game.soldado', 'ciutat', ondelete="cascade")
    naves = fields.One2many('game.naves', 'ciutat', ondelete="cascade")
    wars = fields.Many2many('game.wars')

    @api.multi
    def refresh_pag(self):
        return {
            'type': 'ir.actions.client',
            'tag': 'reload',
        }

    # override a oncreate
    @api.multi
    def create(self, values):
        res = super(ciutat, self).create(values)
        array_recursos = ['game.cerio', 'game.holmio', 'game.lutecio', 'game.itrio']
        array_mines = ['game.central_fusion', 'game.arco_electrico', 'game.cavitacion', 'game.rayo_laser']
        array_soldats = ['game.soldado_raso', 'game.soldado_avanzado', 'game.teniente', 'game.piloto',
                         'game.comandante']

        array_naves = ['game.nave_basica', 'game.nave_de_asalto', 'game.nave_pesada']

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

        for k in array_soldats:
            q = res.soldado.create({
                'ciutat': res.id,

                'name': self.env.ref(k).name,
                'ataque': self.env.ref(k).ataque,
                'vida': self.env.ref(k).vida,
                'velocidad': self.env.ref(k).velocidad,
                'piloto': self.env.ref(k).piloto,
                'comandante': self.env.ref(k).comandante,
                'cantidad': self.env.ref(k).cantidad,
                'recurs': self.env.ref(k).recurs.id
            })

        for x in array_naves:
            n = res.naves.create({
                'ciutat': res.id,
                'name': self.env.ref(x).name,
                'ataque': self.env.ref(x).ataque,
                'vida': self.env.ref(x).vida,
                'velocidad': self.env.ref(x).velocidad,
                'cantidad': self.env.ref(x).cantidad,
                'recurs': self.env.ref(x).recurs.id,
                'cap_transporte': self.env.ref(x).cap_transporte

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
    ciutat = fields.Many2one('game.ciutat')
    soldado = fields.One2many('game.soldado', 'recurs')
    naves = fields.One2many('game.naves', 'recurs')


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
    image = fields.Binary()
    recurs = fields.Many2one('game.recurs')


class soldado(models.Model):
    _name = 'game.soldado'
    name = fields.Char()
    ciutat = fields.Many2one('game.ciutat')
    ataque = fields.Float()
    vida = fields.Float()
    velocidad = fields.Float()
    piloto = fields.Boolean()
    comandante = fields.Boolean()
    recurs = fields.Many2one('game.recurs')
    cantidad = fields.Integer()
    cant_tropas = fields.Integer(default=0)

    @api.multi
    def comprar_soldado(self):
        for c in self.ciutat:
            for rs in c.recursos:
                for r in rs.recurs:
                    if r.id == self.recurs.id:
                        if rs.cantidad >= self.cantidad:
                            rs.cantidad -= self.cantidad
                            self.cant_tropas += 1
                        else:
                            raise except_orm('ERROR',
                                             'No tienes suficientes recursos para comprar al soldado')


class naves(models.Model):
    _name = 'game.naves'
    name = fields.Char()
    ciutat = fields.Many2one('game.ciutat')
    ataque = fields.Float()
    cap_transporte = fields.Integer()
    vida = fields.Float()
    velocidad = fields.Integer()
    recurs = fields.Many2one('game.recurs')
    cantidad = fields.Integer()
    cant_tropas = fields.Integer(default=0)

    @api.multi
    def comprar_naves(self):
        for c in self.ciutat:
            for rs in c.recursos:
                for r in rs.recurs:
                    if r.id == self.recurs.id:
                        if rs.cantidad >= self.cantidad:
                            rs.cantidad -= self.cantidad
                            self.cant_tropas += 1
                        else:
                            raise except_orm('ERROR',
                                             'No tienes suficientes recursos para comprar la nave')


class wars(models.Model):
    _name = 'game.wars'
    jugador = fields.Many2one('game.jugador')
    atacante = fields.Many2many('game.ciutat', domain="[('id','not in', defensor), ('jugador','=', jugador)]")
    defensor = fields.Many2many('game.ciutat', domain="[('id', 'not in', atacante)]")

    @api.multi
    def ataque(self):
        cant_total_nav = 0
        cant_total_sold = 0

        for a in self.atacante:
            for cn in a.naves:
                cant_total_nav += cn.cant_tropas
            for cs in a.soldado:
                cant_total_sold += cs.cant_tropas

            if cant_total_nav == 0 & cant_total_sold == 0:
                raise except_orm('ERROR',
                                 'No tienes ninguna tropa para poder atacar')
            else:
                print("PEPE")
