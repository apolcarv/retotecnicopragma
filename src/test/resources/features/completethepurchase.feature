# author: AlejandroPolo
# language: es
# se procede a crear la estructura, prosa y gramatica del gherkin en español, por buenas practicas.
# esto depende mucho de nuestro cliente

@checkoutComplete
Característica: Autenticación exitosa

  Yo como TAE(Test automation engineer)
  Quiero agregar varios productos
  Para  despues visualizarlos en la pagina de carrito de compras

  # Se crea Gherkin declarativo - ya que esta orientado a obtener el resultado deseado y es mucho mas claro
  # y asi evitamos el gherkin imperactivo, donde no es buena practica tener detalles tecnico
  # (Esto depende de la estrategia  y de acuerdo al gobierno de calidad del cliente)
  # recodar que es una prosa donde, se da claridad para personas tecnicas(dev) y no tenicas(user)

  Antecedentes:
    Dado "alejandro" abre el sitio web
    Cuando ingresa las credenciales

  @OrdenCompleteSuccessFul
  Escenario: Autenticación de usuario exitosa.
    Cuando se autentica de forma exitosa y realiza todo el proceso hasta completar el formulario de datos de la compra
    Entonces visualizara un mensaje y espera una validacion gracias por su compra