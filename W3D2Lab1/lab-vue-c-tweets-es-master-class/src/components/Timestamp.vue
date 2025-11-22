<script setup>
const props = defineProps({ timestamp: String })
</script>

<template>
    <span class="timestamp">{{ timestamp }}</span>
</template>