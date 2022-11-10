import { createRouter, createWebHistory } from "vue-router";
import CadastroVeiculo from "../views/CadastroVeiculo.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Cadastro veículo",
      component: CadastroVeiculo,
    },
    {
      path: "/cadastro-veiculo",
      name: "Cadastro veículo",
      component: CadastroVeiculo,
    },
    {
      path: "/editar-veiculo/:id",
      name: "Editar veículos",
      component: () => import("../views/EditarVeiculo.vue"),
    },
    {
      path: "/veiculos",
      name: "Veículos",
      component: () => import("../views/ProductsView.vue"),
    },
  ],
});

export default router;
