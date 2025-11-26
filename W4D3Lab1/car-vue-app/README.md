# Car Vue Frontend

Proyecto frontend en **Vue 3 (Composition API, script setup)** que consume una API de coches.

## Características
- Vue 3 + Vite
- Pinia store
- Vue Router
- Bootstrap para estilos
- .env (VITE_API_URL) para configurar la URL de la API
- Dockerfile y docker-compose para build y despliegue

## Usar localmente
1. Instalar dependencias:
   ```bash
   npm install
   ```
2. Crear `.env` con la variable `VITE_API_URL` (ejemplo: `VITE_API_URL=http://localhost:8080/api`)
3. Levantar en desarrollo:
   ```bash
   npm run dev
   ```

## Build y Docker
Para construir la imagen y cambiar la URL de la API en build time:
```bash
# ejemplo: usar host.docker.internal para apuntar a la API que corre en host
VITE_API_URL=http://host.docker.internal:8080/api docker-compose up --build
```

La aplicación quedará expuesta en http://localhost:8081
