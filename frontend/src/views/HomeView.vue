<script lang="ts">
  import { defineComponent } from 'vue';
  import Form from '../components/Form.vue'

  export default defineComponent({
    name: "Home",
    components: {
      Form,
    }
  })
</script>

<template>
  <main class="home-view">
    <Form />
  </main>
</template>
