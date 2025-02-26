<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
    <button @click="fetchData">get data</button>
  </div>
</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
import {getAPI} from '@/api';
@Options({
  components: {
    HelloWorld,
  },
})
export default class HomeView extends Vue {
  fetchData() {
    getAPI();
  }
}
</script>
