

Micro-service de gestion de comptes bancaires avec Spring Boot 4.

## Technologies
- Java 17, Spring Boot 4.0.10, Maven
- Spring Data JPA, base H2 en mémoire, Lombok
- API REST, Swagger / OpenAPI (springdoc)
- Spring Data REST avec projections
- DTO, mappers et couche service
- GraphQL (Spring for GraphQL)

## Lancer le projet
```bash
./mvnw spring-boot:run
```
Sous Windows : `.\mvnw.cmd spring-boot:run`. L'application démarre sur le port 8081.

## Points d'accès
| Fonction | URL |
|---|---|
| API REST | http://localhost:8081/api-rest/comptes |
| Swagger UI | http://localhost:8081/swagger-ui/index.html |
| Spring Data REST | http://localhost:8081/api/comptes |
| Projection | http://localhost:8081/api/comptes?projection=mobile |
| Recherche par type | http://localhost:8081/api/comptes/search/byType?t=COURANT |
| GraphiQL | http://localhost:8081/graphiql |
| Console H2 | http://localhost:8081/h2-console |

## Structure
`entities`, `repositories`, `dto`, `mappers`, `service`, `web`.
