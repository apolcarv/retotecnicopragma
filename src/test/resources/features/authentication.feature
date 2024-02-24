# author: AlejandroPolo
# language: es
# se procede a crear la estructura, prosa y gramatica del gherkin en español, por buenas practicas.
# esto depende mucho de nuestro cliente

@authenticationLogin
Característica: Autenticación exitosa

  Yo como TAE(Test automation engineer)
  Quiero realizar una prueba de autenticación al sitio web
  Para comprobar la robustes y control de errores del aplicativo web, funcione correctamente

  # Se crea Gherkin declarativo - ya que esta orientado a obtener el resultado deseado y es mucho mas claro
  # y asi evitamos el gherkin imperactivo, donde no es buena practica tener detalles tecnico
  # (Esto depende de la estrategia  y de acuerdo al gobierno de calidad del cliente)
  # recodar que es una prosa donde, se da claridad para personas tecnicas(dev) y no tenicas(user)

  Antecedentes:
    Dado "alejandro" abre el sitio web

  @authenticationSuccess
  Escenario: Autenticación de usuario exitosa.
    Cuando ingresa las credenciales
    Entonces visualizara el home y espera una validacion
