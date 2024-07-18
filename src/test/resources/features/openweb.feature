#author: Rodrigo Castiblanco Pard
# language: es

Característica: Abrir una pagina web
  yo como tester de la empresa
  Quiero relizar una prueba de abrir una pagina
  Para comprobar la robustes y control de errores de la aplicacion o pagina web

  Antecedentes:
    Dado "Rodrigo" abre el sitio web de pruebas

  @successful
  Escenario: abrir navegador chrome en la pagina base
    Y desea validar la funcion de la carta elementos
    Cuando selecciona aleatoreamente alguna de las subfunciones
    Entonces vizualizara en la cabecera el nombre de la opcion elegida

