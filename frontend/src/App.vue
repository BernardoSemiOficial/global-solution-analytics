<script lang="ts">
import { defineComponent } from "vue";
import { RouterLink, RouterView } from "vue-router";

export default defineComponent({
  name: "App",
  components: {
    RouterLink,
    RouterView,
  },
  computed: {
    isRoutePathVeiculos() {
      return this.$route.path.includes("/editar-veiculo");
    },
  },
});
</script>

<template>
  <nav class="navigation">
    {{ currentRouteName }}
    <RouterLink to="/cadastro-veiculo">Cadastro</RouterLink>
    <RouterLink v-if="isRoutePathVeiculos" to="/veiculos"> Editar </RouterLink>
    <RouterLink to="/veiculos">Listagem</RouterLink>
  </nav>
  <RouterView />
</template>

<style scoped></style>
