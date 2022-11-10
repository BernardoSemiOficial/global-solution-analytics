<script lang="ts">
import { defineComponent } from "vue";
import Form from "../components/Form.vue";

export default defineComponent({
  name: "EditarVeiculo",
  components: {
    Form,
  },
});
</script>

<template>
  <main class="editar-veiculo-view">
    <Form />
  </main>
</template>
