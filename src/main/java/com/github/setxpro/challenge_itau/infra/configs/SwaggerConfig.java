package com.github.setxpro.challenge_itau.infra.configs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Challenge ITAU REST API")
                        .description("Transaction service")
                        .version("1.0.0")
                        .license(new License()
                                .name("Patrick Anjos")
                                .url("https://github.com/setxpro"))
                        .contact(new Contact()
                                .name("Patrick Anjos")
                                .url("https://github.com/setxpro")
                                .email("patrickpqdt87289@gmail.com")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github.com/setxpro")
                );
    }

    @Bean
    OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
                    .forEach(operation -> {
                        ApiResponses apiResponse = operation.getResponses();
                        apiResponse.addApiResponse("200", createApiResponse("Sucesso!"));
                        apiResponse.addApiResponse("201", createApiResponse("Objeto persistido!"));
                        apiResponse.addApiResponse("204", createApiResponse("Objeto excluído!"));
                        apiResponse.addApiResponse("400", createApiResponse("Erro na requisição!"));
                        apiResponse.addApiResponse("401", createApiResponse("Acesso não autorizado!"));
                        apiResponse.addApiResponse("403", createApiResponse("Acesso Proibido!"));
                        apiResponse.addApiResponse("404", createApiResponse("Objeto não encontrado!"));
                        apiResponse.addApiResponse("500", createApiResponse("Erro na aplicação!"));
                    }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}
