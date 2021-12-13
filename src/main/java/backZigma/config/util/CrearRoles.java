package backZigma.config.util;

import backZigma.security.entity.Rol;
import backZigma.security.enums.RolNombre;
import backZigma.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CrearRoles implements CommandLineRunner {
    @Autowired
    RolService rolService;
    @Override
    public void run(String... args) throws Exception {
    /* Rol rolAdmin = new Rol(RolNombre.ROL_ADMIN);
     Rol rolUser = new Rol(RolNombre.ROL_USER);
      rolService.save(rolAdmin);
      rolService.save(rolUser);*/
    }
}
