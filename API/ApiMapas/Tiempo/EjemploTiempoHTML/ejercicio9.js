'use strict'
class Meteo {
  constructor() {
    this.apikey = 'bf5d5874078f74e1bf2157e6ee127492'
    this.ciudad = 'Oviedo'
    this.tipo = "&mode=xml";
    this.codigoPais = 'ES'
    this.unidades = '&units=metric'
    this.idioma = '&lang=es'
    this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + this.ciudad + this.tipo + this.unidades + this.idioma + "&APPID=" + this.apikey;
    this.correcto = "Â¡Todo correcto! JSON recibido de <a href='http://openweathermap.org'>OpenWeatherMap</a>"
	//http://api.openweathermap.org/data/2.5/forecast?q=Oviedo&mode=xml&units=metric&lang=es&APPID=? 
	// da el tiempo por horas. 
  }
  cargarDatos() {
    $.ajax({
      dataType: 'xml',
      url: this.url,
      method: 'GET',
      success: function (datos) {
        // PresentaciÃ³n de los datos contenidos en XML
        var nombre = $('city', datos).attr("name");
        var pais = $('country', datos).text();
        var coorLat = $('coord', datos).attr("lat");
        var coorLon = $('coord', datos).attr("lon");
        var temperatura = $('temperature', datos).attr("value");
        var tempMax = $('temperature', datos).attr("max");
        var tempMin = $('temperature', datos).attr("min");
        var presion = $('pressure', datos).attr("value");
        var humedad = $('humidity', datos).attr("value");
        var amanecer = $('sun', datos).attr("rise");
        var minutosZonaHoraria = new Date().getTimezoneOffset();
        var amanecerMiliSeg1970 = Date.parse(amanecer);
        amanecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var amanecerLocal = (new Date(amanecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var oscurecer = $('sun', datos).attr("set");
        var oscurecerMiliSeg1970 = Date.parse(oscurecer);
        oscurecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var oscurecerLocal = (new Date(oscurecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var veloViento = $('speed', datos).attr("value");
        var horaMedida = $('lastupdate', datos).attr("value");
        var horaMedidaMiliSeg1970 = Date.parse(horaMedida);
        horaMedidaMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var horaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleTimeString("es-ES");
        var fechaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleDateString("es-ES");
        var visibility = $('visibility', datos).attr("value");
        var nubosidad = $('clouds', datos).attr("value");
        var descripcion = $('weather', datos).attr("value");
        var icon = $('weather', datos).attr("icon"); 
        var imagen=  "<img src="+  "'http://api.openweathermap.org/img/w/" + icon + ".png'" + " />";
        var array = []

        array.push(imagen);
        array.push(nombre)
        array.push(pais)
        array.push(coorLat)
        array.push(coorLon)
        array.push(temperatura)
        array.push(tempMax)
        array.push(tempMin)
        array.push(presion)
        array.push(humedad)
        array.push(amanecerLocal)
        array.push(oscurecerLocal)
        array.push(veloViento)
        array.push(horaMedidaLocal)
        array.push(fechaMedidaLocal)
        array.push(visibility)
        array.push(nubosidad)
        array.push(descripcion)


        var tds = '<tr>'
        array.forEach(element => {

          tds += '<td>' + element + '</td>'
        })
        tds += '</tr>'
        $('#tabla').append(tds)
      },
      error: function () {
        $('h3').html("Â¡Tenemos problemas! No puedo obtener JSON de <a href='http://openweathermap.org'>OpenWeatherMap</a>")
        $('h4').remove()
        $('pre').remove()
        $('p').remove()
      }
    })
  }

  verXML() {
    // Muestra el archivo XML recibido
    this.cargarDatos()
  }
}

class MeteoBogota {
  constructor() {
    this.apikey = '?'
    this.ciudad = 'Bogota'
    this.tipo = "&mode=xml";
    this.codigoPais = 'COL'
    this.unidades = '&units=metric'
    this.idioma = '&lang=es'
    this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + this.ciudad + this.tipo + this.unidades + this.idioma + "&APPID=" + this.apikey;
    this.correcto = "Â¡Todo correcto! JSON recibido de <a href='http://openweathermap.org'>OpenWeatherMap</a>"
  }
  cargarDatos() {
    $.ajax({
      dataType: 'xml',
      url: this.url,
      method: 'GET',
      success: function (datos) {
        // PresentaciÃ³n de los datos contenidos en XML
        var nombre = $('city', datos).attr("name");
        var pais = $('country', datos).text();
        var coorLat = $('coord', datos).attr("lat");
        var coorLon = $('coord', datos).attr("lon");
        var temperatura = $('temperature', datos).attr("value");
        var tempMax = $('temperature', datos).attr("max");
        var tempMin = $('temperature', datos).attr("min");
        var presion = $('pressure', datos).attr("value");
        var humedad = $('humidity', datos).attr("value");
        var amanecer = $('sun', datos).attr("rise");
        var minutosZonaHoraria = new Date().getTimezoneOffset();
        var amanecerMiliSeg1970 = Date.parse(amanecer);
        amanecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var amanecerLocal = (new Date(amanecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var oscurecer = $('sun', datos).attr("set");
        var oscurecerMiliSeg1970 = Date.parse(oscurecer);
        oscurecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var oscurecerLocal = (new Date(oscurecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var veloViento = $('speed', datos).attr("value");
        var horaMedida = $('lastupdate', datos).attr("value");
        var horaMedidaMiliSeg1970 = Date.parse(horaMedida);
        horaMedidaMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var horaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleTimeString("es-ES");
        var fechaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleDateString("es-ES");
        var visibility = $('visibility', datos).attr("value");
        var nubosidad = $('clouds', datos).attr("value");
        var descripcion = $('weather', datos).attr("value");
        var icon = $('weather', datos).attr("icon"); 
        var imagen=  "<img src="+  "'http://api.openweathermap.org/img/w/" + icon + ".png'" + " />";
        var array = []

        array.push(imagen);
        array.push(nombre)
        array.push(pais)
        array.push(coorLat)
        array.push(coorLon)
        array.push(temperatura)
        array.push(tempMax)
        array.push(tempMin)
        array.push(presion)
        array.push(humedad)
        array.push(amanecerLocal)
        array.push(oscurecerLocal)
        array.push(veloViento)
        array.push(horaMedidaLocal)
        array.push(fechaMedidaLocal)
        array.push(visibility)
        array.push(nubosidad)
        array.push(descripcion)


        var tds = '<tr>'
        array.forEach(element => {

          tds += '<td>' + element + '</td>'
        })
        tds += '</tr>'
        $('#tabla').append(tds)
      },
      error: function () {
        $('h3').html("Â¡Tenemos problemas! No puedo obtener JSON de <a href='http://openweathermap.org'>OpenWeatherMap</a>")
        $('h4').remove()
        $('pre').remove()
        $('p').remove()
      }
    })
  }

  verXML() {
    this.cargarDatos()
  }
}

class MeteoCali {
  constructor() {
    this.apikey = '?'
    this.ciudad = 'Cali'
    this.tipo = "&mode=xml";
    this.codigoPais = 'COL'
    this.unidades = '&units=metric'
    this.idioma = '&lang=es'
    this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + this.ciudad + this.tipo + this.unidades + this.idioma + "&APPID=" + this.apikey;
    this.correcto = "Â¡Todo correcto! JSON recibido de <a href='http://openweathermap.org'>OpenWeatherMap</a>"
  }
  cargarDatos() {
    $.ajax({
      dataType: 'xml',
      url: this.url,
      method: 'GET',
      success: function (datos) {
        // PresentaciÃ³n de los datos contenidos en XML
        var nombre = $('city', datos).attr("name");
        var pais = $('country', datos).text();
        var coorLat = $('coord', datos).attr("lat");
        var coorLon = $('coord', datos).attr("lon");
        var temperatura = $('temperature', datos).attr("value");
        var tempMax = $('temperature', datos).attr("max");
        var tempMin = $('temperature', datos).attr("min");
        var presion = $('pressure', datos).attr("value");
        var humedad = $('humidity', datos).attr("value");
        var amanecer = $('sun', datos).attr("rise");
        var minutosZonaHoraria = new Date().getTimezoneOffset();
        var amanecerMiliSeg1970 = Date.parse(amanecer);
        amanecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var amanecerLocal = (new Date(amanecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var oscurecer = $('sun', datos).attr("set");
        var oscurecerMiliSeg1970 = Date.parse(oscurecer);
        oscurecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var oscurecerLocal = (new Date(oscurecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var veloViento = $('speed', datos).attr("value");
        var horaMedida = $('lastupdate', datos).attr("value");
        var horaMedidaMiliSeg1970 = Date.parse(horaMedida);
        horaMedidaMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var horaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleTimeString("es-ES");
        var fechaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleDateString("es-ES");
        var visibility = $('visibility', datos).attr("value");
        var nubosidad = $('clouds', datos).attr("value");
        var descripcion = $('weather', datos).attr("value");
        var icon = $('weather', datos).attr("icon"); 
        var imagen=  "<img src="+  "'http://api.openweathermap.org/img/w/" + icon + ".png'" +  " />";
        var array = []

        array.push(imagen);
        array.push(nombre)
        array.push(pais)
        array.push(coorLat)
        array.push(coorLon)
        array.push(temperatura)
        array.push(tempMax)
        array.push(tempMin)
        array.push(presion)
        array.push(humedad)
        array.push(amanecerLocal)
        array.push(oscurecerLocal)
        array.push(veloViento)
        array.push(horaMedidaLocal)
        array.push(fechaMedidaLocal)
        array.push(visibility)
        array.push(nubosidad)
        array.push(descripcion)


        var tds = '<tr>'
        array.forEach(element => {

          tds += '<td>' + element + '</td>'
        })
        tds += '</tr>'
        $('#tabla').append(tds)
      },
      error: function () {
        $('h3').html("Â¡Tenemos problemas! No puedo obtener JSON de <a href='http://openweathermap.org'>OpenWeatherMap</a>")
        $('h4').remove()
        $('pre').remove()
        $('p').remove()
      }
    })
  }

  verXML() {
    this.cargarDatos()
  }
}

class MetoValencia {
  constructor() {
    this.apikey = '?'
    this.ciudad = 'Valencia'
    this.tipo = "&mode=xml";
    this.codigoPais = 'ES'
    this.unidades = '&units=metric'
    this.idioma = '&lang=es'
    this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + this.ciudad + this.tipo + this.unidades + this.idioma + "&APPID=" + this.apikey;
    this.correcto = "Â¡Todo correcto! JSON recibido de <a href='http://openweathermap.org'>OpenWeatherMap</a>"
  }
  cargarDatos() {
    $.ajax({
      dataType: 'xml',
      url: this.url,
      method: 'GET',
      success: function (datos) {
        // PresentaciÃ³n de los datos contenidos en XML
        var nombre = $('city', datos).attr("name");
        var pais = $('country', datos).text();
        var coorLat = $('coord', datos).attr("lat");
        var coorLon = $('coord', datos).attr("lon");
        var temperatura = $('temperature', datos).attr("value");
        var tempMax = $('temperature', datos).attr("max");
        var tempMin = $('temperature', datos).attr("min");
        var presion = $('pressure', datos).attr("value");
        var humedad = $('humidity', datos).attr("value");
        var amanecer = $('sun', datos).attr("rise");
        var minutosZonaHoraria = new Date().getTimezoneOffset();
        var amanecerMiliSeg1970 = Date.parse(amanecer);
        amanecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var amanecerLocal = (new Date(amanecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var oscurecer = $('sun', datos).attr("set");
        var oscurecerMiliSeg1970 = Date.parse(oscurecer);
        oscurecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var oscurecerLocal = (new Date(oscurecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var veloViento = $('speed', datos).attr("value");
        var horaMedida = $('lastupdate', datos).attr("value");
        var horaMedidaMiliSeg1970 = Date.parse(horaMedida);
        horaMedidaMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var horaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleTimeString("es-ES");
        var fechaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleDateString("es-ES");
        var visibility = $('visibility', datos).attr("value");
        var nubosidad = $('clouds', datos).attr("value");
        var descripcion = $('weather', datos).attr("value");
        var icon = $('weather', datos).attr("icon"); 
        var imagen=  "<img src="+  "'http://api.openweathermap.org/img/w/" + icon + ".png'" +  " />";
        var array = []

        array.push(imagen);
        array.push(nombre)
        array.push(pais)
        array.push(coorLat)
        array.push(coorLon)
        array.push(temperatura)
        array.push(tempMax)
        array.push(tempMin)
        array.push(presion)
        array.push(humedad)
        array.push(amanecerLocal)
        array.push(oscurecerLocal)
        array.push(veloViento)
        array.push(horaMedidaLocal)
        array.push(fechaMedidaLocal)
        array.push(visibility)
        array.push(nubosidad)
        array.push(descripcion)


        var tds = '<tr>'
        array.forEach(element => {

          tds += '<td>' + element + '</td>'
        })
        tds += '</tr>'
        $('#tabla').append(tds)
      },
      error: function () {
        $('h3').html("Â¡Tenemos problemas! No puedo obtener JSON de <a href='http://openweathermap.org'>OpenWeatherMap</a>")
        $('h4').remove()
        $('pre').remove()
        $('p').remove()
      }
    })
  }


  verXML() {
    this.cargarDatos()
  }
}

class MeteoSincelejo {
  constructor() {
    this.apikey = '?'
    this.ciudad = 'Sincelejo'
    this.tipo = "&mode=xml";
    this.codigoPais = 'COL'
    this.unidades = '&units=metric'
    this.idioma = '&lang=es'
    this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + this.ciudad + this.tipo + this.unidades + this.idioma + "&APPID=" + this.apikey;
    this.correcto = "Â¡Todo correcto! JSON recibido de <a href='http://openweathermap.org'>OpenWeatherMap</a>"
  }
  cargarDatos() {
    $.ajax({
      dataType: 'xml',
      url: this.url,
      method: 'GET',
      success: function (datos) {
        // PresentaciÃ³n de los datos contenidos en XML
        var nombre = $('city', datos).attr("name");
        var pais = $('country', datos).text();
        var coorLat = $('coord', datos).attr("lat");
        var coorLon = $('coord', datos).attr("lon");
        var temperatura = $('temperature', datos).attr("value");
        var tempMax = $('temperature', datos).attr("max");
        var tempMin = $('temperature', datos).attr("min");
        var presion = $('pressure', datos).attr("value");
        var humedad = $('humidity', datos).attr("value");
        var amanecer = $('sun', datos).attr("rise");
        var minutosZonaHoraria = new Date().getTimezoneOffset();
        var amanecerMiliSeg1970 = Date.parse(amanecer);
        amanecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var amanecerLocal = (new Date(amanecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var oscurecer = $('sun', datos).attr("set");
        var oscurecerMiliSeg1970 = Date.parse(oscurecer);
        oscurecerMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var oscurecerLocal = (new Date(oscurecerMiliSeg1970)).toLocaleTimeString("es-ES");
        var veloViento = $('speed', datos).attr("value");
        var horaMedida = $('lastupdate', datos).attr("value");
        var horaMedidaMiliSeg1970 = Date.parse(horaMedida);
        horaMedidaMiliSeg1970 -= minutosZonaHoraria * 60 * 1000;
        var horaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleTimeString("es-ES");
        var fechaMedidaLocal = (new Date(horaMedidaMiliSeg1970)).toLocaleDateString("es-ES");
        var visibility = $('visibility', datos).attr("value");
        var nubosidad = $('clouds', datos).attr("value");
        var descripcion = $('weather', datos).attr("value");
        var icon = $('weather', datos).attr("icon"); 
        var imagen=  "<img src="+  "'http://api.openweathermap.org/img/w/" + icon + ".png'" +  " />";
        var array = []

        array.push(imagen);
        array.push(nombre)
        array.push(pais)
        array.push(coorLat)
        array.push(coorLon)
        array.push(temperatura)
        array.push(tempMax)
        array.push(tempMin)
        array.push(presion)
        array.push(humedad)
        array.push(amanecerLocal)
        array.push(oscurecerLocal)
        array.push(veloViento)
        array.push(horaMedidaLocal)
        array.push(fechaMedidaLocal)
        array.push(visibility)
        array.push(nubosidad)
        array.push(descripcion)


        var tds = '<tr>'
        array.forEach(element => {

          tds += '<td>' + element + '</td>'
        })
        tds += '</tr>'
        $('#tabla').append(tds)
      },
      error: function () {
        $('h3').html("Â¡Tenemos problemas! No puedo obtener JSON de <a href='http://openweathermap.org'>OpenWeatherMap</a>")
        $('h4').remove()
        $('pre').remove()
        $('p').remove()
      }
    })
  }

  verXML() {
    this.cargarDatos()
  }
}
var meteoValencia = new MetoValencia()
var meteoOviedo = new Meteo()
var meteoBogota = new MeteoBogota()
var meteoCali = new MeteoCali()
var meteoSincelejo = new MeteoSincelejo()
