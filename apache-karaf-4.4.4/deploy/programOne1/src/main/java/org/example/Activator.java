package org.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
private ServiceRegistration registration;

public  void start(BundleContext context){
    obtenerMensajeKaraf servicio = new GenerarMensaje();
    registration = context.registerService(obtenerMensajeKaraf.class.getName(), servicio, null);
}

public void stop(BundleContext context){
    registration.unregister();
}
}
