# author: AlejandroPolo
# language: es

@viewProducts
Característica: Visualizar productos

  Yo como TAE(Test automation engineer)
  Quiero agregar varios productos
  Para  despues visualizarlos en la pagina de carrito de compras


  Antecedentes:
    Dado "alejandro" abre el sitio web
    Cuando ingresa las credenciales

  @viewTwoProductsYourCart
  Escenario: Visualiza productos en la pagina del carro de compras
    Cuando se autentica de forma exitosa y va hasta el carrito de compras
    Entonces visualizara los productos que anteriormente agrego