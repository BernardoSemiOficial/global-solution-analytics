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
    ambiente: {
      estado: string;
      cidade: string;
      bairro: string;
      tempAmbiente: number;
      qualidadeAr: string;
    };
  };
  isViewFeedback: boolean;
  isSuccess: boolean;
  veiculoId: string | string[];
}

interface Veiculo {
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
        ambiente: {
          estado: "",
          cidade: "",
          bairro: "",
          tempAmbiente: 0,
          qualidadeAr: "",
        },
        active: true,
      },
      isViewFeedback: false,
      isSuccess: true,
      veiculoId: this.$route.params.id,
    };
  },
  computed: {
    currentRouteName() {
      return this.$route.name;
    },
  },
  async created() {
    if (this.$route.name == "Editar veículos") {
      console.log(this.$route.params);

      api
        .get("/veiculos")
        .then((res) => {
          const veiculo = res.data.find(
            (veiculo: any) => veiculo.id == this.veiculoId
          );
          this.veiculo = veiculo;
        })
        .catch((error) => {
          console.log(error);
        });
    }
  },
  methods: {
    async createVeiculo(product: Veiculo) {
      const body = product;
      try {
        const response = await api.post("/veiculos", body);
        console.log(response);
        this.isViewFeedback = true;
        this.isSuccess = true;
      } catch (error) {
        this.isViewFeedback = true;
        this.isSuccess = false;
      }
    },
    async editVeiculo(product: Veiculo) {
      const body = product;
      try {
        const response = await api.put(`/veiculos/${this.veiculoId}`, body);
        console.log(response);
        this.isViewFeedback = true;
        this.isSuccess = true;
      } catch (error) {
        this.isViewFeedback = true;
        this.isSuccess = false;
      }
    },
    handleVeiculo(event: Event) {
      event.preventDefault();
      if (
        this.veiculo.marca != "" &&
        this.veiculo.modelo != "" &&
        this.veiculo.quilometragem > 0 &&
        this.veiculo.placaVeiculo != "" &&
        this.veiculo.ambiente.estado != "" &&
        this.veiculo.ambiente.cidade != "" &&
        this.veiculo.ambiente.bairro != "" &&
        this.veiculo.ambiente.qualidadeAr != "" &&
        this.veiculo.ambiente.tempAmbiente > 0
      ) {
        if (this.$route.name == "Editar veículos") {
          this.editVeiculo(this.veiculo);
        } else {
          this.createVeiculo(this.veiculo);
        }
      }
    },
  },
});
</script>

<template>
  <section class="cadastro">
    <h1 v-if="currentRouteName == 'Editar veículos'">Edição de veículo</h1>
    <h1 v-else>Cadastro de veículos</h1>
    <form class="form" @submit="handleVeiculo($event)">
      <div class="form__field">
        <label for="marca">marca</label>
        <input
          type="text"
          name="marca"
          id="marca"
          v-model="veiculo.marca"
          placeholder="Ford"
        />
      </div>
      <div class="form__field">
        <label for="modelo">modelo</label>
        <input
          type="text"
          name="modelo"
          id="modelo"
          v-model="veiculo.modelo"
          placeholder="Fordka"
        />
      </div>
      <div class="form__field">
        <label for="placaVeiculo">placa</label>
        <input
          type="text"
          name="placaVeiculo"
          id="placaVeiculo"
          placeholder="ABC123"
          v-model="veiculo.placaVeiculo"
        />
      </div>
      <div class="form__field">
        <label for="quilometragem">quilometragem</label>
        <input
          type="number"
          name="quilometragem"
          id="quilometragem"
          placeholder="4.5"
          v-model="veiculo.quilometragem"
        />
      </div>
      <div class="form__field">
        <label for="estado">estado</label>
        <input
          type="text"
          name="estado"
          id="estado"
          placeholder="SP"
          v-model="veiculo.ambiente.estado"
        />
      </div>
      <div class="form__field">
        <label for="cidade">cidade</label>
        <input
          type="text"
          name="cidade"
          id="cidade"
          placeholder="São Paulo"
          v-model="veiculo.ambiente.cidade"
        />
      </div>
      <div class="form__field">
        <label for="bairro">bairro</label>
        <input
          type="text"
          name="bairro"
          id="bairro"
          placeholder="Paulista"
          v-model="veiculo.ambiente.bairro"
        />
      </div>
      <div class="form__field">
        <label for="qualidadeAr">qualidade do ar</label>
        <input
          type="string"
          name="qualidadeAr"
          id="qualidadeAr"
          placeholder="ótimo"
          v-model="veiculo.ambiente.qualidadeAr"
        />
      </div>

      <div class="form__field">
        <label for="tempAmbiente">temperatura ambiente</label>
        <input
          type="number"
          name="tempAmbiente"
          id="tempAmbiente"
          v-model="veiculo.ambiente.tempAmbiente"
        />
      </div>
      <button v-if="currentRouteName == 'Editar veículos'">
        editar veículo
      </button>
      <button v-else type="submit">criar veículo</button>
    </form>
    <p
      class="feedback"
      :class="[isSuccess ? 'success' : 'error']"
      v-if="isViewFeedback && currentRouteName == 'Editar veículos'"
    >
      {{
        isSuccess
          ? "Veículo editado com sucesso! =)"
          : "Não foi possível editar o veículo =("
      }}
    </p>
    <p
      class="feedback"
      :class="[isSuccess ? 'success' : 'error']"
      v-else-if="isViewFeedback"
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
  width: 450px;
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
  min-width: 180px;
}
.form__field input {
  width: 100%;
  border-radius: 8px;
  border: 2px solid #222222;
  padding: 6px 10px;
  font-size: 14px;
  font-weight: 400;
}
.form__field input::placeholder {
  opacity: 0.6;
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
