<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
      <div class="container">
        <router-link class="navbar-brand" to="/">Cars</router-link>
        <div class="d-flex">
          <router-link class="btn btn-outline-primary me-2" to="/">Home</router-link>
          <router-link class="btn btn-primary" to="/create">Create car</router-link>
        </div>
      </div>
    </nav>

    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script setup></script>
<style>

</style>