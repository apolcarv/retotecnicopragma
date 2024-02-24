# author: AlejandroPolo
# language: es

@deleteProducts
Característica: Elimina los productos

  Yo como TAE(Test automation engineer)
  Quiero agregar varios productos
  Para  despues visualizarlos en la pagina de carrito de compras


  Antecedentes:
    Dado "alejandro" abre el sitio web
    Cuando ingresa las credenciales

  @deleteTwoProductsYourCart
  Escenario: Visualiza productos en la pagina del carro de compras
    Cuando se autentica de forma exitosa y va hasta el carrito de compras
    Entonces visualizara la eliminacion de los  productos que fueron agregados anteriormente