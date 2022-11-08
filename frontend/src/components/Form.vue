<script lang="ts">
import { defineComponent } from "vue";
import api from "../services/api";

interface FormData {
  veiculo: {
    marca: string;
    modelo: string;
    placaVeiculo: string;
    quilometragem: number;
    active: boolean;
  };
  isViewFeedback: boolean;
  isSuccess: boolean;
}

interface CreateVeiculo {
  marca: string;
  modelo: string;
  placaVeiculo: string;
  quilometragem: number;
}

export default defineComponent({
  name: "Form",
  data(): FormData {
    return {
      veiculo: {
        marca: "",
        modelo: "",
        placaVeiculo: "",
        quilometragem: 0,
        active: true,
      },
      isViewFeedback: false,
      isSuccess: true,
    };
  },
  methods: {
    async createVeiculo(product: CreateVeiculo) {
      const body = product;
      try {
        const response = await api.post("/analytics/veiculos", body);
        console.log(response);
        this.isViewFeedback = true;
        this.isSuccess = true;
      } catch (error) {
        this.isViewFeedback = true;
        this.isSuccess = false;
      }
    },
    handleCreateVeiculo(event: Event) {
      event.preventDefault();
      if (
        this.veiculo.marca != "" &&
        this.veiculo.modelo != "" &&
        this.veiculo.placaVeiculo != "" &&
        this.veiculo.quilometragem > 0
      ) {
        this.createVeiculo(this.veiculo);
      }
    },
  },
});
</script>

<template>
  <section class="cadastro">
    <h1>Cadastro de veículos</h1>
    <form class="form" @submit="handleCreateVeiculo($event)">
      <div class="form__field">
        <label for="marca">marca</label>
        <input type="text" name="marca" id="marca" v-model="veiculo.marca" />
      </div>
      <div class="form__field">
        <label for="modelo">modelo</label>
        <input type="text" name="modelo" id="modelo" v-model="veiculo.modelo" />
      </div>
      <div class="form__field">
        <label for="placaVeiculo">placa</label>
        <input
          type="text"
          name="placaVeiculo"
          id="placaVeiculo"
          v-model="veiculo.placaVeiculo"
        />
      </div>
      <div class="form__field">
        <label for="quilometragem">quilometragem</label>
        <input
          type="number"
          name="quilometragem"
          id="quilometragem"
          v-model="veiculo.quilometragem"
        />
      </div>
      <button type="submit">criar veículo</button>
    </form>
    <p
      class="feedback"
      :class="[isSuccess ? 'success' : 'error']"
      v-show="isViewFeedback"
    >
      {{
        isSuccess
          ? "Veículo criado com sucesso! =)"
          : "Não foi possível criar o veículo =("
      }}
    </p>
  </section>
</template>

<style scoped>
.cadastro {
  width: 400px;
}
.cadastro h1 {
  text-align: center;
  margin: 50px 30px;
}
.form {
  width: 100%;
}
.form__field {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-start;
  margin: 10px 0px;
}
.form__field label {
  margin-right: 30px;
  font-size: 16px;
  font-weight: bold;
  min-width: 100px;
}
.form__field input {
  width: 100%;
  border-radius: 8px;
  border: 2px solid #222222;
  padding: 6px 10px;
  font-size: 14px;
  font-weight: 400;
}
.form button {
  width: 100%;
  padding: 10px 10px;
  border: 2px solid #222222;
  background-color: #ffffff;
  font-size: 16px;
  font-weight: bold;
  border-radius: 8px;
  margin-top: 20px;
  cursor: pointer;
}
.feedback {
  margin: 20px 0px;
  text-align: center;
  font-size: 16px;
  font-weight: bold;
  border: 2px solid #2bff00;
  border-radius: 8px;
  padding: 8px;
}
.feedback.error {
  border: 2px solid #ca0a0a;
}
.feedback.success {
  border: 2px solid #2bff00;
}
</style>
