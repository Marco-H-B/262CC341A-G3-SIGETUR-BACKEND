# SIGETUR Backend (Caso 12 - PERÚ TOURS)

Backend en Spring Boot para el curso **CC341A - Ingeniería de Software**.

**Integrantes**: Marco Antonio Huamani Bonifacio y Sebastián Ángel Berrú Ninahuanca.

---

## 1. Requisitos y Arranque Local

- **Java:** 25
- **Base de datos:** PostgreSQL (`sigetur_db`, esquema `sigetur`)
- **Puerto:** `8080`
- **Swagger UI:** `http://localhost:8080/docs`

### Configuración de `.env`

En la raíz del proyecto (`sigetur.backend/`), crear un archivo `.env` con:

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/sigetur_db?currentSchema=sigetur
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=tu_password
```

### Comandos útiles

```powershell
# Verificar compilación
.\mvnw.cmd test-compile

# Arrancar servidor
.\mvnw.cmd spring-boot:run
```

---

## 2. Flujo de Ramas Git (Marco y Sebastián)

- `main`: código estable para la exposición. **No subimos avances diarios aquí**; recién un día antes de la expo (lunes 30/11), con todo probado, pasamos `developer` a `main`.
- `developer`: rama principal de trabajo e integración donde ambos unimos avances y resolvemos problemas durante el desarrollo.
- Ramas personales (se crean desde `developer`):
    - `marco-work`: trabajo de Marco.
    - `sebastian-work`: trabajo de Sebastián.

### Como vamos a trabajar

```powershell
# Crear tu rama desde developer
git switch developer
git pull origin developer
git switch -c sebastian-work

# Cambiar de rama
git switch developer
```

### Convención de Commits

Usar prefijos en mayúsculas y en español:

- `FEAT(modulo): ...` nueva funcionalidad o clase
- `FIX(modulo): ...` corrección de error o bug
- `DOCS(archivo): ...` documentación o README
- `STYLE(modulo): ...` formato visual (espacios, sangría), sin cambiar lógica
- `REFACTOR(modulo): ...` mejora interna sin cambiar comportamiento
- `PERF(modulo): ...` mejora de rendimiento
- `TEST(modulo): ...` agregar o corregir pruebas
- `BUILD(modulo) / CHORE(modulo): ...` cambios en Maven, dependencias o configuración de build

---

## 3. Alcance Actual (PC5 - 01/12/2026)

Arquitectura por capas en `pe.edu.uni.sigetur.backend`:
`util` -> `model` -> `repository` -> `dto` -> `service` -> `controller`

- **CUN-02:** Cotizar Paquete Turístico a Medida (`solicitud_paquete`, `cotizacion`, `item_cotizacion`)
- **CUN-03:** Gestionar Venta y Pago de Paquete (`pago`, `constancia_viaje`)
