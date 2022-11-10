<script lang="ts">
import { defineComponent } from "vue";
import Form from "../components/Form.vue";

export default defineComponent({
  name: "CadastroVeiculo",
  components: {
    Form,
  },
});
</script>

<template>
  <main class="cadastro-veiculo-view">
    <Form />
  </main>
</template>
