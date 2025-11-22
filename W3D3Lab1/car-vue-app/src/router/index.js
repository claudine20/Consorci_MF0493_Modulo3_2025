import { createRouter, createWebHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import CreateEdit from '../pages/CreateEdit.vue'
import Detail from '../pages/Detail.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/create', name: 'Create', component: CreateEdit },
  { path: '/edit/:id', name: 'Edit', component: CreateEdit, props: true },
  { path: '/cars/:id', name: 'Detail', component: Detail, props: true },
  { path: '/:pathMatch(.*)*', redirect: '/' }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
