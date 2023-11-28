package org.example2;

import org.example.obtenerMensajeKaraf;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;
    public void start(BundleContext context) {
        GenerarMensaje2 generadorB = new GenerarMensaje2();
        String nombresB = generadorB.obtenerMensaje2();

        System.out.println(nombresB);

        // Registra el servicio GeneradorDeNombresB
        registration = context.registerService(GenerarMensaje2.class.getName(), generadorB, null);
        ServiceReference reference = context.getServiceReference(obtenerMensajeKaraf.class.getName());
        if (reference != null) {
            obtenerMensajeKaraf generadorA = (obtenerMensajeKaraf) context.getService(reference);
            String nombresA = generadorA.obtenerMensaje();

                System.out.println(nombresA);
        }
    }
    public void stop(BundleContext context) {
        registration.unregister();
    }
}
