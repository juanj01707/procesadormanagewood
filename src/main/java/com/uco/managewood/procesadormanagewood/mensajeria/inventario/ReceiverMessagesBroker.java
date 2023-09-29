package com.uco.managewood.procesadormanagewood.mensajeria.inventario;

import com.uco.managewood.procesadormanagewood.domain.inventario.Inventario;
import com.uco.managewood.procesadormanagewood.service.inventario.InventarioService;
import com.uco.managewood.procesadormanagewood.util.gson.MapperJsonObjeto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ReceiverMessagesBroker {
    @Autowired
    private InventarioService inventarioService;

    private final MapperJsonObjeto mapperJsonObjeto;

    public ReceiverMessagesBroker(MapperJsonObjeto mapperJsonObjeto) {
        this.mapperJsonObjeto = mapperJsonObjeto;
    }


    @RabbitListener(queues = "${inventario.procesar.queue-name}")
    public void receiveMessageProcessInventario(String message) {
        try {
            System.out.println("El mensaje de rabbit llego "+message);
            System.out.println(obtenerObjetoDeMensaje(message).get().getNombre());
            inventarioService.saveInventario(obtenerObjetoDeMensaje(message).get());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Optional<Inventario> obtenerObjetoDeMensaje(String mensaje) {
        return mapperJsonObjeto.ejecutar(mensaje, Inventario.class);
    }

}
