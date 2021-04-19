# accenture

Hola Buenas en este repositorio encontramos la solucion del punto 2.3 de la prueba de backend en spring boot java

al levantar el servidor .\mvnw.cmd spring-boot:run en la raiz encontraremos un mensaje de bienvenida

-/products encontraremos las rutas para obtener las listas de los productos productos

-/products/crear para  crear un producto esta recibe por metodo POST un nombre y un precio y le devolvera la lista de todos los productos
{
  "name":"manzana",
  "price":1000
}

-/products/borrar/{productoId}  para eliminar un producto se pasa a esta ruta el id del producto a eliminar

-/orders  aqui obtenemos la lista de pedidos realizados

-/orders/crear aqui crearemos el pedido por metodo post ejemplo se creara con la fecha actual y el estado abierto 

{
  "total":1000,
  "products:[{"id":1,"name":manzana,"price":1000}]
}


-/orders/borrar/{orderId} en esta ruta se podra cambiar el estado del pedido enviado por id para verificar si ya pasaron 12 horas si ya 
pasaron el pedido para a estado cancelado y el total sera por el 10% de la compra original y si no han pasado las 12 horas este pasara a estado eliminado


rene jose cardona herrera

renejosecardonaherrera@gmail.com
