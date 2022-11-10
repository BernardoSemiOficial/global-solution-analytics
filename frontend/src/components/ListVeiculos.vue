<script lang="ts">
import router from "@/router";
import { defineComponent } from "vue";
import api from "../services/api";

export default defineComponent({
  name: "ListProducts",
  data() {
    return {
      veiculos: [
        {
          id: 26,
          marca: "Chevrolet",
          modelo: "Prisma",
          placaVeiculo: "FD1",
          quilometragem: 8.0,
          ambienteId: 0,
        },
        {
          id: 25,
          marca: "Fiat",
          modelo: "Uno",
          placaVeiculo: "AB123",
          quilometragem: 5.5,
          ambienteId: 0,
        },
      ],
    };
  },
  created() {
    this.getVeiculos();
  },
  methods: {
    getVeiculos() {
      api
        .get("/veiculos")
        .then((res) => {
          this.veiculos = res.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    editarVeiculo(id: number) {
      router.push(`/editar-veiculo/${id}`);
    },
    removeVeiculo(id: number) {
      api
        .delete(`/veiculos/${id}`)
        .then(() => {
          this.getVeiculos();
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
});
</script>

<template>
  <section class="container">
    <h1>Lista de veículos</h1>

    <table class="styled-table" v-if="veiculos.length > 0">
      <thead>
        <tr>
          <th>Marca</th>
          <th>Modelo</th>
          <th>Place</th>
          <th>Quilometragem</th>
          <th></th>
        </tr>
      </thead>
      <tbody v-for="veiculo in veiculos" :key="veiculo.id">
        <tr>
          <td>{{ veiculo.marca }}</td>
          <td>{{ veiculo.modelo }}</td>
          <td>{{ veiculo.placaVeiculo }}</td>
          <td>{{ veiculo.quilometragem }}</td>
          <td>
            <button class="btn-edit" @click="editarVeiculo(veiculo.id)">
              editar
            </button>
            <button class="btn-delete" @click="removeVeiculo(veiculo.id)">
              excluir
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div v-else>
      <p>A lista de veículos está vazia!</p>
    </div>
  </section>
</template>

<style scoped>
.container h1,
p {
  text-align: center;
  margin: 50px 30px;
}

p {
  font-size: 18px;
  color: #009879;
}
.styled-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
  background-color: #009879;
  color: #ffffff;
  text-align: left;
}

.styled-table th,
.styled-table td {
  padding: 12px 15px;
}

.styled-table tbody tr {
  border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
  border-bottom: 2px solid #009879;
}
.styled-table tbody tr.active-row {
  font-weight: bold;
  color: #009879;
}
.styled-table tbody .btn-edit,
.styled-table tbody .btn-delete {
  padding: 8px 10px;
  border: 1px solid #009879;
  margin: 0px 5px;
  cursor: pointer;
  border-radius: 5px;
  font-size: 16px;
  line-height: 16px;
  transition: 0.3s ease all;
}
.styled-table tbody .btn-edit:hover,
.styled-table tbody .btn-delete:hover {
  transform: scale(0.99);
  opacity: 0.8;
}
.styled-table tbody .btn-edit {
  background-color: #009879;
  color: #ffffff;
}
.styled-table tbody .btn-delete {
  background-color: transparent;
  color: #009879;
}
</style>
