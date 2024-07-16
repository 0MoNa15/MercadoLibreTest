# Aplicación de productos - MeLi 🤝
By MoNa15Dev


![Kotlin](https://img.shields.io/badge/kotlin-1.9.0-blue)
![Retrofit](https://img.shields.io/badge/retrofit-2.9.0-yellowgreen)
![Coroutines](https://img.shields.io/badge/coroutines-1.8.1-yellowgreen)
![Navigation](https://img.shields.io/badge/navigation-2.8.0-orange)
![Room](https://img.shields.io/badge/room-2.6.1-blue)
![Hilt](https://img.shields.io/badge/hilt-2.48-brightgreen)
![Gson](https://img.shields.io/badge/gson-2.9.0-yellowgreen)

# Pantallazos del app

<table>
    <tr>
    <td><img src="/images/image_splash.png"></td>
    <td><img src="/images/image_search_empty.png"></td>
    <td><img src="/images/image_search.png"></td>
    <td><img src="/images/image_list.png"></td>
    <td><img src="/images/image_detail.png"></td>
    </tr>
</table>

# Arquitectura

- Clean Arquitecture: [Arquitectura recomendada por Android](https://developer.android.com/jetpack/guide?gclid=Cj0KCQjwqoibBhDUARIsAH2OpWjcfMYRBW8Kfi9W2ibch4_xQb8NlUmuwjgMaMoAUxDQsYpKKTKG2L0aAjhnEALw_wcB&gclsrc=aw.ds#recommended-app-arch), utilizando módulos para representar cada una de las 3 capas data, domain, UI (en este caso app).
- Uso de diseño orientado al dominio: [DDD](https://en.wikipedia.org/wiki/Domain-driven_design#:~:text=Domain%2Ddriven%20design%20(DDD),which%20have%20their%20own%20model.)
- Patrón de diseño arquitectónico para la capa de UI(app) : [MVVM](https://developer.android.com/topic/libraries/architecture/viewmodel)

## Patrones de diseño utilizados

- [Singleton](https://sourcemaking.com/design_patterns/singleton)
- [Repository](https://learn.microsoft.com/en-us/dotnet/architecture/microservices/microservice-ddd-cqrs-patterns/infrastructure-persistence-layer-design)
- [Inyección de dependencias](https://developer.android.com/training/dependency-injection?hl=es-419)
- [Anticorrupción](https://docs.aws.amazon.com/es_es/prescriptive-guidance/latest/cloud-design-patterns/acl.html)
- [Builder](https://sourcemaking.com/design_patterns/builder)

## Manejo de excepciones

- [UncaughtExceptionHandler](https://developer.android.com/reference/java/lang/Thread.UncaughtExceptionHandler)


# Para correr el proyecto
- Android Studio Koala | [2024.1.1](https://developer.android.com/studio/releases?hl=es-419)
- Versión de Android mínima 7.0 (Nougat)








