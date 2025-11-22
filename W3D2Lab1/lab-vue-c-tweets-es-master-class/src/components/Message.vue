<script setup>
const props = defineProps({ message: String })
</script>

<template>
    <p class="message">
        {{ message }}
    </p>
</template>