import { defineStore } from 'pinia'
import { ref } from 'vue'
import * as api from '../services/api'

export const useCarStore = defineStore('car', () => {
  const cars = ref([])
  const loading = ref(false)
  const error = ref(null)

  const fetchCars = async (params) => {
    loading.value = true; error.value = null
    try {
      const res = await api.getCars(params)
      cars.value = res.data
    } catch (e) {
      console.error(e); error.value = 'Could not load cars'
    } finally {
      loading.value = false
    }
  }

  const fetchCar = async (id) => {
    loading.value = true; error.value = null
    try {
      const res = await api.getCar(id)
      return res.data
    } catch (e) {
      console.error(e); error.value = 'Could not load car'
      return null
    } finally {
      loading.value = false
    }
  }

  const addCar = async (data) => {
    loading.value = true; error.value = null
    try {
      const res = await api.createCar(data)
      cars.value.push(res.data)
      return res.data
    } catch (e) {
      console.error(e); error.value = 'Could not create car'
      return null
    } finally {
      loading.value = false
    }
  }

  const editCar = async (id, data) => {
    loading.value = true; error.value = null
    try {
      const res = await api.updateCar(id, data)
      const idx = cars.value.findIndex(c => c.id === res.data.id)
      if (idx !== -1) cars.value[idx] = res.data
      return res.data
    } catch (e) {
      console.error(e); error.value = 'Could not update car'
      return null
    } finally {
      loading.value = false
    }
  }

  const removeCar = async (id) => {
    loading.value = true; error.value = null
    try {
      await api.deleteCar(id)
      cars.value = cars.value.filter(c => c.id !== id)
      return true
    } catch (e) {
      console.error(e); error.value = 'Could not delete car'
      return false
    } finally {
      loading.value = false
    }
  }

  return { cars, loading, error, fetchCars, fetchCar, addCar, editCar, removeCar }
})
