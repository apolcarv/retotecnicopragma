# author: AlejandroPolo
# language: es

@checkoutInComplete
Característica: Autenticación exitosa

  Yo como TAE(Test automation engineer)
  Quiero agregar varios productos
  Para  despues visualizarlos en la pagina de carrito de compras

  Antecedentes:
    Dado "alejandro" abre el sitio web
    Cuando ingresa las credenciales

  @OrderInComplete
  Escenario: Autenticación de usuario exitosa.
    Cuando se autentica de forma exitosa y realiza el proceso incompleto el formulario de datos de la compra
    Entonces visualizara un mensaje del formulario incompleto