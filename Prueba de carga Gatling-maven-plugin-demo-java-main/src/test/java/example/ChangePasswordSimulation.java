package example;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class ChangePasswordSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080") // Cambia según tu servidor
            .acceptHeader("text/html,application/xhtml+xml,application/xml")
            .contentTypeHeader("application/x-www-form-urlencoded");

    ScenarioBuilder scn = scenario("Simulación Cambio de Contraseña")
            .exec(
                    http("POST cambiar contrasena")
                            .post("/cambiar-contrasena")
                            .formParam("newPassword", "nueva123")
                            .formParam("confirmPassword", "nueva123")
                            .formParam("oldPassword", "vieja123")  // Ajusta según nombres en DTO
                            .check(status().is(302)) // Redirecciona a /perfil
            );

    {
        setUp(scn.injectOpen(atOnceUsers(50))).protocols(httpProtocol);
    }
}

