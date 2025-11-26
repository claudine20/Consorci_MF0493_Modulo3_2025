<template>
  <div>
    <h1 class="mb-3">Car details</h1>
    <div v-if="loading" class="text-center">Loading...</div>
    <div v-if="error" class="alert alert-danger">{{ error }}</div>

    <div v-if="car" class="card p-3">
      <h3>{{ car.brand }} {{ car.model }}</h3>
      <p>Year: {{ car.year }}</p>
      <div class="d-flex gap-2">
        <router-link :to="`/edit/${car.id}`" class="btn btn-outline-secondary">Edit</router-link>
        <router-link to="/" class="btn btn-outline-primary">Back</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { useCarStore } from '../stores/carStore'

const route = useRoute()
const store = useCarStore()
const car = ref(null)
const loading = ref(false)
const error = ref(null)

const load = async () => {
  loading.value = true; error.value = null
  const data = await store.fetchCar(route.params.id)
  if (data) car.value = data
  else error.value = 'Car not found'
  loading.value = false
}

onMounted(load)
</script>
