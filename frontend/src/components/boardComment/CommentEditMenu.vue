<template>
  <div>
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn large icon color="indigo" v-bind="attrs" v-on="on">
          <v-icon>more_horiz</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item
            v-for="(item, index) in items" :key="index">
          <v-icon class="iconBox">{{ item.icon }}</v-icon>
          <v-list-item-title class="iconBox">{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
export default {
  name: "CommentEditMenu",
  data() {
    return {
      items: [
        { title: '수정', icon: 'edit' },
        { title: '삭제', icon: 'delete' },
      ],
    }
  }
}
</script>

<style scoped>
.iconBox{
  margin: 0 3px;
  cursor: pointer;
}
</style>
