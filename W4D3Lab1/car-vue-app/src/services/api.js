import axios from 'axios'

// La URL base se toma de la variable VITE_API_URL definida en .env o en tiempo de build
const apiUrl = import.meta.env.VITE_API_URL || 'http://localhost:8080/api'
const api = axios.create({ baseURL: apiUrl })

export const getCars = (params) => api.get('/cars', { params })
export const getCar = (id) => api.get(`/cars/${id}`)
export const createCar = (data) => api.post('/cars', data)
export const updateCar = (id, data) => api.put(`/cars/${id}`, data)
export const deleteCar = (id) => api.delete(`/cars/${id}`)

export default api
