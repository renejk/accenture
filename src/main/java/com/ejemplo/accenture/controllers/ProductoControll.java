package com.ejemplo.accenture;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.ejemplo.accenture.models.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;  


@RestController
@RequestMapping("/")
public class ProductoControll {
    List<ProductoModel> products = new ArrayList<ProductoModel>();
    List<PedidoModel> orders = new ArrayList<PedidoModel>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm");

    @GetMapping
    public String hola(){
  
        return "<h1>Hola Mundo</h1>"+
        "<br>"+
        "<h2>Api para prueba accenture</h2>";
    }

    @RequestMapping(value ="/products",method =RequestMethod.GET)
    public ResponseEntity<List<ProductoModel>> getProduct (){
        return ResponseEntity.ok(products);
    }

    @RequestMapping(value ="/products/crear",method =RequestMethod.POST)
    public ResponseEntity<List<ProductoModel>> crearProducto(@RequestBody ProductoModel product) {        
        if (!products.isEmpty()) { 
            ProductoModel lastElement =  products.get(products.size()-1);          
            product.setId(lastElement.getId()+1);
         }else{
            product.setId(1);
         }
        products.add(product);
        return ResponseEntity.ok(products);    }

    @RequestMapping(value ="/products/borrar/{productoId}")
    public ResponseEntity<List<ProductoModel>> borrarById(@PathVariable("productoId") int productoId) {
        products.removeIf(p->(p.getId()==productoId));
        return ResponseEntity.ok(products);
    }

    //Pedidos

    @RequestMapping(value ="/orders",method =RequestMethod.GET)
    public ResponseEntity<List<PedidoModel>> getOrder (){
        System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        System.out.println("HH:mm:ss-> "+hour.format(LocalDateTime.now()));
        return ResponseEntity.ok(orders);
    }

    @RequestMapping(value ="/orders/crear",method =RequestMethod.POST)
    public ResponseEntity<List<PedidoModel>> crearOrder(@RequestBody PedidoModel order) {        
        if (!orders.isEmpty()) { 
          PedidoModel lastElement =  orders.get(orders.size() - 1);          
          order.setId(lastElement.getId()+1);
          
         }else{
             order.setId(1);
         }
        order.setFecha(LocalDateTime.now());
        order.setEstado("abierto");
       
        orders.add(order);

        return ResponseEntity.ok(orders);
    }

    @RequestMapping(value ="/orders/borrar/{orderId}")
    public ResponseEntity<PedidoModel> borrarOrderById(@PathVariable("orderId") int orderId) {
        PedidoModel seleccion=null;
        int indice=0;

        for(int i = 0; i <orders.size(); i++) {
            if(orders.get(i).getId()==orderId) {
                seleccion = orders.get(i);
                indice=i;
                break;
            }else{
                seleccion = null;
            }
        }
        if(seleccion!=null){        

            int tiempo = (int) ChronoUnit.HOURS.between(LocalDateTime.now(), seleccion.getFecha());
            if (tiempo<=12){                
                orders.get(indice).setEstado("eliminado");                
            }else{
                double total= orders.get(indice).getTotal();
                orders.get(indice).setTotal(total*10/100);
                orders.get(indice).setEstado("cancelado");   
            }

        }else{           
            System.out.println("no se encontro pedido"); 
        }        
        return ResponseEntity.ok(seleccion);
    }


}