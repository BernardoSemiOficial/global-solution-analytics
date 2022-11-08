<script lang="ts">
import { defineComponent } from "vue";
import ListVeiculos from "../components/ListVeiculos.vue";

export default defineComponent({
  name: "Veiculos",
  components: {
    ListVeiculos,
  },
});
</script>

<template>
  <main class="products-view">
    <section>
      <ListVeiculos />
    </section>
  </main>
</template>

<style scoped></style>
