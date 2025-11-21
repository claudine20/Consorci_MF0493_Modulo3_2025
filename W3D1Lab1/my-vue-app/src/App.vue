<script setup>
</script>

<template>
  <div id="app">
  <header>
  </header>

  <main>
    <div class="content-images-container">
      <img alt="Vue logo" class="content-image" src="./images/Header.png"  />
      <img alt="Intro section image" class="content-image" src="./images/IntroSection.png"  />
      <img alt="USPs image" class="content-image" src="./images/USPs.png" />
    </div>
  </main>

  </div>
</template>

<style scoped>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 50px;
}

.content-images-container{
  width: 100%; /* Asegura que ocupe todo el ancho disponible */
  margin-bottom: 2rem;
  /* Usamos Flexbox para centrar las imágenes si son más pequeñas que el contenedor */
  display: flex;
  flex-direction: column; /* Apila las imágenes verticalmente */
  align-items: center; /* Centra las imágenes horizontalmente */
  justify-content: center; /* Centra las imágenes horizontalmente */
}

.content-image {
  /* ¡CLAVE! Hacemos que la imagen sea de bloque */
  display: block;
  /* El contenedor .content-images-container ya está centrando,
     pero mantenemos un margen inferior para separarlas. */
  margin-bottom: 2rem;
  /* NOTA: Eliminamos el 'margin: 0 auto;' de aquí, ya que el Flexbox del padre lo hace */
}
@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;

  }

}
</style>
