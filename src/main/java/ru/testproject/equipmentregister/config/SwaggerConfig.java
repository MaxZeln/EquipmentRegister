package ru.testproject.equipmentregister.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(

        info = @Info(

                title = "Equipment Registry Api",

                description = "Equipment Registry", version = "1.0.0",

                contact = @Contact(

                        name = "Zabelin Maxim",

                        email = "zabelin.maxim.al@gmail.com"

                )

        )

)

public class SwaggerConfig {


}