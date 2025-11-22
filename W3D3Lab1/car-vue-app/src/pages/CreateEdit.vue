<template>
  <div>
    <h1 class="mb-3">{{ isEdit ? 'Edit car' : 'Create car' }}</h1>

    <div class="card p-3">
      <form @submit.prevent="onSubmit">
        <div class="mb-3">
          <label class="form-label">Brand</label>
          <input v-model="form.brand" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">Model</label>
          <input v-model="form.model" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">Year</label>
          <input type="number" v-model.number="form.year" class="form-control" required />
        </div>

        <div class="d-flex gap-2">
          <button class="btn btn-primary" type="submit">{{ isEdit ? 'Save' : 'Create' }}</button>
          <router-link to="/" class="btn btn-outline-secondary">Cancel</router-link>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useCarStore } from '../stores/carStore'

const route = useRoute()
const router = useRouter()
const store = useCarStore()

const isEdit = ref(!!route.params.id)
const form = ref({ brand: '', model: '', year: new Date().getFullYear() })

onMounted(async () => {
  if (isEdit.value) {
    const data = await store.fetchCar(route.params.id)
    if (data) form.value = { brand: data.brand, model: data.model, year: data.year }
  }
})

const onSubmit = async () => {
  if (isEdit.value) {
    const updated = await store.editCar(route.params.id, form.value)
    if (updated) router.push('/')
  } else {
    const created = await store.addCar(form.value)
    if (created) router.push('/')
  }
}
</script>
