<template>
  <div>
    <h1 class="mb-3">Cars</h1>

    <!-- <div class="mb-3 d-flex gap-2">
      <input v-model="q" @keyup.enter="load" class="form-control" placeholder="Search by model or brand..." />
      <button class="btn btn-primary" @click="load">Search</button>
      <button class="btn btn-outline-secondary" @click="reset">Reset</button>
    </div> -->

    <div v-if="store.loading" class="text-center">Loading...</div>
    <div v-if="store.error" class="alert alert-danger">{{ store.error }}</div>

    <div class="row gy-3">
      <div class="col-12 col-md-6" v-for="car in store.cars" :key="car.id">
        <div class="card">
          <div class="card-body d-flex justify-content-between align-items-center">
            <div>
              <h5 class="card-title">{{ car.brand }} {{ car.model }}</h5>
              <p class="card-text">Year: {{ car.year }}</p>
            </div>
            <div class="d-flex flex-column align-items-end">
              <router-link :to="`/cars/${car.id}`" class="btn btn-sm btn-outline-primary mb-2">Details</router-link>
              <router-link :to="`/edit/${car.id}`" class="btn btn-sm btn-outline-secondary mb-2">Edit</router-link>
              <button class="btn btn-sm btn-danger" @click="onDelete(car.id)">Delete</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div v-if="!store.loading && store.cars.length === 0" class="mt-3">No cars found.</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useCarStore } from '../stores/carStore'
import { useRouter } from 'vue-router'

const store = useCarStore()
const q = ref('')
const router = useRouter()

const load = () => {
  const params = q.value ? { q: q.value } : {}
  store.fetchCars(params)
}

const reset = () => { q.value = ''; load() }

const onDelete = async (id) => {
  if (!confirm('Are you sure you want to delete this car?')) return
  const ok = await store.removeCar(id)
  if (ok) alert('Deleted')
}

onMounted(() => load())
</script>
